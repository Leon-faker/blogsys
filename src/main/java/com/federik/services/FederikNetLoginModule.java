package com.federik.services;

import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.users;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录模块接口，处理登录模块所有事件
 */
public interface FederikNetLoginModule {
    /**
     * 处理用户登录请求
     * @param usersDto 用户model
     * @return > true 登录成功 ， false 登录失败
     */
    ResultEncapsulationVO processUserLoginRequest(users usersDto, HttpServletRequest request);
}
