package com.zpark.controller;

import com.zpark.model.JuHeModle;
import com.zpark.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ys
 * data 2020/7/29 10:22
 */
@Controller
public class showWeatherController {
    /*页面
     * */
    @RequestMapping("/showweather")
    public String showWeather() {
        return "showpage/test";
    }

    /*后台数据
     * */
    @Autowired
    WeatherService weatherService;
    HashMap<String, Integer> map = new HashMap<>();

    /*查询天气的业务
     * weather_weather*/
    @RequestMapping("toWeather.do")
    @ResponseBody
    public Map<String, Integer> weather(JuHeModle juHeModle) {
        if (juHeModle != null) {
            List<JuHeModle> weatherList = weatherService.selectweather();
            for (JuHeModle weather : weatherList
            ) {
                map.put(weather.getName(), weather.getCount());
                System.out.println(weather);
            }
        } else {
            map.put("result", 1);
        }
        System.out.println("+++++++++++++++++++++++++++++");
        return map;
    }

    /*查询风向的业务
     * weather_fenng*/
    @RequestMapping("toFeng.do")
    @ResponseBody
    public Map<String, Integer> feng(JuHeModle juHeModle) {
        if (juHeModle != null) {
            List<JuHeModle> fengList = weatherService.selectFeng();
            for (JuHeModle feng : fengList
            ) {
                map.put(feng.getName(), feng.getCount());
                System.out.println(feng);
            }
        } else {
            map.put("result", 1);
        }
        System.out.println("++++++++++++++++++++++++++++++");
        return map;
    }

    /*查询温度的业务
     * weather_wendu*/
    @RequestMapping("toWendu.do")
    @ResponseBody
    public Map<String, Integer> wendu(JuHeModle juHeModle) {
        if (juHeModle != null) {
            List<JuHeModle> wenduList = weatherService.selectWendu();
            for (JuHeModle wendu : wenduList
            ) {
                map.put(wendu.getName(), wendu.getCount());
            }
        } else {
            map.put("result", 1);
        }
        return map;
    }
}
