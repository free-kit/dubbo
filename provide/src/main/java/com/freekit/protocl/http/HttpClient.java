package com.freekit.protocl.http;

import com.freekit.entity.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * @author ：gongxc
 * @description：http协议post请求
 * @date ：2021/2/24
 * @version: 1.0.0$
 */
public class HttpClient {
    public String post(String hostName, int port , Invocation invocation){
        ObjectOutputStream objectOutputStream = null;
        try {
            URL url = new URL("http",hostName,port,"/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            objectOutputStream = new ObjectOutputStream( connection.getOutputStream());
            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();
            InputStream inputStream = connection.getInputStream();
            String result = IOUtils.toString(inputStream);
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream!=null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
