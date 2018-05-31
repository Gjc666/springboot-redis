package com.mr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ${Gjc} on 2018/5/30.
 */
@RestController
public class rest {

    @GetMapping("test")
    public String test(){
        return "test  .. springboot--get";
    }
}
