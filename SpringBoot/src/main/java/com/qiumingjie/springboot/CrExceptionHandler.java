package com.qiumingjie.springboot;

import com.qiumingjie.springboot.util.CrResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author Bug_Zheng
 */
@RestControllerAdvice
public class CrExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 数据库记录重复异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public CrResponse handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return CrResponse.error("数据库中已存在该记录");
    }

    /**
     * 授权异常
     * @param e
     * @return
     */
//	@ExceptionHandler(AuthorizationException.class)
//	public CrResponse handleAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return CrResponse.error("没有权限，请联系管理员授权");
//	}
//
//	@ExceptionHandler(UnauthorizedException.class)
//	public CrResponse handleUnAuthorizationException(AuthorizationException e){
//		logger.error(e.getMessage(), e);
//		return CrResponse.error("没有权限，请联系管理员授权");
//	}

    /**
     * redis服务器异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RedisSystemException.class)
    public CrResponse handleRedisException(Exception e) {
        logger.error(e.getMessage(), e);
        return CrResponse.error("redis服务器异常，请尝试刷新");
    }

    /**
     * 请求方法不对应异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CrResponse handleMethodNotAllowException(HttpRequestMethodNotSupportedException e) {
        return CrResponse.error(e.getMessage());
    }

    /**
     * 方法参数无效异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CrResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return CrResponse.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 方法参数无效异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public CrResponse handleBindException(BindException e) {
        return CrResponse.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }


    /**
     * http信息无法处理异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CrResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return CrResponse.error(e.getMessage());
    }

    /**
     * rpc调用异常
     * @param e
     * @return
     */
//	@ExceptionHandler(CrRpcException.class)
//	public CrResponse handleRpcExceptionException(CrRpcException e){
//		logger.warn(e.getMessage(),e);
//		return CrResponse.error(e.getMessage());
//	}


    /**
     * 未预期的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public CrResponse handleException(Exception e) {
        logger.error("未预期的异常" + "{" + e.getMessage() + "}", e);
        return CrResponse.error();
    }


}
