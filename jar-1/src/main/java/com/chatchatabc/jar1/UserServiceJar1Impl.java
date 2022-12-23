package com.chatchatabc.jar1;

import com.chatchatabc.user.UserService;

public class UserServiceJar1Impl implements UserService {
    @Override
    public String findNameById(Integer id) {
        return "Jar1";
    }
}
