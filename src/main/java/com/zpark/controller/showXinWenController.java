package com.zpark.controller;

import com.zpark.model.JuHeModle;
import com.zpark.service.WeatherService;
import com.zpark.service.XinWenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ys
 * data 2020/7/29 19:48
 */
@Controller
public class showXinWenController {
    /*页面XinWen*/

    /*XinWen后台数据*/
    @Autowired
    XinWenService xinWenService;
    HashMap<String, Integer> map = new HashMap<>();

    /*获取作者名称
    xinwen_author_name的业务*/
    @RequestMapping("toAuthor.do")
    @ResponseBody
    public Map<String, Integer> author(JuHeModle juHeModle) {
        if (juHeModle != null) {
            List<JuHeModle> authorList = xinWenService.seelectAuthor();
            for (JuHeModle author : authorList
            ) {
                map.put(author.getName(), author.getCount());
            }
        } else {
            map.put("result", 1);
        }
        return map;
    }

    /*获取新闻类别的业务
     * xinwen_category*/
    @RequestMapping("toCategory.do")
    @ResponseBody
    public Map<String, Integer> category(JuHeModle juHeModle) {
        if (juHeModle != null) {
            List<JuHeModle> categoryList = xinWenService.selectCategory();
            for (JuHeModle category : categoryList
            ) {
                map.put(category.getName(), category.getCount());
            }
        } else {
            map.put("result", 1);
        }
        return map;
    }

    /*获取新闻地址的业务
     * xinwen_url*/
    @RequestMapping("toUrl.do")
    @ResponseBody
    public Map<String, Integer> url(JuHeModle juHeModle) {
        if (juHeModle != null) {
            List<JuHeModle> urlList = xinWenService.selectUrl();
            for (JuHeModle url : urlList
            ) {
                map.put(url.getName(), url.getCount());
            }
        } else {
            map.put("result", 1);
        }
        return map;
    }
}
