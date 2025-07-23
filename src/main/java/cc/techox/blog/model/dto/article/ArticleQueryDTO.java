package cc.techox.blog.model.dto.article;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章列表/搜索/筛选请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class ArticleQueryDTO {
    /** 页码 */
    private Integer page;
    /** 每页数量 */
    private Integer size;
    /** 关键词搜索 */
    private String keyword;
    /** 分类筛选 */
    private Long categoryId;
    /** 标签筛选 */
    private Long tagId;
    /** 状态筛选 */
    private String status;
    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 