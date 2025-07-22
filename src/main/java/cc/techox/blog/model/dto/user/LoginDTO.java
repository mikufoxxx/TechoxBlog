package cc.techox.blog.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 用户登录请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class LoginDTO {
    /**
     * 用户名或邮箱，必填
     */
    @NotBlank(message = "用户名/邮箱不能为空")
    @Size(max = 64, message = "用户名/邮箱长度不能超过64")
    private String username;

    /**
     * 密码，必填
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 16, message = "密码长度6-16位")
    private String password;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 