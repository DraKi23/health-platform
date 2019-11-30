package com.gop3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Drgn on 2019/11/26 23:21
 */
@RestController
@RequestMapping("/temp")
public class TmpController {

    @RequestMapping("hello")
    public String sayHello(){
        return "Hello world!";
    }
}
