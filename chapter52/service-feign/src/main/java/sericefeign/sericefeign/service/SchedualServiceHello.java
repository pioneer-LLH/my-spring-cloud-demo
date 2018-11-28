package sericefeign.sericefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sericefeign.sericefeign.service.impl.SchedualServiceHelloImpl;

@FeignClient(value = "eureka-client",fallback = SchedualServiceHelloImpl.class) //value指定调用哪个服务,fallback指定调用哪个断路器
public interface SchedualServiceHello {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
