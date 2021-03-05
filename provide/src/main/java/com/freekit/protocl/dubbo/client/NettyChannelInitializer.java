package com.freekit.protocl.dubbo.client;

import com.freekit.protocl.dubbo.NettyChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author ：gongxc
 * @description：netty通道初始化
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
        pipeline.addLast("encoder",new ObjectEncoder());
        pipeline.addLast("handler",new NettyChannelHandler());
    }
}
