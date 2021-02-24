package com.freekit.rpc.register.factory;

import com.freekit.entity.RegisterType;
import com.freekit.rpc.register.local.LocalMapRegister;
import com.freekit.rpc.register.service.LocalRegister;

/**
 * @author ：gongxc
 * @description：本地工厂
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class LocalRegisterFactory {
    private static LocalMapRegister localMapRegister = new LocalMapRegister();
    public static LocalRegister getLocalRegister(RegisterType registerType){
        switch (registerType){
            case LOCAL: return localMapRegister;
            default:return null;
        }
    }
}
