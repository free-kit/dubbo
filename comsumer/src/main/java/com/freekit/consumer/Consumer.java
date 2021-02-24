package com.freekit.consumer;

import com.freekit.entity.ProtoclType;
import com.freekit.entity.RegisterType;
import com.freekit.service.HelloService;

/**
 * @author ：gongxc
 * @description：消费者
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(ProtoclType.HTTP, RegisterType.ZOOKEEPER,HelloService.class);
        String result = helloService.sayHello("gongxc");
        System.out.println(result);
    }
}
