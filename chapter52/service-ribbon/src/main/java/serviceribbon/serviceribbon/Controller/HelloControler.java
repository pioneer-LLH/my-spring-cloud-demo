package serviceribbon.serviceribbon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceribbon.serviceribbon.service.HelloService;

@RestController
public class HelloControler {
    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hello")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }
}
