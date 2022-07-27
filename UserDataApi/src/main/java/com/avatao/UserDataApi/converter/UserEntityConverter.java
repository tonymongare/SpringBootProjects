package com.avatao.UserDataApi.converter;

import com.avatao.UserDataApi.UserDto;
import com.avatao.UserDataApi.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {
    public UserDto toDto(User userEntity) {
        return new UserDto(userEntity.getName());
    }

    public User toEntity(UserDto userDto) {
        return new User(userDto.getName());
    }
}
