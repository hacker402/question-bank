package com.leo.modules.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * RequireLoginAspect
 * </p>
 *
 * @author chenxiaohu
 * @date 2019-08-28 14:27:51
 */
@Component
@Aspect
public class RequireLoginAspect {

    @Pointcut("within(com.laibo.modules.module.*.controller..*) " +
            "&& @annotation(com.leo.modules.common.annotation.RequireLogin)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //ManageUser user = loginService.getUserInfoByToken(token);
        //if (DataUtils.isNull(user)) {
        //    throw new NeedLoginException("需要登录，请先登录");
        //}
        //request.setAttribute(LoginToken.LOGIN_USER, user);
        return joinPoint.proceed();
    }


}
