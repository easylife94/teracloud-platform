package com.teracloud.platform.service.impl;

import com.teracloud.platform.service.IMonitorService;
import com.teracloud.platform.service.IMqService;
import org.springframework.beans.factory.annotation.Autowired;

public class MqServiceImpl implements IMqService {

    @Autowired
    private IMonitorService monitorService;

    /**
     * 测试调用其他服务是否可用
     *
     * @return
     */
    @Override
    public String testCallMonitorService() {
        return monitorService.testHi("mq");
    }
}
