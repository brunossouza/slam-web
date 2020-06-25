package dev.valhala.slam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charts")
public class ChartsController {

    @GetMapping
    private String getPage(){
        return "pages/charts";
    }
}
