package com.example.javabackendtheoryspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public GreetingResponse sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        String greeting = helloService.getGreeting(name);
        return new GreetingResponse(greeting);
    }
}