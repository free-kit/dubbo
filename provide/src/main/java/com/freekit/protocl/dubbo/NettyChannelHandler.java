package com.freekit.protocl.dubbo;

import com.freekit.entity.Invocation;
import com.freekit.entity.RegisterType;
import com.freekit.rpc.register.factory.LocalRegisterFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;

/**
 * @author ：gongxc
 * @description：解析netty请求的信息并进行处理
 * @date ：2021/2/24
 * @version: $
 */
public class NettyChannelHandler extends ChannelInboundHandlerAdapter {

    public NettyChannelHandler() {
        super();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Invocation invocation = (Invocation) msg;
        String interfaceName = invocation.getInterfaceName();
        Class interfaceImplClass = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(interfaceName);
        Method method = interfaceImplClass.getMethod(invocation.getMethodName(),invocation.getParamtypes());
        String result = (String) method.invoke(interfaceImplClass.newInstance(),invocation.getObjects());
        ctx.write(result);
        ctx.flush();
    }
}
