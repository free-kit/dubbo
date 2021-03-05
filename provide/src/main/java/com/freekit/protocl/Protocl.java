package com.freekit.protocl;

import com.freekit.entity.Invocation;
import com.freekit.entity.URL;

/**
 * @author ：gongxc
 * @description：协议接口
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public interface Protocl {
    /**
     * 远程调用
     * @param url
     * @param invocation
     */
    Object invokeProtocl(URL url, Invocation invocation);

    /**
     * 服务开启
     * @param url
     */
    void start(URL url);
}