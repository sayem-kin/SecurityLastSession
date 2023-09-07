package com.spring.securityPractice.controller;

import com.spring.securityPractice.constants.AppConstants;
import com.spring.securityPractice.model.UserDto;
import com.spring.securityPractice.service.UserService;
import com.spring.securityPractice.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hello2";
    }
   /* @PostMapping("/registration")
    public ResponseEntity<UserDto> register (@RequestBody UserDto userDto) throws Exception {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }*/
    @PostMapping("/registration")
    public ResponseEntity<?> register(@RequestBody UserDto userDto) throws Exception {
        String accessToken = JWTUtils.generateToken(userDto.getEmail());
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("user", userService.createUser(userDto));
        responseBody.put("accessToken", AppConstants.TOKEN_PREFIX + accessToken);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

}
