package cc.techox.blog.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * <p>统一处理业务异常和系统异常，返回标准响应结构</p>
 * @author MikuFox
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     * @param ex 业务异常
     * @return 通用响应结构
     */
    @ExceptionHandler(BusinessException.class)
    public CommonResponse<Void> handleBusinessException(BusinessException ex) {
        return CommonResponse.error(ex.getCode(), ex.getMessage(), ex.getI18nKey());
    }

    /**
     * 处理其他未知异常
     * @param ex 异常
     * @return 通用响应结构
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse<Void> handleException(Exception ex) {
        // 生产环境可隐藏详细异常信息
        return CommonResponse.error(ErrorCode.UNKNOWN_ERROR.getCode(), ex.getMessage(), ErrorCode.UNKNOWN_ERROR.getI18nKey());
    }
} 