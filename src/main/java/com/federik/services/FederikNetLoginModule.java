package com.federik.services;

import com.federik.mapper.dto.UsersDto;

/**
 * 登录模块接口，处理登录模块所有事件
 */
public interface FederikNetLoginModule {
    /**
     * 处理用户登录请求
     * @param usersDto 用户model
     * @return > true 登录成功 ， false 登录失败
     */
    boolean processUserLoginRequest(UsersDto usersDto);
}
