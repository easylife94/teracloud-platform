package com.teracloud.platform.controller;

import com.teracloud.platform.service.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private IMonitorService monitorService;

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String testHi(@RequestParam("name") String name){
        System.out.println(name);
        return "hi!It's work."+monitorService.testHi(name);
    }
}
