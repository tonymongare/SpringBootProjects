package com.avatao.UserDataApi.service;

import com.avatao.UserDataApi.UserDto;
import com.avatao.UserDataApi.converter.UserEntityConverter;
import com.avatao.UserDataApi.model.User;
import com.avatao.UserDataApi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserEntityConverter userEntityConverter;


    public List<UserDto> getUser() {
        return userRepository.findAll()
                .stream()
                .map(userEntityConverter::toDto)
                .collect(Collectors.toList());
    }



    public void addUser(UserDto userDto) {
        final User newUserEntity = userEntityConverter.toEntity(userDto);
        userRepository.save(newUserEntity);
    }


}
