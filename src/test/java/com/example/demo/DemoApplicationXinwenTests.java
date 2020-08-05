package com.example.demo;

import com.zpark.model.JuHeModle;
import com.zpark.service.XinWenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author ys
 * data 2020/7/29 21:07
 */
@SpringBootTest
public class DemoApplicationXinwenTests {
    @Autowired
    XinWenService xinWenService;

    @Test
    public void selectAuthor() {
        List<JuHeModle> authorList = xinWenService.seelectAuthor();
        System.out.println(authorList);
    }

    @Test
    public void selectCategory() {
        List<JuHeModle> categoryList = xinWenService.selectCategory();
        System.out.println(categoryList);
    }

    @Test
    public void selectUrl() {
        List<JuHeModle> urlList = xinWenService.selectUrl();
        System.out.println(urlList);
    }
}
