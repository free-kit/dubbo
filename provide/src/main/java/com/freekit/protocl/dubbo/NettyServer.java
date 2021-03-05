package com.freekit.protocl.dubbo;

import com.freekit.protocl.RpcServer;
import com.freekit.protocl.dubbo.client.NettyChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author ：gongxc
 * @description：netty协议调用
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class NettyServer implements RpcServer {
    @Override
    public void start(String hostName, int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup wrokeGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,wrokeGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new NettyChannelInitializer());
        try {
            System.out.println("Netty Server start listering host:" + hostName + "port:" + port);
            ChannelFuture channelFuture = serverBootstrap.bind(hostName,port).sync();
            channelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            wrokeGroup.shutdownGracefully();
        }
    }
}
