package com.freekit.rpc.register.remote.zookeeper;

import com.alibaba.fastjson.JSONObject;
import com.freekit.entity.URL;
import com.freekit.rpc.register.service.RemoteRegister;

import java.util.List;
import java.util.Random;

/**
 * @author ：gongxc
 * @description：zk注册
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class ZookeepRemoteRegister implements RemoteRegister {

    private ZookeeperClient client;

    public ZookeepRemoteRegister(ZookeeperClient zookeeperClient) {
        this.client = zookeeperClient;
    }


    @Override
    public void register(String interfaceName, URL host) {
        try{
            StringBuilder nodePath = new StringBuilder("/");
            nodePath.append(interfaceName).append("/").append(JSONObject.toJSONString(host));
            if (client.started()){
                client.createNodePath(nodePath.toString(),"111");
            }
        }catch (Exception e){

        }
    }

    @Override
    public URL getRadomURL(String interfaceName) {
        try {
            StringBuilder nodepath = new StringBuilder("/");
            nodepath.append(interfaceName);
            List<URL> urls = client.getChildNodes(nodepath.toString());
            Random random = new Random();
            int i = random.nextInt(urls.size());
            return urls.get(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
