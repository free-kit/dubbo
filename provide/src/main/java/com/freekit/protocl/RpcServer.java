package com.freekit.protocl;

/**
 * @author ：gongxc
 * @description：rpc服务端
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public interface RpcServer {

    /**
     * 开启服务 监听hostName：port
     * @param hostName
     * @param port
     */
    public void start(String hostName,int port);
}
