package com.zpark.controller;

import com.zpark.utils.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ys
 * data 2020/7/28 13:51
 */
@Controller
public class getWeatherController {
    /*获取天气
    * */
    @RequestMapping("/getweather")
    public String getweather(){
        return "getpage/weather";
    }
    @RequestMapping("/getweather.do")
    public String getWeather(HttpServletRequest request, HttpServletResponse response){
        String city = request.getParameter("city");
        String url1 = request.getParameter("url1");
        String key = request.getParameter("key");
        String saveFile="in/weather.json";
        System.out.println("city=" + city+"url="+url1+"key="+key);


        HttpUtil.doGetTestWayOne("city="+city, url1, key,saveFile);
            return "getpage/weather";
    }
}
