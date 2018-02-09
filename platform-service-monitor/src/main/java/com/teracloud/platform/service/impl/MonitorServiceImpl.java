package com.teracloud.platform.service.impl;

import com.teracloud.platform.dao.teracloud.NationDao;
import com.teracloud.platform.entity.teracloud.Nation;
import com.teracloud.platform.service.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements IMonitorService {

    @Autowired
    private NationDao nationDao;

    @Value("${platform.version}")
    private String platformVersion;

    @Override
    public String testHi(String name) {
        System.out.println("version:"+platformVersion);
        List<Nation> allNations = nationDao.findAll();
        System.out.println("nation size:"+allNations.size());
        return "SUCCESS";
    }


}
