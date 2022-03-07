package com.example.seckilldemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 *
 * @author: LC
 * @date 2022/3/1 4:22 下午
 * @ClassName: DemoController
 */
@Controller
@RequestMapping("demo")
public class DemoController {

    /**
     * 测试页面
     * @param model
     * @return java.lang.String
     * @author LC
     * @operation add
     * @date 4:25 下午 2022/3/1
     **/
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "example");
        return "hello";
    }
}
