package com.zpark.service;

import com.zpark.dao.IpMapper;
import com.zpark.model.Ip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IpService {
    @Autowired
    IpMapper ipMapper;

    public Ip select() {
        return ipMapper.sel();
    }

    public List<Ip> findAll() {
        return ipMapper.findAll();
    }
}
