package cc.techox.blog.repository;

import cc.techox.blog.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 文章数据访问层
 * @author MikuFox
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    // 可根据需要添加自定义查询方法
} 