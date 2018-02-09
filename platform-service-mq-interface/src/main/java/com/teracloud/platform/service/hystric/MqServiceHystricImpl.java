package com.teracloud.platform.service.hystric;

import com.teracloud.platform.service.IMqService;
import org.springframework.stereotype.Component;

@Component
public final class MqServiceHystricImpl implements IMqService{
    /**
     * 测试调用其他服务是否可用
     *
     * @return
     */
    @Override
    public String testCallMonitorService() {
        return "服务不可用";
    }
}
