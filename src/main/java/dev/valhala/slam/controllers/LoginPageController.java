package dev.valhala.slam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginPageController {

    @GetMapping
    private String getPage(){
        return "loginPage";
    }

}
