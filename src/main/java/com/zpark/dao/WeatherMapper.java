package com.zpark.dao;

import com.zpark.model.JuHeModle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ys
 * data 2020/7/29 10:08
 */
@Repository
public interface WeatherMapper {
    /*查询天气
     * weather_weather
     * */
    public List<JuHeModle> selectWeather();

    /*查询风向
     * weather_feng*/
    public List<JuHeModle> selectFeng();
    /*查询温度
    * weather_wendu*/
    public List<JuHeModle> selectWendu();

}

