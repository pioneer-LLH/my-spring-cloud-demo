package sericefeign.sericefeign.service.impl;

import org.springframework.stereotype.Component;
import sericefeign.sericefeign.service.SchedualServiceHello;

@Component //把类注入到ioc容器中
public class SchedualServiceHelloImpl implements SchedualServiceHello {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,"+name;
    }
}
