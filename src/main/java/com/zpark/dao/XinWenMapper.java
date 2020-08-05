package com.zpark.dao;

import com.zpark.model.JuHeModle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ys
 * data 2020/7/29 20:13
 */
@Repository
public interface XinWenMapper {
    /*
    查询新闻作者名称
    xinwen_author_name
    */
    public List<JuHeModle> selectAuthor();

    /*查询新闻分类
     * xinwen_category*/
    public List<JuHeModle> selectCategory();

    /*查询新闻地址
     * xinwen_category*/
    public List<JuHeModle> selectUrl();
}
