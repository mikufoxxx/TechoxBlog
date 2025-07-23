package cc.techox.blog.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 分类实体类
 * @author MikuFox
 */
@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {
    /** 分类ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 分类名 */
    @Column(nullable = false, length = 50)
    private String name;
    // getter/setter 省略，可用 Lombok 简化
} 