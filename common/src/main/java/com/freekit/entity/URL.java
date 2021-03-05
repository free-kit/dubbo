package com.freekit.entity;

import java.io.Serializable;

/**
 * @author ：gongxc
 * @description：主机的地址和端口  通过网络交互都要实现序列化
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class URL implements Serializable {
    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public URL(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
