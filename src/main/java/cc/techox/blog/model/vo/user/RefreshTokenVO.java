package cc.techox.blog.model.vo.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 刷新Token返回对象
 * @author MikuFox
 */
@Getter
@Setter
public class RefreshTokenVO {
    /**
     * 新的JWT认证令牌
     */
    private String token;
    /**
     * 新令牌过期时间（ISO 8601）
     */
    private String expireTime;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 