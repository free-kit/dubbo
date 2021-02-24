package com.freekit;


import com.freekit.entity.URL;
import com.freekit.rpc.register.remote.zookeeper.ZookeepRemoteRegister;
import com.freekit.rpc.register.remote.zookeeper.ZookeeperClient;
import com.freekit.service.HelloService;
import org.junit.Before;

public class ZookeepRemoteRegisterTest {

    ZookeepRemoteRegister remoteRegister;

    @Before
    public void setUp() throws Exception {
        remoteRegister = new ZookeepRemoteRegister(new ZookeeperClient());
    }

    @org.junit.Test
    public void register() {

        remoteRegister.register(HelloService.class.getName(),new URL("localhost",8021));
    }

    @org.junit.Test
    public void getRadomURL() {
        register();
        remoteRegister.getRadomURL(HelloService.class.getName());
    }
}