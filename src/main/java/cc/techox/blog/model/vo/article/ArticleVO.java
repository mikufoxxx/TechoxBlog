package cc.techox.blog.model.vo.article;

import cc.techox.blog.model.vo.category.CategoryVO;
import cc.techox.blog.model.vo.tag.TagVO;
import cc.techox.blog.model.vo.user.UserProfileVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 文章详情返回对象
 * @author MikuFox
 */
@Getter
@Setter
public class ArticleVO {
    private Long id;
    private String title;
    private String content;
    private String summary;
    private String coverImage;
    private CategoryVO category;
    private List<TagVO> tags;
    private UserProfileVO author;
    private String status;
    private Boolean allowComment;
    private List<String> attachments;
    private Integer likeCount;
    private Integer commentCount;
    private Integer viewCount;
    private String createTime;
    private String updateTime;
    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 