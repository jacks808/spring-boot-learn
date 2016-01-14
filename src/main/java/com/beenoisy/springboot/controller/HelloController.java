/*
 * spring-boot-learn - com.beenoisy.springboot.controller.HelloController.java
 * ziyi.wang
 */
package com.beenoisy.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ziyi.wang<br>
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return "Hello, this is a spring boot learn project.";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String post(
                    String name) {
        return "Hello " + name + ", this is a spring boot learn project.";
    }
}
