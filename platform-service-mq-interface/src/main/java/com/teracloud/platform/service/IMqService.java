package com.teracloud.platform.service;

import com.teracloud.platform.service.hystric.MqServiceHystricImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-mq",fallback = MqServiceHystricImpl.class)
public interface IMqService {

    /**
     * 测试调用其他服务是否可用
     * @return
     */
    @RequestMapping(value = "/test/callMonitorService",method = RequestMethod.GET)
    String testCallMonitorService();
}
