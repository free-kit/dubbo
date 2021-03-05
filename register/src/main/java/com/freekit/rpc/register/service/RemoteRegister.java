package com.freekit.rpc.register.service;

import com.freekit.entity.URL;

/**
 * @author ：gongxc
 * @description：远程注册
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public interface RemoteRegister {
    /**
     * 注册到远程注册中心
     * @param interfaceName
     * @param host
     */
    void register(String interfaceName, URL host);

    /**
     * 根据服务名称获取调用者的地址信息
     * @param interfaceName
     * @return
     */
    URL getRadomURL(String interfaceName);
}
