package com.buaa.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("auth2-server")
public interface GatewayFeign {
    @RequestMapping(method = RequestMethod.GET, value = )
}
