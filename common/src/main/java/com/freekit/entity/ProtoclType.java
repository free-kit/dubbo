package com.freekit.entity;

/**
 * @author ：gongxc
 * @description：协议类型枚举
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public enum ProtoclType {

    HTTP("http",1),NETTY("netty",2);
    private String protoclName;
    private int proctolNum;

    ProtoclType(String protoclName, int proctolNum) {
        this.protoclName = protoclName;
        this.proctolNum = proctolNum;
    }

    public String getProtoclName() {
        return protoclName;
    }


    public int getProctolNum() {
        return proctolNum;
    }

}
