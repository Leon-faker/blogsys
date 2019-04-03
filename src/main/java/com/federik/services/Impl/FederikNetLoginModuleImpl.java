package com.federik.services.Impl;

import com.alibaba.fastjson.JSON;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.FederikUsersMapper;
import com.federik.mapper.dto.UsersDto;
import com.federik.services.FederikNetLoginModule;
import com.federik.utils.CoreMD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.Objects;

@Slf4j
@Service
public class FederikNetLoginModuleImpl implements FederikNetLoginModule {

    @Resource
    public FederikUsersMapper federikUsersMapper;

    @Override
    public ResultEncapsulationVO processUserLoginRequest(UsersDto usersDto,HttpServletRequest request) {
        log.info("用户登陆,【Service】");
        if(Objects.isNull(usersDto)){
            return ResultEncapsulationVO.fail("参数异常");
        }
        usersDto.setNetUserPassword(CoreMD5.strMD5Encode32(usersDto.getNetUserPassword()));
        try {
            int index = federikUsersMapper.selectLoginUser(usersDto);
            if(index > 0){
                request.getSession().setAttribute("currentUser",usersDto);
                log.info("登陆之后存储Session: " + JSON.toJSONString(request.getSession().getAttribute("currentUser")));
            }
            return index > 0?ResultEncapsulationVO.success("登陆成功"):ResultEncapsulationVO.fail("用户名或密码错误");
        }catch (Exception e){
            log.error("查询出现异常");
            return ResultEncapsulationVO.fail("查询操作出现异常");
        }
    }
}
