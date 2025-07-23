package cc.techox.blog.model.dto.article;

import lombok.Getter;
import lombok.Setter;

/**
 * 点赞文章请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class LikeArticleDTO {
    /** 用户ID（可选，token可取） */
    private Long userId;
    // getter/setter 省略，可用 Lombok 简化
} 