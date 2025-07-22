package cc.techox.blog.model.vo.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 登录结果返回对象
 * @author MikuFox
 */
@Getter
@Setter
public class LoginResultVO {
    /**
     * JWT 认证令牌
     */
    private String token;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 令牌过期时间（ISO 8601）
     */
    private String expireTime;
    /**
     * 用户基本信息
     */
    private UserProfileVO userInfo;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 