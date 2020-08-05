package com.zpark.service;

import com.zpark.dao.WeatherMapper;
import com.zpark.model.JuHeModle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ys
 * data 2020/7/29 10:18
 */
@Service
public class WeatherService {
    @Autowired
    WeatherMapper weatherMapper;

    /*天气的查询
    weather_weater*/
    public List<JuHeModle> selectweather() {
        return weatherMapper.selectWeather();
    }

    /*风向的查询
     weather_feng*/
    public List<JuHeModle> selectFeng() {
        return weatherMapper.selectFeng();
    }

    /*温度的查询
     * weather_wendu*/
    public List<JuHeModle> selectWendu() {
        return weatherMapper.selectWendu();
    }

}
