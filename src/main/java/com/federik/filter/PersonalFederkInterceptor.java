package com.federik.filter;


import com.federik.common.utils.CommUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
/**
 * 拦截器 拦截除登录，验证登录以外的所有请求
 */
public class PersonalFederkInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("拦截器"+request.getSession().getAttribute("currentUser"));
        if(CommUtils.isNull(request.getSession().getAttribute("currentUser"))) {
            log.info("跳转用户未登录");
            request.getRequestDispatcher(request.getContextPath()+"/federik/invaliduser").forward(request,response);
            return false;
        }
        return true;
    }

}
