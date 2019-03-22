package com.federik.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
/**
 * 拦截器 拦截除登录，验证登录以外的所有请求
 */
public class PersonalFederkInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if(Objects.isNull(session.getAttribute("currentUser"))) {
            request.getRequestDispatcher(request.getContextPath()+"/federik/invaliduser").forward(request,response);
            return false;
        }
        return true;
    }

}
