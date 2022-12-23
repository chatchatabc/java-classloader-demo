package com.chatchatabc;


import com.chatchatabc.user.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {
    private static URLClassLoader customLoader;

    @BeforeAll
    public static void setUp() throws Exception {
        ClassLoader parentLoader = UserService.class.getClassLoader();
        URL jarUrl = new File("../jar-1/target/jar-1-1.0.0-SNAPSHOT.jar").toURI().toURL();
        customLoader = new URLClassLoader(new java.net.URL[]{jarUrl}, parentLoader);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        customLoader.close();
    }

    @Test
    public void testLoadJar1Service() throws Exception {
        final Class<?> jar1ServiceClazz = customLoader.loadClass("com.chatchatabc.jar1.Jar1Service");
        final Object obj = jar1ServiceClazz.getConstructor().newInstance();
        final Method sayHello = jar1ServiceClazz.getMethod("sayHello");
        final Object result = sayHello.invoke(obj);
        System.out.println(result);
    }

    @Test
    public void testLoadJar1() throws Exception {
        final Class<?> jar1ImplClass = customLoader.loadClass("com.chatchatabc.jar1.UserServiceJar1Impl");
        final UserService userService = (UserService) jar1ImplClass.getConstructor().newInstance();
        System.out.println(userService.findNameById(1));
    }


}
