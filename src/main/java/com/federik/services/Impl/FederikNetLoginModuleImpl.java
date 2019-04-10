package com.federik.services.Impl;

import com.alibaba.fastjson.JSON;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.users;
import com.federik.mapper.dto.usersExample;
import com.federik.mapper.usersMapper;
import com.federik.services.FederikNetLoginModule;
import com.federik.utils.CoreMD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class FederikNetLoginModuleImpl implements FederikNetLoginModule {

    @Resource
    public usersMapper usersMapperDao;

    @Override
    public ResultEncapsulationVO processUserLoginRequest(users usersDto, HttpServletRequest request) {
        log.info("用户登陆,【Service】");
        if(Objects.isNull(usersDto)){
            return ResultEncapsulationVO.fail("参数异常");
        }
        try {
            usersDto.setNetUserPassword(CoreMD5.strMD5Encode32(usersDto.getNetUserPassword()));
            usersExample usersEx = new usersExample();
            usersExample.Criteria userCr = usersEx.createCriteria()
                    .andNetUserUsernameEqualTo(usersDto.getNetUserUsername())
                    .andNetUserPasswordEqualTo(usersDto.getNetUserPassword());

            List<users> userlst = usersMapperDao.selectByExample(usersEx);
            if(!CollectionUtils.isEmpty(userlst)){
                request.getSession().setAttribute("currentUser",userlst.get(0));
                log.info("登陆之后存储Session: " + JSON.toJSONString(request.getSession().getAttribute("currentUser")));
                return ResultEncapsulationVO.success("登录成功");
            }
            return ResultEncapsulationVO.fail("用户名或密码错误");
        }catch (Exception e){
            log.error("查询出现异常");
            return ResultEncapsulationVO.fail("查询操作出现异常");
        }
    }
}
