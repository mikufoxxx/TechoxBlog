package cc.techox.blog.common;

import lombok.Getter;

/**
 * 业务异常类
 * <p>用于抛出自定义业务异常，便于全局处理</p>
 * @author MikuFox
 */
@Getter
public class BusinessException extends RuntimeException {
    private final int code;
    private final String i18nKey;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.i18nKey = errorCode.getI18nKey();
    }

    public BusinessException(int code, String message, String i18nKey) {
        super(message);
        this.code = code;
        this.i18nKey = i18nKey;
    }

}