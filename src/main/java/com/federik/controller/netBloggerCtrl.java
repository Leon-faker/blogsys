package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.controller.vo.SystemEnum;
import com.federik.mapper.dto.UsersDto;
import com.federik.services.FederikNetLoginModule;
import com.federik.utils.CoreMD5;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/federik")
public class netBloggerCtrl {

    @Resource
    public FederikNetLoginModule federikNetLoginModule;

    @PostMapping("/loginuser")
    public String loginUser(@RequestBody UsersDto usersDto){
        boolean  flag = federikNetLoginModule.processUserLoginRequest(usersDto);
        ResultEncapsulationVO resultEncapsulationVO = new ResultEncapsulationVO();
        if(flag) {
            resultEncapsulationVO.setResultCode(SystemEnum.ResultEnum.loginSuccessful.getResultCode());
            resultEncapsulationVO.setStrDescribe(SystemEnum.ResultEnum.loginSuccessful.getStrDescribe());
        }else {
            resultEncapsulationVO.setResultCode(SystemEnum.ResultEnum.usernameOrPasswordError.getResultCode());
            resultEncapsulationVO.setStrDescribe(SystemEnum.ResultEnum.usernameOrPasswordError.getStrDescribe());
        }
        return resultEncapsulationVO.toString();

    }

    @PostMapping("/invaliduser")
    public String UserInvalid(){
        ResultEncapsulationVO resultEncapsulationVO = new ResultEncapsulationVO();
        resultEncapsulationVO.setResultCode(SystemEnum.ResultEnum.userInvalid.getResultCode());
        resultEncapsulationVO.setStrDescribe(SystemEnum.ResultEnum.userInvalid.getStrDescribe());
        return resultEncapsulationVO.toString();
    }

    public static void main(String arg[]){
        System.out.println(CoreMD5.strMD5Encode32("admin"));
    }
}
