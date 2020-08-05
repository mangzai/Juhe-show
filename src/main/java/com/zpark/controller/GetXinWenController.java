package com.zpark.controller;

import com.zpark.utils.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ys
 * data 2020/7/28 10:31
 */
@Controller
public class GetXinWenController {
    /*获取新闻页面
     * */
    @RequestMapping("/getxinwen")
    public String getxinwen() {
        return "getpage/xinwen";
    }

    @RequestMapping("getxinwen.do")
    //  @ResponseBody
    public String getXinWenData(HttpServletRequest request, HttpServletResponse response, Model model) {
        String type = request.getParameter("type1");
        String url1 = request.getParameter("url1");
        String key = request.getParameter("key");
        String saveFile="in/xinwen.json";

        System.out.println("type:" + type);
        HttpUtil.doGetTestWayOne("type="+type, url1, key,saveFile);
//        model.addAttribute("msg","成功");
        return "getpage/xinwen";
    }



}
