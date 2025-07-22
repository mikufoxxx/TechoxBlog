package cc.techox.blog.service;

import cc.techox.blog.model.dto.user.*;
import cc.techox.blog.model.vo.user.UserProfileVO;

/**
 * 用户业务接口
 * @author MikuFox
 */
public interface UserService {
    /**
     * 用户注册
     * @param registerDTO 注册参数
     * @return 用户信息
     */
    UserProfileVO register(RegisterDTO registerDTO);

    /**
     * 获取当前用户信息
     * @param userId 用户ID
     * @return 用户信息
     */
    UserProfileVO getProfile(Long userId);

    /**
     * 更新用户信息
     * @param userId 用户ID
     * @param updateProfileDTO 更新参数
     * @return 用户信息
     */
    UserProfileVO updateProfile(Long userId, UpdateProfileDTO updateProfileDTO);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param changePasswordDTO 修改密码参数
     */
    void changePassword(Long userId, ChangePasswordDTO changePasswordDTO);
} 