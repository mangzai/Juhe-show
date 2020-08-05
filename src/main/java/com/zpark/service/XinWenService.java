package com.zpark.service;

import com.zpark.dao.XinWenMapper;
import com.zpark.model.JuHeModle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ys
 * data 2020/7/29 20:22
 */
@Service
public class XinWenService {
    @Autowired
    XinWenMapper xinWenMapper;

    /*查询新闻作者名称的业务xinwen_author_name*/
    public List<JuHeModle> seelectAuthor() {
        return xinWenMapper.selectAuthor();
    }

    /*查询新闻类别的业务xinwen_category*/
    public List<JuHeModle> selectCategory() {
        return xinWenMapper.selectCategory();
    }

    /*查询新闻地址的业务xinwen_url*/
    public List<JuHeModle> selectUrl() {
        return xinWenMapper.selectUrl();
    }
}
