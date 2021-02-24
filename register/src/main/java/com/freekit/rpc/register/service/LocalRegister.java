package com.freekit.rpc.register.service;

/**
 * @author ：gongxc
 * @description：本地注册  （要是集成spring 该接口就实现spring FactoryBean ）{FactoryBean的作用就是生成bean 通过接口来实现多态}
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public interface LocalRegister {
    /**
     *
     * @param interfaceName 接口名称
     * @param interfaceImplClass 接口实现类
     */
    void register(String interfaceName,Class interfaceImplClass);

    /**
     * 获取实现类
     * @param interfaceName
     * @return
     */
    Class get(String interfaceName);
}
