package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.common.ResponseObject;
import com.soft1851.spring.web.service.LolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 12559
 */
@Controller
@RequestMapping(value = "/")
public class LOLController {
    @Resource
    private LolService lolService;

    @GetMapping(value = "LOL", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getTopics() {
        ResponseObject rs = new ResponseObject(1, "success", lolService.queryAll());
        return JSONObject.toJSONString(rs);
    }
}
