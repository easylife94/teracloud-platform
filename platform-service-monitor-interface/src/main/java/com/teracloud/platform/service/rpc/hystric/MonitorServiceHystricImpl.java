package com.teracloud.platform.service.rpc.hystric;

import com.teracloud.platform.service.IMonitorService;
import org.springframework.stereotype.Component;

@Component
public class MonitorServiceHystricImpl implements IMonitorService {
    @Override
    public String testHi(String name) {
        return "Sorry "+name;
    }
}
