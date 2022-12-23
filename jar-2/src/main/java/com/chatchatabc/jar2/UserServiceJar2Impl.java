package com.chatchatabc.jar2;

import com.chatchatabc.user.UserService;

public class UserServiceJar2Impl implements UserService {
    @Override
    public String findNameById(Integer id) {
        return "Jar2";
    }
}
