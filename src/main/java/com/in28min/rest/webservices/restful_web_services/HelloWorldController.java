package com.in28min.rest.webservices.restful_web_services;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String helloWorld() {
        return  "Hello World!";
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello");
    }

    @GetMapping(path = "/hello-world/path-var/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("hello path variable: " + name);
    }
}
