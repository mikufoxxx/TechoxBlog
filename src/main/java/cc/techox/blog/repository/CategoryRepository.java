package cc.techox.blog.repository;

import cc.techox.blog.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 分类数据访问层
 * @author MikuFox
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
} 