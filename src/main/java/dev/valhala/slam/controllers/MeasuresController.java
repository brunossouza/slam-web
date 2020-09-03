package dev.valhala.slam.controllers;

import dev.valhala.slam.models.Devices;
import dev.valhala.slam.models.Measures;
import dev.valhala.slam.repositories.DevicesRepository;
import dev.valhala.slam.repositories.MeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/measures")
public class MeasuresController {
    private static final String PAGE_HTML = "pages/measures";

    @Autowired
    private DevicesRepository devicesRepository;

    @Autowired
    private MeasureRepository measureRepository;

    @GetMapping("/{device}")
    public ModelAndView getPage(@PathVariable("device") String deviceToken){
        ModelAndView view = new ModelAndView(PAGE_HTML);

        Devices device = devicesRepository.findByToken(deviceToken);
        List<Measures> measuresList = measureRepository.findAllByDevicesOrderByCreatedAtDesc(device);

        view.addObject("device",device);
        view.addObject("measuresList",measuresList);

        return view;
    }

}
