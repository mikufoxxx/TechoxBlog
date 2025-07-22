package cc.techox.blog.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 通用 API 响应封装类
 * <p>所有接口返回此结构，便于前端统一处理和国际化</p>
 * @param <T> 业务数据类型
 * @author MikuFox
 */
@Setter
@Getter
public class CommonResponse<T> implements Serializable {
    /**
     * 业务状态码，0为成功，其他为错误
     */
    private int code;
    /**
     * 人类可读的提示信息，支持多语言
     */
    private String message;
    /**
     * 具体业务数据
     */
    private T data;
    /**
     * 国际化key，前端可根据key做本地化
     */
    private String i18nKey;

    public CommonResponse() {}

    public CommonResponse(int code, String message, String i18nKey, T data) {
        this.code = code;
        this.message = message;
        this.i18nKey = i18nKey;
        this.data = data;
    }

    public static <T> CommonResponse<T> success(T data, String message, String i18nKey) {
        return new CommonResponse<>(ErrorCode.SUCCESS.getCode(), message, i18nKey, data);
    }

    public static <T> CommonResponse<T> error(int code, String message, String i18nKey) {
        return new CommonResponse<>(code, message, i18nKey, null);
    }

}