package com.freekit.protocl.dubbo;

import com.freekit.entity.Invocation;
import com.freekit.entity.URL;
import com.freekit.protocl.Protocl;
import com.freekit.protocl.dubbo.client.NettyClient;

/**
 * @author ：gongxc
 * @description：netty请求
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class NettyProtocl  implements Protocl {

    @Override
    public Object invokeProtocl(URL url, Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHost(),url.getPort(),invocation);
    }

    @Override
    public void start(URL url) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(url.getHost(),url.getPort());
    }
}
