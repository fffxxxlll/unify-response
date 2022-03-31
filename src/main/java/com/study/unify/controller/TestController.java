package com.study.unify.controller;

import com.study.unify.annotation.ResponseResult;
import com.study.unify.common.ErrorResult;
import com.study.unify.common.Result;
import com.study.unify.common.ResultCode;
import com.study.unify.entity.TestInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Slf4j
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "nothing";
    }

    @GetMapping("test")
    @ResponseResult
    public Object test(@RequestParam(required = false) Integer id) {
        if(id==null) {
            return new ErrorResult(ResultCode.PARAM_IS_BLANK);
        }
        return new TestInfo(String.format("成功,id为%d", id));
    }
}
