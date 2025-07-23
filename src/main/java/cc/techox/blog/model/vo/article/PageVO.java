package cc.techox.blog.model.vo.article;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 通用分页返回对象
 * @author MikuFox
 */
@Getter
@Setter
public class PageVO<T> {
    private List<T> records;
    private Long total;
    private Integer page;
    private Integer size;
    // getter/setter 省略，可用 Lombok 简化
    // ... existing code ...
} 