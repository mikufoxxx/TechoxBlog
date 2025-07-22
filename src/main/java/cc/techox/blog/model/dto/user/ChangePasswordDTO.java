package cc.techox.blog.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 用户修改密码请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class ChangePasswordDTO {
    /**
     * 旧密码，必填
     */
    @NotBlank(message = "旧密码不能为空")
    @Size(min = 6, max = 16, message = "旧密码长度6-16位")
    private String oldPassword;

    /**
     * 新密码，必填
     */
    @NotBlank(message = "新密码不能为空")
    @Size(min = 6, max = 16, message = "新密码长度6-16位")
    private String newPassword;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 