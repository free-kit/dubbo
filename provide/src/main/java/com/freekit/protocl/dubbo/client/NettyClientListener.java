package com.freekit.protocl.dubbo.client;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author ：gongxc
 * @description：netty监听器
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public interface NettyClientListener {
    void channelRead(ChannelHandlerContext ctx, Object message);
}
