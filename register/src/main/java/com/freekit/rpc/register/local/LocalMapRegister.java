package com.freekit.rpc.register.local;

import com.freekit.rpc.register.service.LocalRegister;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：gongxc
 * @description：本地注册
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class LocalMapRegister implements LocalRegister {

    //创建一个缓存
    private Map<String, Class> registerMap = new HashMap<String,Class>(1024);

    @Override
    public void register(String interfaceName, Class interfaceImplClass) {
        registerMap.put(interfaceName,interfaceImplClass);
    }

    @Override
    public Class get(String interfaceName) {
        return registerMap.get(interfaceName);
    }
}
