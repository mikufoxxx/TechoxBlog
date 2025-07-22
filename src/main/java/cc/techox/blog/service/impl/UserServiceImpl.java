package cc.techox.blog.service.impl;

import cc.techox.blog.common.BusinessException;
import cc.techox.blog.common.ErrorCode;
import cc.techox.blog.model.dto.user.*;
import cc.techox.blog.model.entity.User;
import cc.techox.blog.model.vo.user.UserProfileVO;
import cc.techox.blog.repository.UserRepository;
import cc.techox.blog.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * 用户业务实现类
 * @author MikuFox
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserProfileVO register(RegisterDTO registerDTO) {
        // 校验用户名和邮箱唯一
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            throw new BusinessException(ErrorCode.USERNAME_EXISTS);
        }
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new BusinessException(ErrorCode.EMAIL_EXISTS);
        }
        // 构建用户实体
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setNickname(registerDTO.getNickname());
        user.setRole("user");
        user.setCreateTime(Instant.now());
        // 可选字段
        user.setAvatar(null);
        user.setBio(null);
        // 保存
        userRepository.save(user);
        return toUserProfileVO(user);
    }

    @Override
    public UserProfileVO getProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        return toUserProfileVO(user);
    }

    @Override
    public UserProfileVO updateProfile(Long userId, UpdateProfileDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        if (dto.getNickname() != null) {
            user.setNickname(dto.getNickname());
        }
        if (dto.getAvatar() != null) {
            user.setAvatar(dto.getAvatar());
        }
        if (dto.getBio() != null) {
            user.setBio(dto.getBio());
        }
        userRepository.save(user);
        return toUserProfileVO(user);
    }

    @Override
    public void changePassword(Long userId, ChangePasswordDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.OLD_PASSWORD_WRONG);
        }
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }

    /**
     * 实体转VO
     */
    private UserProfileVO toUserProfileVO(User user) {
        UserProfileVO vo = new UserProfileVO();
        BeanUtils.copyProperties(user, vo);
        vo.setCreateTime(user.getCreateTime().toString());
        return vo;
    }
} 