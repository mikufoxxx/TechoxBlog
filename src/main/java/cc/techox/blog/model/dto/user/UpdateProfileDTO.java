package cc.techox.blog.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Size;

/**
 * 用户更新个人信息请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class UpdateProfileDTO {
    /**
     * 新昵称，可选
     */
    @Size(max = 32, message = "昵称长度不能超过32")
    private String nickname;

    /**
     * 头像URL，可选
     */
    @Size(max = 255, message = "头像URL长度不能超过255")
    private String avatar;

    /**
     * 个人简介，可选
     */
    @Size(max = 255, message = "个人简介长度不能超过255")
    private String bio;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 