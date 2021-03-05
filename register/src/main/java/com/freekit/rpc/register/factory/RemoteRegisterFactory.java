package com.freekit.rpc.register.factory;

import com.freekit.entity.RegisterType;
import com.freekit.rpc.register.remote.RemoterMapRegister;
import com.freekit.rpc.register.remote.zookeeper.ZookeepRemoteRegister;
import com.freekit.rpc.register.remote.zookeeper.ZookeeperClient;
import com.freekit.rpc.register.service.RemoteRegister;

/**
 * @author ：gongxc
 * @description：远程工厂
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class RemoteRegisterFactory {
    private static RemoterMapRegister remoterMapRegister = new RemoterMapRegister();
    private static ZookeepRemoteRegister zookeepRemoteRegister = new ZookeepRemoteRegister(new ZookeeperClient());
    public static RemoteRegister getRemoteRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL:return remoterMapRegister;
            case ZOOKEEPER: return zookeepRemoteRegister;
            default:return null;
        }
    }
}
