package cc.techox.blog.controller;

import cc.techox.blog.common.CommonResponse;
import cc.techox.blog.model.dto.article.ArticleDTO;
import cc.techox.blog.model.dto.article.ArticleQueryDTO;
import cc.techox.blog.model.dto.article.LikeArticleDTO;
import cc.techox.blog.model.vo.article.ArticleVO;
import cc.techox.blog.model.vo.article.ArticleListVO;
import cc.techox.blog.model.vo.article.PageVO;
import cc.techox.blog.service.ArticleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章相关接口
 * @author MikuFox
 */
@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /** 获取文章列表（分页/筛选/搜索） */
    @GetMapping
    public CommonResponse<PageVO<ArticleListVO>> listArticles(@ModelAttribute ArticleQueryDTO queryDTO) {
        return CommonResponse.success(articleService.listArticles(queryDTO), "操作成功", "common.success");
    }

    /** 获取单篇文章详情 */
    @GetMapping("/{id}")
    public CommonResponse<ArticleVO> getArticle(@PathVariable Long id) {
        return CommonResponse.success(articleService.getArticle(id), "操作成功", "common.success");
    }

    /** 新建文章 */
    @PostMapping
    public CommonResponse<ArticleVO> createArticle(HttpServletRequest request, @Valid @RequestBody ArticleDTO dto) {
        Long userId = (Long) request.getAttribute("userId");
        return CommonResponse.success(articleService.createArticle(dto, userId), "操作成功", "common.success");
    }

    /** 更新文章 */
    @PutMapping("/{id}")
    public CommonResponse<ArticleVO> updateArticle(HttpServletRequest request, @PathVariable Long id, @Valid @RequestBody ArticleDTO dto) {
        Long userId = (Long) request.getAttribute("userId");
        return CommonResponse.success(articleService.updateArticle(id, dto, userId), "操作成功", "common.success");
    }

    /** 删除文章 */
    @DeleteMapping("/{id}")
    public CommonResponse<Void> deleteArticle(HttpServletRequest request, @PathVariable Long id) {
        Long userId = (Long) request.getAttribute("userId");
        articleService.deleteArticle(id, userId);
        return CommonResponse.success(null, "操作成功", "common.success");
    }

    /** 发布文章 */
    @PostMapping("/{id}/publish")
    public CommonResponse<ArticleVO> publishArticle(HttpServletRequest request, @PathVariable Long id) {
        Long userId = (Long) request.getAttribute("userId");
        return CommonResponse.success(articleService.publishArticle(id, userId), "操作成功", "common.success");
    }

    /** 保存为草稿 */
    @PostMapping("/{id}/draft")
    public CommonResponse<ArticleVO> saveDraft(HttpServletRequest request, @PathVariable Long id) {
        Long userId = (Long) request.getAttribute("userId");
        return CommonResponse.success(articleService.saveDraft(id, userId), "操作成功", "common.success");
    }

    /** 获取草稿列表 */
    @GetMapping("/drafts")
    public CommonResponse<PageVO<ArticleListVO>> listDrafts(HttpServletRequest request, @ModelAttribute ArticleQueryDTO queryDTO) {
        Long userId = (Long) request.getAttribute("userId");
        return CommonResponse.success(articleService.listDrafts(userId, queryDTO), "操作成功", "common.success");
    }

    /** 点赞文章 */
    @PostMapping("/{id}/like")
    public CommonResponse<Void> likeArticle(HttpServletRequest request, @PathVariable Long id, @RequestBody LikeArticleDTO dto) {
        Long userId = dto.getUserId() != null ? dto.getUserId() : (Long) request.getAttribute("userId");
        articleService.likeArticle(id, userId);
        return CommonResponse.success(null, "操作成功", "common.success");
    }

    /** 获取热门文章 */
    @GetMapping("/hot")
    public CommonResponse<List<ArticleListVO>> listHotArticles() {
        return CommonResponse.success(articleService.listHotArticles(), "操作成功", "common.success");
    }
} 