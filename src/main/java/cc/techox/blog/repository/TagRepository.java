package cc.techox.blog.repository;

import cc.techox.blog.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 标签数据访问层
 * @author MikuFox
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
} 