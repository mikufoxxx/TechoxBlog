package cc.techox.blog.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * 用户实体类，对应数据库表
 * @author MikuFox
 */
@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    /**
     * 用户ID，主键，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名，唯一
     */
    @Column(nullable = false, unique = true, length = 16)
    private String username;

    /**
     * 密码（加密存储）
     */
    @Column(nullable = false)
    private String password;

    /**
     * 邮箱，唯一
     */
    @Column(nullable = false, unique = true, length = 64)
    private String email;

    /**
     * 昵称
     */
    @Column(length = 32)
    private String nickname;

    /**
     * 头像URL
     */
    @Column(length = 255)
    private String avatar;

    /**
     * 个人简介
     */
    @Column(length = 255)
    private String bio;

    /**
     * 用户角色（如admin、user等）
     */
    @Column(nullable = false, length = 20)
    private String role;

    /**
     * 创建时间（UTC，ISO 8601）
     */
    @Column(nullable = false)
    private Instant createTime;

    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 