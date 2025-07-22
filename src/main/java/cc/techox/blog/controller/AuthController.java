package cc.techox.blog.controller;

import cc.techox.blog.common.CommonResponse;
import cc.techox.blog.model.dto.user.*;
import cc.techox.blog.model.vo.user.LoginResultVO;
import cc.techox.blog.model.vo.user.RefreshTokenVO;
import cc.techox.blog.model.vo.user.UserProfileVO;
import cc.techox.blog.service.AuthService;
import cc.techox.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 认证相关接口
 * @author MikuFox
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public CommonResponse<UserProfileVO> register(@Valid @RequestBody RegisterDTO dto) {
        UserProfileVO vo = userService.register(dto);
        return CommonResponse.success(vo, "注册成功", "user.register.success");
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public CommonResponse<LoginResultVO> login(@Valid @RequestBody LoginDTO dto) {
        LoginResultVO vo = authService.login(dto);
        return CommonResponse.success(vo, "登录成功", "user.login.success");
    }

    /**
     * 用户登出
     */
    @PostMapping("/logout")
    public CommonResponse<Void> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            authService.logout(token);
        }
        return CommonResponse.success(null, "登出成功", "user.logout.success");
    }

    /**
     * 刷新token
     */
    @PostMapping("/refresh")
    public CommonResponse<RefreshTokenVO> refresh(@Valid @RequestBody RefreshTokenDTO dto) {
        RefreshTokenVO vo = authService.refreshToken(dto);
        return CommonResponse.success(vo, "刷新成功", "user.refresh.success");
    }
} 