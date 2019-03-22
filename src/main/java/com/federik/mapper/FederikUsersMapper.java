package com.federik.mapper;

import com.federik.mapper.dto.UsersDto;
import org.springframework.stereotype.Repository;

@Repository
public interface FederikUsersMapper {

    int selectLoginUser(UsersDto userDto);
}
