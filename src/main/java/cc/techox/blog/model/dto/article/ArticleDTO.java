package cc.techox.blog.model.dto.article;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 新建/更新文章请求参数
 * @author MikuFox
 */
@Getter
@Setter
public class ArticleDTO {
    /** 文章标题 */
    @NotBlank(message = "标题不能为空")
    @Size(max = 200, message = "标题长度不能超过200")
    private String title;
    /** 文章内容（Markdown） */
    @NotBlank(message = "内容不能为空")
    private String content;
    /** 摘要 */
    @Size(max = 500, message = "摘要长度不能超过500")
    private String summary;
    /** 封面图片URL */
    @Size(max = 255, message = "封面图片URL长度不能超过255")
    private String coverImage;
    /** 分类ID */
    @NotNull(message = "分类ID不能为空")
    private Long categoryId;
    /** 标签ID列表 */
    private List<Long> tagIds;
    /** 状态（draft/published） */
    @NotBlank(message = "状态不能为空")
    private String status;
    /** 是否允许评论 */
    private Boolean allowComment;
    /** 附件URL列表 */
    private List<String> attachments;
    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 