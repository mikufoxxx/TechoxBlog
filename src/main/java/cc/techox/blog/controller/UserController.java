package cc.techox.blog.controller;

import cc.techox.blog.common.CommonResponse;
import cc.techox.blog.model.dto.user.ChangePasswordDTO;
import cc.techox.blog.model.dto.user.UpdateProfileDTO;
import cc.techox.blog.model.vo.user.UserProfileVO;
import cc.techox.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 用户相关接口
 * @author MikuFox
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取当前用户信息
     */
    @GetMapping("/profile")
    public CommonResponse<UserProfileVO> getProfile(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        UserProfileVO vo = userService.getProfile(userId);
        return CommonResponse.success(vo, "获取成功", "user.profile.success");
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/profile")
    public CommonResponse<UserProfileVO> updateProfile(HttpServletRequest request, @Valid @RequestBody UpdateProfileDTO dto) {
        Long userId = (Long) request.getAttribute("userId");
        UserProfileVO vo = userService.updateProfile(userId, dto);
        return CommonResponse.success(vo, "更新成功", "user.profile.update.success");
    }

    /**
     * 修改密码
     */
    @PutMapping("/password")
    public CommonResponse<Void> changePassword(HttpServletRequest request, @Valid @RequestBody ChangePasswordDTO dto) {
        Long userId = (Long) request.getAttribute("userId");
        userService.changePassword(userId, dto);
        return CommonResponse.success(null, "修改成功", "user.password.change.success");
    }
} 