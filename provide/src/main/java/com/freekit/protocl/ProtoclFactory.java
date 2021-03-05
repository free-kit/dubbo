package com.freekit.protocl;

import com.freekit.entity.ProtoclType;
import com.freekit.protocl.dubbo.NettyProtocl;
import com.freekit.protocl.http.HttpProtocl;

/**
 * @author ：gongxc
 * @description：协议工厂
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class ProtoclFactory {
    private static NettyProtocl nettyProtocl = new NettyProtocl();
    private static HttpProtocl httpProtocl = new HttpProtocl();
    public static Protocl getProtocl(ProtoclType protoclType){
        switch (protoclType){
            case HTTP: return httpProtocl;
            case NETTY: return nettyProtocl;
            default:return null;
        }
    }
}
