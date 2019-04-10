package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.common.utils.CommUtils;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.users;
import com.federik.services.FederikNetLoginModule;
import com.federik.utils.CoreMD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/federik")
public class netBloggerCtrl {

    @Resource
    public FederikNetLoginModule federikNetLoginModule;

    @PostMapping("/loginuser")
    @ResponseBody
    public String loginUser(@RequestBody users usersDto, HttpServletRequest request){
        log.info("登陆账户,请求参数:"+ JSON.toJSONString(usersDto));
        ResultEncapsulationVO result = federikNetLoginModule.processUserLoginRequest(usersDto,request);
        return result.toString();
    }

    @PostMapping("/checkLogin")
    public String checkLogin(HttpServletRequest request){
        log.info("检查用户是否登陆");
        if(CommUtils.isNull(request.getSession().getAttribute("currentUser"))){
            return ResultEncapsulationVO.fail("用户未登录").toString();
        }
        return ResultEncapsulationVO.success("用户已登陆").toString();
    }

    @PostMapping("/invaliduser")
    public String UserInvalid(){
        log.info("非法登陆:");
        return ResultEncapsulationVO.fail("用户未登陆").toString();
    }

    public static void main(String arg[]){
        System.out.println(CoreMD5.strMD5Encode32("admin"));
    }
}
