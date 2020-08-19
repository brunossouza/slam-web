package dev.valhala.slam.endpoints;

import dev.valhala.slam.enuns.DeviceStatus;
import dev.valhala.slam.models.Devices;
import dev.valhala.slam.models.Measures;
import dev.valhala.slam.repositories.DevicesRepository;
import dev.valhala.slam.utils.generators.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @PostMapping(value = "/registry", produces = "application/json")
    public ResponseEntity registryDevice(@RequestBody String deviceConnected){
        System.out.println(deviceConnected);
        Devices device = new Devices();
        device.setToken(TokenGenerator.create());
        device.setDevice(deviceConnected);
        device.setStatus(DeviceStatus.CONFIGURAR);
        device.setDateActivation(Calendar.getInstance());
        devicesRepository.save(device);
        return ResponseEntity.ok(device);
    }

    @PatchMapping("/{token}")
    private ResponseEntity<String> toggleStateDevice(@PathVariable("token") String token){

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
