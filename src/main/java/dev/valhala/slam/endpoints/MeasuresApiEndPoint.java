package dev.valhala.slam.endpoints;

import dev.valhala.slam.models.Devices;
import dev.valhala.slam.models.Measures;
import dev.valhala.slam.repositories.DevicesRepository;
import dev.valhala.slam.repositories.MeasureRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MeasuresApiEndPoint {

    @Autowired
    private MeasureRepository measureRepository;
    @Autowired
    private DevicesRepository devicesRepository;

    @PostMapping(value = "/{device_token}/measures", consumes = "application/json")
    public ResponseEntity registryMensure(@RequestBody Measures measure, @PathVariable("device_token") String deviceToken){
        Devices device = devicesRepository.findByToken(deviceToken);
        if(device == null){
            return ResponseEntity.badRequest().build();
        }
        measure.setDevices(device);
        measureRepository.save(measure);
        return ResponseEntity.ok().build();
    }

}