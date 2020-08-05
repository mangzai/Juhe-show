package com.zpark.model;

public class Ip {
    private String ip;
    private int count;

    //alt+fn+Insert
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Ip{" +
                "ip='" + ip + '\'' +
                ", count=" + count +
                '}';
    }
}

