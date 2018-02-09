package com.teracloud.platform.service;

import com.teracloud.platform.service.rpc.hystric.MqServiceHystricImpl;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "service-mq",fallback = MqServiceHystricImpl.class)
public interface IMqService {

}
