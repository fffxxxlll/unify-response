package com.study.unify.controller;

import com.study.unify.annotation.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController {

    @GetMapping("test")
    @ResponseResult
    public String test(@RequestParam(required = false) Integer id) {
        if(id==null) {
            return "id为空";
        }
        return String.format("成功,id为%d", id);
    }
}
