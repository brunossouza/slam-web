package dev.valhala.slam.controllers;

import dev.valhala.slam.models.Devices;
import dev.valhala.slam.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/devices")
public class DevicesController {
    private static final String PAGE_DEVICES_HTML = "pages/devices";

    @Autowired
    private DevicesRepository devicesRepository;

    @GetMapping
    private ModelAndView getPage() {
        ModelAndView view = new ModelAndView(PAGE_DEVICES_HTML);
        Iterable<Devices> devicesIterable = devicesRepository.findAll();
        view.addObject("devices", devicesIterable);
        return view;
    }
}
