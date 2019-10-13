package com.jill.oldschoolrunescape.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public HelloWorld helloWorld() {
        return new HelloWorld("Hello World", counter.incrementAndGet());
    }
}
