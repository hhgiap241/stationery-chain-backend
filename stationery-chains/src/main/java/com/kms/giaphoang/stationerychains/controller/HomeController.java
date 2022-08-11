package com.kms.giaphoang.stationerychains.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : giaphoang
 * @mailto : hoanghuugiap241@gmail.com
 * @created : 8/11/2022, Thursday
 * @project: stationery-chains
 **/
@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
