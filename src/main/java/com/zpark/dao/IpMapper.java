package com.zpark.dao;

import com.zpark.model.Ip;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ys
 * data 2020/6/26 17:25
 */
    @Repository
    public interface IpMapper {
      public  Ip sel();
      //查询所有ip
      public List<Ip> findAll();

    }



