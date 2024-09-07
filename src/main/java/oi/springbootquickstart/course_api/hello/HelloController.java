package oi.springbootquickstart.course_api.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //This is the annotation we use to map any particular URL and what we want to do in the response
public class HelloController {

    @RequestMapping("/hello") //This annotation will execute the method ones user provided this url
    public String sayHello(){
        return "Hello";
    }
}
