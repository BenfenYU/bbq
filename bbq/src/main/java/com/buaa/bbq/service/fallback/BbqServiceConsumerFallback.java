package com.buaa.bbq.service.fallback;

import com.buaa.bbq.model.User;
import com.buaa.bbq.service.BbqConsumerService;
import org.springframework.stereotype.Component;


// 提供熔断，如果服务提供者挂掉，返回null
// 这个fallback类必须放在其继承的接口的下的一个文件夹里，不能是同一级，否则会报空指针错误，应该是扫描有先后顺序？
@Component
public class BbqServiceConsumerFallback implements BbqConsumerService {

    @Override
    public User getById(Integer userId) {
        return null;
    }
}
