package cc.techox.blog.model.dto.user;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

/**
 * 刷新Token请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class RefreshTokenDTO {
    /**
     * 刷新令牌，必填
     */
    @NotBlank(message = "刷新令牌不能为空")
    private String refreshToken;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 