package dev.valhala.slam.endpoints;

import dev.valhala.slam.enuns.DeviceStatus;
import dev.valhala.slam.models.Devices;
import dev.valhala.slam.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/devices")
public class DevicesApiEndPoint {

    @Autowired
    private DevicesRepository devicesRepository;

    @GetMapping
    private ResponseEntity<String> getAllDevices(){

        List<Devices> devices = new ArrayList<>();
        devicesRepository.findAll().forEach(devices::add);

        return new ResponseEntity(devices,HttpStatus.OK);
    }

    @PatchMapping("/{token}")
    private ResponseEntity<String> toggleStateDevice(@PathVariable("token") String token) throws Exception {

        Devices device = devicesRepository.findByToken(token);
        if (device != null) {
            if (device.getStatus() == DeviceStatus.ATIVO) {
                device.setStatus(DeviceStatus.DESATIVADO);
            } else if (device.getStatus() == DeviceStatus.DESATIVADO) {
                device.setStatus(DeviceStatus.ATIVO);
            }
            devicesRepository.save(device);
        }

        String response = device.getStatus().name() == null ? "": device.getStatus().name() ;

        return new ResponseEntity(response,HttpStatus.OK);
    }

}
