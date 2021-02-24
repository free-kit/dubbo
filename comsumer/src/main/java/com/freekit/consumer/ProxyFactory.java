package com.freekit.consumer;

import com.freekit.entity.Invocation;
import com.freekit.entity.ProtoclType;
import com.freekit.entity.RegisterType;
import com.freekit.entity.URL;
import com.freekit.protocl.Protocl;
import com.freekit.protocl.ProtoclFactory;
import com.freekit.rpc.register.factory.RemoteRegisterFactory;
import com.freekit.rpc.register.service.RemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：gongxc
 * @description：代理工厂通过jdk生成实体
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class ProxyFactory {
    public static <T> T getProxy(final ProtoclType protoclType , final RegisterType registerType, final Class interfaceClass){
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocl protocl = ProtoclFactory.getProtocl(protoclType);
                Invocation invocation = new Invocation(interfaceClass.getName(),method.getName(),method.getParameterTypes(),args);
                RemoteRegister remoteRegister = RemoteRegisterFactory.getRemoteRegister(registerType);
                URL radomURL = remoteRegister.getRadomURL(interfaceClass.getName());
                System.out.println("调用地址host:"+ radomURL.getHost()+ ",port:"+radomURL.getPort());
                return protocl.invokeProtocl(radomURL,invocation);
            }
        });
    }
}
