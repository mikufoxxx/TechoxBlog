package cc.techox.blog.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

/**
 * 文章实体类
 * @author MikuFox
 */
@Entity
@Getter
@Setter
@Table(name = "article")
public class Article {
    /** 文章ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /** 文章标题 */
    @Column(nullable = false, length = 200)
    private String title;
    /** 文章内容（Markdown） */
    @Lob
    @Column(nullable = false)
    private String content;
    /** 摘要 */
    @Column(length = 500)
    private String summary;
    /** 封面图片URL */
    @Column(length = 255)
    private String coverImage;
    /** 分类ID */
    @Column(nullable = false)
    private Long categoryId;
    /** 状态（draft/published/hide） */
    @Column(nullable = false, length = 20)
    private String status;
    /** 是否允许评论 */
    @Column
    private Boolean allowComment;
    /** 附件URL列表（JSON存储） */
    @ElementCollection
    @CollectionTable(name = "article_attachments", joinColumns = @JoinColumn(name = "article_id"))
    @Column(name = "attachment")
    private List<String> attachments;
    /** 标签ID列表（多对多） */
    @ElementCollection
    @CollectionTable(name = "article_tags", joinColumns = @JoinColumn(name = "article_id"))
    @Column(name = "tag_id")
    private List<Long> tagIds;
    /** 作者ID */
    @Column(nullable = false)
    private Long authorId;
    /** 点赞数 */
    @Column(nullable = false)
    private Integer likeCount = 0;
    /** 评论数 */
    @Column(nullable = false)
    private Integer commentCount = 0;
    /** 阅读数 */
    @Column(nullable = false)
    private Integer viewCount = 0;
    /** 创建时间 */
    @Column(nullable = false)
    private Instant createTime;
    /** 更新时间 */
    @Column(nullable = false)
    private Instant updateTime;
    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 