package com.chatchatabc;

import com.chatchatabc.user.UserService;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class App {
    public static void main(String[] args) throws Exception {
        Class<UserService> clazz = UserService.class;
        final ClassLoader parentLoader = clazz.getClassLoader();
        final URL jarUrl = new File("jar-1/target/jar-1-1.0.0-SNAPSHOT.jar").toURI().toURL();
        try (URLClassLoader customLoader = new URLClassLoader(new java.net.URL[]{jarUrl}, parentLoader)) {
            final Class<?> jar1ImplClass = customLoader.loadClass("com.chatchatabc.jar1.UserServiceJar1Impl");
            final UserService userService = (UserService) jar1ImplClass.getConstructor().newInstance();
            System.out.println(userService.findNameById(1));
        }
    }
}
