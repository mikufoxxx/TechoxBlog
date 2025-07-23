package cc.techox.blog.model.vo.tag;

import lombok.Getter;
import lombok.Setter;

/**
 * 标签VO
 * @author MikuFox
 */
@Getter
@Setter
public class TagVO {
    private Long id;
    private String name;
    // getter/setter 省略，可用 Lombok 简化
} 