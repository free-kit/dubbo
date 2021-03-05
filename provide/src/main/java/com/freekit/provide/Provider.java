package com.freekit.provide;

import com.freekit.entity.ProtoclType;
import com.freekit.entity.RegisterType;
import com.freekit.entity.URL;
import com.freekit.protocl.Protocl;
import com.freekit.protocl.ProtoclFactory;
import com.freekit.rpc.register.factory.LocalRegisterFactory;
import com.freekit.rpc.register.factory.RemoteRegisterFactory;
import com.freekit.rpc.register.service.LocalRegister;
import com.freekit.rpc.register.service.RemoteRegister;
import com.freekit.service.HelloService;
import com.freekit.service.impl.HelloServiceImpl;

/**
 * @author ：gongxc
 * @description：提供者启动
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class Provider {
    public static void main(String[] args) {
        System.out.println("jdioqweio");
        //主机的地址和端口
        URL url = new URL("localhost",8021);

        //本地注册
        LocalRegister localRegister = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL);
        localRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

        //远程注册
        RemoteRegister register = RemoteRegisterFactory.getRemoteRegister(RegisterType.ZOOKEEPER);
        register.register(HelloService.class.getName(),url);

        //启动容器（tomcat, netty)
       // Protocl protocl = ProtoclFactory.getProtocl(ProtoclType.HTTP);

        Protocl protocl = ProtoclFactory.getProtocl(ProtoclType.NETTY);
        protocl.start(url);

        System.out.println("jdioqweio");
    }
}
