package com.freekit.entity;

import java.io.Serializable;

/**
 * @author ：gongxc
 * @description：消费着与提供者交换所需的参数 通过网络交互都要实现序列化
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Class[] paramtypes;
    private Object[] objects;

    /**
     *
     * @param interfaceName 接口名字
     * @param methodName 方法名字
     * @param paramtypes 参数类型列表
     * @param objects 参数列表
     */
    public Invocation(String interfaceName, String methodName, Class[] paramtypes, Object[] objects) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramtypes = paramtypes;
        this.objects = objects;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamtypes() {
        return paramtypes;
    }

    public void setParamtypes(Class[] paramtypes) {
        this.paramtypes = paramtypes;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }
}
