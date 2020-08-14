package dev.valhala.slam.controllers;

import dev.valhala.slam.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/","/home","/dashboard"})
public class DashboardController {

    private static final String PATH_PAGE = "/pages/dashboard";

    @Autowired
    private DevicesRepository devicesRepository;

    @GetMapping
    public ModelAndView dashboard(){
        ModelAndView view = new ModelAndView(PATH_PAGE);

        view.addObject("totalDevices", devicesRepository.count());

        return view;
    }

}
