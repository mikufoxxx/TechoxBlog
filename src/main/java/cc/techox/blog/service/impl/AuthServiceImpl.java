package cc.techox.blog.service.impl;

import cc.techox.blog.common.BusinessException;
import cc.techox.blog.common.ErrorCode;
import cc.techox.blog.model.dto.user.LoginDTO;
import cc.techox.blog.model.dto.user.RefreshTokenDTO;
import cc.techox.blog.model.entity.User;
import cc.techox.blog.model.vo.user.LoginResultVO;
import cc.techox.blog.model.vo.user.RefreshTokenVO;
import cc.techox.blog.model.vo.user.UserProfileVO;
import cc.techox.blog.repository.UserRepository;
import cc.techox.blog.security.JwtUtil;
import cc.techox.blog.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 认证业务实现类
 * @author MikuFox
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    // Token黑名单（生产建议用Redis）
    private static final Map<String, Instant> tokenBlacklist = new ConcurrentHashMap<>();

    @Override
    public LoginResultVO login(LoginDTO loginDTO) {
        // 支持用户名或邮箱登录
        Optional<User> userOpt = userRepository.findByUsername(loginDTO.getUsername());
        if (!userOpt.isPresent()) {
            userOpt = userRepository.findByEmail(loginDTO.getUsername());
        }
        User user = userOpt.orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_INCORRECT);
        }
        if ("disabled".equals(user.getRole())) {
            throw new BusinessException(ErrorCode.USER_DISABLED);
        }
        // 生成token和refreshToken
        String token = jwtUtil.generateToken(user.getId(), user.getRole());
        String refreshToken = jwtUtil.generateRefreshToken(user.getId());
        Instant expireTime = jwtUtil.getExpireTime(token);
        // 封装VO
        LoginResultVO vo = new LoginResultVO();
        vo.setToken(token);
        vo.setRefreshToken(refreshToken);
        vo.setExpireTime(expireTime.toString());
        UserProfileVO userInfo = new UserProfileVO();
        BeanUtils.copyProperties(user, userInfo);
        userInfo.setCreateTime(user.getCreateTime().toString());
        vo.setUserInfo(userInfo);
        return vo;
    }

    @Override
    public void logout(String token) {
        Instant expireTime = jwtUtil.getExpireTime(token);
        tokenBlacklist.put(token, expireTime);
    }

    @Override
    public RefreshTokenVO refreshToken(RefreshTokenDTO dto) {
        Long userId = jwtUtil.parseRefreshToken(dto.getRefreshToken());
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        String newToken = jwtUtil.generateToken(user.getId(), user.getRole());
        Instant expireTime = jwtUtil.getExpireTime(newToken);
        RefreshTokenVO vo = new RefreshTokenVO();
        vo.setToken(newToken);
        vo.setExpireTime(expireTime.toString());
        return vo;
    }

    /**
     * 判断token是否在黑名单
     */
    public static boolean isTokenBlacklisted(String token) {
        Instant expire = tokenBlacklist.get(token);
        return expire != null && expire.isAfter(Instant.now());
    }
} 