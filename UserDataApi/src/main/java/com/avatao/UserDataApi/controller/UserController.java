package com.avatao.UserDataApi.controller;

/*
import com.avatao.UserDataApi.UserDto;
import com.avatao.UserDataApi.model.User;
import com.avatao.UserDataApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/avatao/get")
    public List<UserDto> getUser() {
        return userRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    private UserDto entityToDto(User userEntity) {
        return new UserDto(userEntity.getName());
    }

}

*/
import com.avatao.UserDataApi.UserDto;
import com.avatao.UserDataApi.errorresponse.ErrorResponse;
import com.avatao.UserDataApi.service.UserService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/avatao")
@RestController
@AllArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/get")
    public List<UserDto> getUser() {
        return userService.getUser();
    }


    @PutMapping("/put")
    public void addUser(@NotNull @RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidTopTalentDataException(MethodArgumentNotValidException methodArgumentNotValidException) {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<ObjectError> validationErrors = bindingResult.getAllErrors();

        return ErrorResponse.fromValidationErrors(validationErrors);
    }



}


