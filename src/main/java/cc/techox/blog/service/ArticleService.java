package cc.techox.blog.service;

import cc.techox.blog.model.dto.article.ArticleDTO;
import cc.techox.blog.model.dto.article.ArticleQueryDTO;
import cc.techox.blog.model.dto.article.LikeArticleDTO;
import cc.techox.blog.model.vo.article.ArticleVO;
import cc.techox.blog.model.vo.article.ArticleListVO;
import cc.techox.blog.model.vo.article.PageVO;

import java.util.List;

/**
 * 文章业务接口
 * @author MikuFox
 */
public interface ArticleService {
    PageVO<ArticleListVO> listArticles(ArticleQueryDTO queryDTO);
    ArticleVO getArticle(Long id);
    ArticleVO createArticle(ArticleDTO dto, Long userId);
    ArticleVO updateArticle(Long id, ArticleDTO dto, Long userId);
    void deleteArticle(Long id, Long userId);
    ArticleVO publishArticle(Long id, Long userId);
    ArticleVO saveDraft(Long id, Long userId);
    PageVO<ArticleListVO> listDrafts(Long userId, ArticleQueryDTO queryDTO);
    void likeArticle(Long id, Long userId);
    List<ArticleListVO> listHotArticles();
} 