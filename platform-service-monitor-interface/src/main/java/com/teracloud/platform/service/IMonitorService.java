package com.teracloud.platform.service;

import com.teracloud.platform.service.hystric.MonitorServiceHystricImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 监控服务接口
 * <p/>
 *
 */
@FeignClient(value = "service-monitor",fallback = MonitorServiceHystricImpl.class)
public interface IMonitorService {

    /**
     * 框架测试
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String testHi(@RequestParam(value = "name") String name);



}
