package cc.techox.blog.service.impl;

import cc.techox.blog.model.dto.article.ArticleDTO;
import cc.techox.blog.model.dto.article.ArticleQueryDTO;
import cc.techox.blog.model.dto.article.LikeArticleDTO;
import cc.techox.blog.model.vo.article.ArticleVO;
import cc.techox.blog.model.vo.article.ArticleListVO;
import cc.techox.blog.model.vo.article.PageVO;
import cc.techox.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章业务实现类
 * @author MikuFox
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Override
    public PageVO<ArticleListVO> listArticles(ArticleQueryDTO queryDTO) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public ArticleVO getArticle(Long id) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public ArticleVO createArticle(ArticleDTO dto, Long userId) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public ArticleVO updateArticle(Long id, ArticleDTO dto, Long userId) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public void deleteArticle(Long id, Long userId) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public ArticleVO publishArticle(Long id, Long userId) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public ArticleVO saveDraft(Long id, Long userId) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public PageVO<ArticleListVO> listDrafts(Long userId, ArticleQueryDTO queryDTO) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public void likeArticle(Long id, Long userId) {
        throw new UnsupportedOperationException("未实现");
    }
    @Override
    public List<ArticleListVO> listHotArticles() {
        throw new UnsupportedOperationException("未实现");
    }
} 