package com.wap.model.dao;

import com.wap.model.dto.UserDto;
import com.wap.model.entity.Userr;

public class UserDao extends BaseDao<Userr, UserDto> {

    public UserDao() {
        super.typeTDto = UserDto.class;
        super.typeTEntity = Userr.class;

    }

    public void save(UserDto userDto) {
        super.save(userDto);
    }


}
