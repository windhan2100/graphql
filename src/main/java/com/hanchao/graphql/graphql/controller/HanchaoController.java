package com.hanchao.graphql.graphql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Just for test
 *
 * @author hanliwei
 * @create 2019-02-24 9:27
 */
@RestController
public class HanchaoController {

    @GetMapping("/test")
    public String testSpringBoot() {
        return "Hello, springboot";
    }
}
