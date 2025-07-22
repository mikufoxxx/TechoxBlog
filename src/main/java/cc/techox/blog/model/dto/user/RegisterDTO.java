package cc.techox.blog.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

/**
 * 用户注册请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class RegisterDTO {
    /**
     * 用户名，必填
     */
    @NotBlank(message = "用户名不能为空")
    @Size(max = 16, message = "用户名长度不能超过16")
    private String username;

    /**
     * 密码，必填
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度6-16位")
    private String password;

    /**
     * 邮箱，必填
     */
    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @Size(max = 64, message = "邮箱长度不能超过64")
    private String email;

    /**
     * 昵称，可选
     */
    @Size(max = 32, message = "昵称长度不能超过32")
    private String nickname;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 