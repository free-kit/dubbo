package com.freekit.protocl.http;

import com.freekit.entity.Invocation;
import com.freekit.entity.RegisterType;
import com.freekit.rpc.register.factory.LocalRegisterFactory;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：gongxc
 * @description：req请求做处理   任何请求被进来都会被这个sevlet处理
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)  {
        // 获取对象
        try {
            InputStream is = req.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(is);
            Invocation invocation = (Invocation) objectInputStream.readObject();
            String interfaceName = invocation.getInterfaceName();
            Class interfaceImplClass = LocalRegisterFactory.getLocalRegister(RegisterType.LOCAL).get(interfaceName);
            Method method = interfaceImplClass.getMethod(invocation.getMethodName(),invocation.getParamtypes());
            String result = (String) method.invoke(interfaceImplClass.newInstance(),invocation.getObjects());
            IOUtils.write(result,resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
