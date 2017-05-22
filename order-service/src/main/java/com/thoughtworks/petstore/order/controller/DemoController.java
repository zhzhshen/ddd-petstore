package com.thoughtworks.petstore.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.petstore.order.domain.DemoObj;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value="/api/hello")
public class DemoController {
	@Autowired
    private DiscoveryClient client;
	
	@Value("${demo.env}")
	private String env;

	@ApiOperation(value="测试从配置文件读取信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "Hello! It's " + env  + ". " + localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
    }
	
	@ApiOperation(value="测试单个请求参数")
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String hello(@ApiParam(required=true, name="name", value="名称") @PathVariable String name) {
        return "Hello! " + name;
    }
	
	@ApiOperation(value="测试多个请求参数")
    @RequestMapping(value = "/{greeting}", method = RequestMethod.POST)
    public String hello(
    		@ApiParam(required=true, name="greeting", value="自定义问候语") @PathVariable String greeting, 
    		@RequestBody DemoObj obj) {
        return greeting + "! " + obj.getName();
    }
	
	/**
	 * ApiIgnore注解用于Controller层，当前Controller所有方法不可见
	 * ApiIgnore注解用于方法层，当前方法不可见
	 * ApiIgnore注解用于参数层，当前属性不可见
	 */
	@ApiIgnore
	@ApiOperation(value="测试@ApiIgnore")
    @RequestMapping(value = "/testIgnore/{name}", method = RequestMethod.POST)
    public String testIgnore(@ApiParam(required=true, name="name", value="名称") @PathVariable String name) {
        return "Hello! " + name;
    }
}
