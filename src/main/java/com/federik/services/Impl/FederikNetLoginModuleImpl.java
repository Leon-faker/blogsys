package com.federik.services.Impl;

import com.federik.mapper.FederikUsersMapper;
import com.federik.mapper.dto.UsersDto;
import com.federik.services.FederikNetLoginModule;
import com.federik.utils.CoreMD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class FederikNetLoginModuleImpl implements FederikNetLoginModule {

    @Resource
    public FederikUsersMapper federikUsersMapper;

    @Override
    public boolean processUserLoginRequest(UsersDto usersDto) {
        if(Objects.isNull(usersDto)){
            return false;
        }
        usersDto.setNetUserPassword(CoreMD5.strMD5Encode32(usersDto.getNetUserPassword()));
        int index = federikUsersMapper.selectLoginUser(usersDto);
        return index > 0?true:false;
    }
}
