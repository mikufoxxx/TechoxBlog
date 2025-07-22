package cc.techox.blog.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

/**
 * JWT 工具类
 * <p>用于生成和解析 JWT 令牌</p>
 * @author MikuFox
 */
@Component
public class JwtUtil {
    // 秘钥（生产环境请放配置文件）
    private static final String SECRET = "ReplaceWithYourSecretKey";
    // token 有效期（30分钟）
    private static final long EXPIRE_MILLIS = 30 * 60 * 1000L;
    // refreshToken 有效期（7天）
    private static final long REFRESH_EXPIRE_MILLIS = 7 * 24 * 60 * 60 * 1000L;

    /**
     * 生成JWT
     * @param userId 用户ID
     * @param role 角色
     * @return token
     */
    public String generateToken(Long userId, String role) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("role", role)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusMillis(EXPIRE_MILLIS)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * 生成refreshToken
     * @param userId 用户ID
     * @return refreshToken
     */
    public String generateRefreshToken(Long userId) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusMillis(REFRESH_EXPIRE_MILLIS)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     * 解析token获取用户ID
     * @param token JWT
     * @return 用户ID
     */
    public Long parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return Long.valueOf(claims.getSubject());
    }

    /**
     * 解析refreshToken获取用户ID
     * @param refreshToken refreshToken
     * @return 用户ID
     */
    public Long parseRefreshToken(String refreshToken) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(refreshToken).getBody();
        return Long.valueOf(claims.getSubject());
    }

    /**
     * 获取token过期时间
     * @param token JWT
     * @return 过期时间
     */
    public Instant getExpireTime(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.getExpiration().toInstant();
    }

    /**
     * 校验token合法性
     * @param token JWT
     * @return 是否有效
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
} 