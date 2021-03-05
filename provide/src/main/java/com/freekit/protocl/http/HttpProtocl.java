package com.freekit.protocl.http;

import com.freekit.entity.Invocation;
import com.freekit.entity.URL;
import com.freekit.protocl.Protocl;

/**
 * @author ：gongxc
 * @description：http协议
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class HttpProtocl implements Protocl {

    @Override
    public Object invokeProtocl(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHost(),url.getPort(),invocation);
    }

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHost(),url.getPort());
        System.out.println("oreiowe");
    }
}
