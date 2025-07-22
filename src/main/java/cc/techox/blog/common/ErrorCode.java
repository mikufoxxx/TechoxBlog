package cc.techox.blog.common;

import lombok.Getter;

/**
 * 业务错误码定义
 * <p>便于统一管理和国际化</p>
 * @author MikuFox
 */
@Getter
public enum ErrorCode {
    // 通用/系统（00xx）
    SUCCESS(0, "操作成功", "common.success"),
    UNKNOWN_ERROR(1, "未知错误", "common.unknown"),
    PARAM_INVALID(2, "参数无效", "common.param.invalid"),
    NOT_FOUND(3, "资源未找到", "common.notfound"),
    FAILED(4, "操作失败", "common.failed"),
    BUSY(5, "服务繁忙", "common.busy"),

    // 用户/认证（10xx）
    USERNAME_EXISTS(1001, "用户名已存在", "user.username.exists"),
    EMAIL_EXISTS(1002, "邮箱已存在", "user.email.exists"),
    USER_NOT_FOUND(1003, "用户不存在", "user.notfound"),
    PASSWORD_INCORRECT(1004, "密码错误", "user.password.incorrect"),
    USER_DISABLED(1005, "账号被禁用", "user.disabled"),
    NOT_LOGIN(1006, "未登录/Token无效", "user.notlogin"),
    TOKEN_EXPIRED(1007, "Token已过期", "user.token.expired"),
    REFRESH_TOKEN_INVALID(1008, "RefreshToken无效", "user.refreshtoken.invalid"),
    OLD_PASSWORD_WRONG(1009, "旧密码错误", "user.password.oldwrong"),
    NO_PERMISSION(1010, "没有权限", "user.no.permission");

    private final int code;
    private final String message;
    private final String i18nKey;

    ErrorCode(int code, String message, String i18nKey) {
        this.code = code;
        this.message = message;
        this.i18nKey = i18nKey;
    }

}