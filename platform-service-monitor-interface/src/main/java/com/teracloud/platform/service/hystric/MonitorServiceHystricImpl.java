package com.teracloud.platform.service.hystric;

import com.teracloud.platform.service.IMonitorService;
import org.springframework.stereotype.Component;

@Component
public final class MonitorServiceHystricImpl implements IMonitorService {
    @Override
    public String testHi(String name) {
        return "Sorry "+name;
    }
}
