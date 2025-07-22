package cc.techox.blog.model.vo.user;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户信息返回对象
 * @author MikuFox
 */
@Getter
@Setter
public class UserProfileVO {
    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像URL
     */
    private String avatar;
    /**
     * 个人简介
     */
    private String bio;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 创建时间（ISO 8601）
     */
    private String createTime;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 