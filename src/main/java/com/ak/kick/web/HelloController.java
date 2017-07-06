package com.ak.kick.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ak on 7/6/17.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping
    public String hello() {
        return "hello spring boot";
    }
}
