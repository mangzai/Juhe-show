package com.zpark.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zpark.model.News;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author Lucas
 * @Date 2020/6/30 23:15
 * @Version 1.0
 */
public class HttpUtil {
    /**
     * GET---有参测试 (方式一:手动在url后面加上参数)
     *

     */

    public static void doGetTestWayOne(String type,String url,String key,String saveFile) {
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 参数
        StringBuffer params = new StringBuffer();
        try {
            // 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
//            params.append("name=" + URLEncoder.encode("&", "utf-8"));
//            params.append("&");
//            params.append("age=24");
          //  params.append("type=shehui&key=2a66e3684b041ce167839fa5369f04f4");
           // params.append("type="+type+"&key=698c21dd69894b36d683a1da79b548b2");
           // params.append("type="+type+"&key="+key);
            params.append(type+"&key="+key);
//        } catch (UnsupportedEncodingException e1) {
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // 创建Get请求
       // HttpGet httpGet = new HttpGet("http://v.juhe.cn/toutiao/index" + "?" + params);
        HttpGet httpGet = new HttpGet(url + "?" + params);
        System.out.println("地址："+httpGet);

        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();

            // 将上面的配置信息 运用到这个Get请求里
            httpGet.setConfig(requestConfig);

            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);

            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                String s = EntityUtils.toString(responseEntity);
                System.out.println("响应内容为:" + s);
                saveFile(s,saveFile);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void saveFile(String str,String saveFile) {
       // String saveFile = "in/weather.json";
       // String saveFile = "/opt/module/apache-tomcat-9.0.36/webapps/SBoot/in/weather.json";

        File file = new File(saveFile);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            if (!file.exists()) {
                boolean hasFile = file.createNewFile();
                if(hasFile){
                    System.out.println("file not exists, create new file");
                }
                fos = new FileOutputStream(file);
            } else {
                System.out.println("file exists");
               // fos = new FileOutputStream(file, true);
                fos = new FileOutputStream(file, false);
            }

            osw = new OutputStreamWriter(fos, "utf-8");
            osw.write(str); //写入内容
         // osw.write("\r\n");  //换行
        } catch (Exception e) {
            e.printStackTrace();
        }finally {   //关闭流
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

public static void parseJson(String jsonString){
    JSONObject jsonObject = JSON.parseObject(jsonString);
    JSONObject result = jsonObject.getJSONObject("result");
    JSONArray jsonArray = result.getJSONArray("data");
    List<News> news = JSONArray.parseArray(jsonArray.toJSONString(), News.class);
    for (News n:news
         ) {
        String author_name = n.getAuthor_name();
        String date = n.getDate();
        System.out.println(date);
        System.out.println(author_name);
    }
}



   /* public static void main(String[] args) {
     //   doGetTestWayOne("top");
//        saveFile();
    }*/
}
