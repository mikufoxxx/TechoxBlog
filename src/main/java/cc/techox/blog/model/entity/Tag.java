package cc.techox.blog.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 标签实体类
 * @author MikuFox
 */
@Entity
@Getter
@Setter
@Table(name = "tag")
public class Tag {
    /** 标签ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 标签名 */
    @Column(nullable = false, length = 50)
    private String name;
    // getter/setter 省略，可用 Lombok 简化
} 