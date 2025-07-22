package cc.techox.blog.service;

import cc.techox.blog.model.dto.user.LoginDTO;
import cc.techox.blog.model.dto.user.RefreshTokenDTO;
import cc.techox.blog.model.vo.user.LoginResultVO;
import cc.techox.blog.model.vo.user.RefreshTokenVO;

/**
 * 认证业务接口
 * @author MikuFox
 */
public interface AuthService {
    /**
     * 用户登录
     * @param loginDTO 登录参数
     * @return 登录结果
     */
    LoginResultVO login(LoginDTO loginDTO);

    /**
     * 用户登出
     * @param token 当前JWT
     */
    void logout(String token);

    /**
     * 刷新Token
     * @param refreshTokenDTO 刷新参数
     * @return 新Token
     */
    RefreshTokenVO refreshToken(RefreshTokenDTO refreshTokenDTO);
} 