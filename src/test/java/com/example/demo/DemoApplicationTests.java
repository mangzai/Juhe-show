package com.example.demo;

import com.zpark.dao.WeatherMapper;
import com.zpark.model.JuHeModle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    WeatherMapper weatherMapper;

    @Test
    public void selectWeather() {
        List<JuHeModle> list = weatherMapper.selectWeather();
        System.out.println(list);
    }

    @Test
    public void selectFeng() {
        List<JuHeModle> feng = weatherMapper.selectFeng();
        System.out.println(feng);
    }

    @Test
    public void selectWendu() {
        List<JuHeModle> wendu = weatherMapper.selectWendu();
        System.out.println(wendu);
    }
}
