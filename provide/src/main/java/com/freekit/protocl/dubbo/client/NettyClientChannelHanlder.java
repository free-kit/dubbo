package com.freekit.protocl.dubbo.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author ：gongxc
 * @description：netty处理器
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class NettyClientChannelHanlder extends ChannelInboundHandlerAdapter {
    private NettyClientListener listener;

    public NettyClientChannelHanlder(NettyClientListener listener) {
        this.listener = listener;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        listener.channelRead(ctx,msg);
    }
}
