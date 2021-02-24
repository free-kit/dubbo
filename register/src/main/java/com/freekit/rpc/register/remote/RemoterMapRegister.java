package com.freekit.rpc.register.remote;

import com.freekit.entity.URL;
import com.freekit.rpc.register.service.RemoteRegister;

import java.io.*;
import java.util.*;

/**
 * @author ：gongxc
 * @description：远程注册
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class RemoterMapRegister implements RemoteRegister {
    //缓存
    private Map<String, List<URL>> registerMap = new HashMap<String,List<URL>>(1024);

    //文件地址
    public static final String path = "/data/register";

    @Override
    public void register(String interfaceName, URL host) {
        if(registerMap.containsKey(interfaceName)){
            List<URL> list = registerMap.get(interfaceName);
            list.add(host);
        }else {
            List<URL> list = new LinkedList<URL>();
            list.add(host);
            registerMap.put(interfaceName,list);
        }
        try {
            saveFile(path,registerMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public URL getRadomURL(String interfaceName) {
        try {
            registerMap = (Map<String, List<URL>>) readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<URL> list = registerMap.get(interfaceName);
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }

    /**
     * 写入文件
     * @param path
     * @param object
     * @throws IOException
     */
    private void saveFile(String path,Object object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
    }

    /**
     * 从文件中读取
     * @param path
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private Object readFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        return inputStream.readObject();
    }
}
