package com.zpark.model;

/**
 * @author ys
 * data 2020/7/29 10:03
 */
public class JuHeModle {
    private String name;
    private Integer count;

    public JuHeModle(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "juheModle{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
