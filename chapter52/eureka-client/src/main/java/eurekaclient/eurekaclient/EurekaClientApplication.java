package eurekaclient.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }


    @Value("${server.port}") //获取服务器端口号
    String port;  //服务器端口号
    @RequestMapping("/hello")
    public String home(@RequestParam(value="name",defaultValue = "forzezp")String name){

        return "hello spring cloud,name is "+name+",post is "+port;
    }
}
