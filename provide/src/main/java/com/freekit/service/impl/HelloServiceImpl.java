package com.freekit.service.impl;

import com.freekit.service.HelloService;

/**
 * @author ：gongxc
 * @description：功能测试
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("hello," + name);
        return "hello " + name;
    }
}
