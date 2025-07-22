package cc.techox.blog.security;

import cc.techox.blog.common.BusinessException;
import cc.techox.blog.common.ErrorCode;
import cc.techox.blog.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * JWT 认证过滤器
 * <p>拦截 /api/user/**，校验token</p>
 * @author MikuFox
 */
@Component
public class JwtAuthenticationFilter implements Filter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        // 只拦截 /api/user/**
        if (uri.startsWith("/api/user/")) {
            String token = req.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer ")) {
                throw new BusinessException(ErrorCode.NOT_LOGIN);
            }
            token = token.substring(7);
            if (!jwtUtil.validateToken(token) || AuthServiceImpl.isTokenBlacklisted(token)) {
                throw new BusinessException(ErrorCode.NOT_LOGIN);
            }
            Long userId = jwtUtil.parseToken(token);
            // 设置用户ID到请求属性，便于后续获取
            request.setAttribute("userId", userId);
        }
        chain.doFilter(request, response);
    }
} 