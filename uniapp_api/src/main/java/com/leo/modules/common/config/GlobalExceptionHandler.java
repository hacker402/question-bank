package com.leo.modules.common.config;

import com.alibaba.fastjson.JSONObject;
import com.leo.moudles.constant.ExceptionCodes;
import com.leo.moudles.exception.GeneralException;
import com.leo.moudles.response.ApiResult;
import com.leo.moudles.response.BaseApiCodeImpl;
import com.leo.moudles.utils.ConstantUtils;
import com.leo.moudles.utils.DataUtils;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <p>
 * GlobalExceptionHandler
 * </p>
 *
 * @author jackcooperz
 * @date 2019/8/9 8:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String X_REQUESTED_WITH = "x-requested-with";

    private static final String XNL_HTTP_REQUEST = "XMLHttpRequest";

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public void defaultErrorHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        if (isAjaxRequest(request)) {
            ajaxRequestErrorHandler(request, e, response);
        } else {
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            if (StringUtils.isNotBlank(queryString)) {
                uri = uri + "?" + queryString;
            }
            logger.error("request error,uri:{},Error:", uri, e);
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            String errorMsg;
            if (e instanceof NoHandlerFoundException) {
                String url = ((NoHandlerFoundException) e).getRequestURL();
                response.setStatus(302);
                response.setHeader("location", "/404?from=" + url);
            } else {

                    if (e instanceof GeneralException) {
                        errorMsg = e.getMessage();
                    } else if (e instanceof NoHandlerFoundException) {
                        errorMsg = "page not found";
                    } else {
                        errorMsg = "服务器网络异常,请稍后重试";
                    }
                    logger.error("request error,url:" + request.getRequestURL() + ",query:" + request.getQueryString(), e);
                    request.getSession().setAttribute("errorMsg", errorMsg);
                    response.setStatus(302);
                    response.setHeader("location", "/500?from=" + uri);
                }
        }
    }

    private void ajaxRequestErrorHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        response.setContentType("application/json;charset=UTF-8");
        StringBuilder sb = new StringBuilder();
        String uri = request.getRequestURI();
        if (e instanceof NoHandlerFoundException) {
            logger.error("uri:{} not found", uri);
            response.setStatus(200);
            sb.append(JSONObject.toJSONString(new ApiResult(BaseApiCodeImpl.builder()
                    .code(ExceptionCodes.NOT_FOUND)
                    .build(), ConstantUtils.getName(ExceptionCodes.NOT_FOUND, ExceptionCodes.class),
                    DataUtils.EMPTY_STR)));
        } else if (e instanceof GeneralException) {
            logger.error("uri:{} raise GeneralException,Error:", uri, e);
            response.setStatus(200);
            sb.append(JSONObject.toJSONString(new ApiResult(BaseApiCodeImpl.builder()
                    .code(((GeneralException) e).getCode())
                    .build(), e.getMessage(), DataUtils.EMPTY_STR)));
        } else {
            logger.error("uri:{} raise default Exception,error:", uri, e);
            response.setStatus(200);
            sb.append(JSONObject.toJSONString(new ApiResult(BaseApiCodeImpl.builder()
                    .code(ExceptionCodes.FAILED)
                    .build(), "服务器网络异常,请稍后重试", DataUtils.EMPTY_STR)));
        }
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(sb.toString());
        } catch (Exception e1) {
            logger.error("ajaxRequestErrorHandler return ajax failed,Error:", e1);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                    response.flushBuffer();
                }
            } catch (Exception e2) {
                logger.error("ajaxRequestErrorHandler close writer failed,Error:", e2);
            }
        }

    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        return DataUtils.isNotEmptyStr(request.getHeader(X_REQUESTED_WITH)) && XNL_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
    }
}
