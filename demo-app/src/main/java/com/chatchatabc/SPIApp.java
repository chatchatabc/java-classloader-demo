package com.chatchatabc;

import com.chatchatabc.user.UserService;

import java.util.ServiceLoader;

public class SPIApp {
    public static void main(String[] args) {
        ServiceLoader<UserService> loader = ServiceLoader.load(UserService.class);
        loader.forEach(userService -> {
            System.out.println(userService.findNameById(1));
        });
    }
}
