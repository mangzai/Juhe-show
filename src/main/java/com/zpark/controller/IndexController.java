package com.zpark.controller;

import com.zpark.model.Ip;
import com.zpark.service.IpService;
import com.zpark.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    IpService ipService;

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }
  /*  @RequestMapping("/getxinwen1")
    public String getxinwen(){return "getpage/xinwen1";}*/

    @RequestMapping("/hello1")
    public String hello1() {
        return "showpage/ip1";
    }
    @RequestMapping("/get.do")
    @ResponseBody
    public String get() {
        Ip ip = ipService.select();
        System.out.println(ip);
        return ip.toString();
    }

   /* @RequestMapping("/toServer1.do")
    @ResponseBody
    public Map<String, Integer[]> sendString(Ip ip) {    //user是与页面参数对应的JavaBean
        //map集合用来存放返回值
        Map<String, Integer[]> map = new HashMap<String, Integer[]>();
        if (ip != null) {
            map.put("result", new Integer[]{1, 2, 3, 4, 5, 6});
        } else {
            map.put("result", new Integer[]{1, 2, 3, 4, 5, 6});
        }
        return map;
    }*/

    @RequestMapping("/toServer.do")
    @ResponseBody
    public Map<String, Integer> ipString(Ip ip) {
        HashMap<String, Integer> map = new HashMap<>();
        if (ip != null) {
            List<Ip> list = ipService.findAll();
            for (Ip list1 : list
            ) {
                map.put(list1.getIp(), list1.getCount());
                System.out.println(list1);
                // map.put("result" ,list1.getCount() );
            }

        } else {
            map.put("result", 1);
        }
        System.out.println(map);
        return map;
    }


  /*  @RequestMapping("getJuheDate.do1")
    public String getJuheData(HttpServletRequest request, HttpServletResponse response) {
        String type = request.getParameter("type");
        System.out.println(type);
        HttpUtil.doGetTestWayOne(type);
        return "getpage/xinwen1";
    }*/

}
