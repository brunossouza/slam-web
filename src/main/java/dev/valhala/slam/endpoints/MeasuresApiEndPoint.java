package dev.valhala.slam.endpoints;

import dev.valhala.slam.beans.MonthlyConsumptionChart;
import dev.valhala.slam.models.Devices;
import dev.valhala.slam.models.Measures;
import dev.valhala.slam.repositories.DevicesRepository;
import dev.valhala.slam.repositories.MeasureRepository;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/measures")
public class MeasuresApiEndPoint {

    @Autowired
    private MeasureRepository measureRepository;
    @Autowired
    private DevicesRepository devicesRepository;

    @PostMapping(value = "/{device_token}", consumes = "application/json")
    public ResponseEntity registryMensure(@RequestBody Measures measure, @PathVariable("device_token") String deviceToken){
        Devices device = devicesRepository.findByToken(deviceToken);
        if(device == null){
            return ResponseEntity.badRequest().build();
        }
        measure.setDevices(device);
        measureRepository.save(measure);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getMonthlyConsuption(){
        Calendar c = Calendar.getInstance();
        List<MonthlyConsumptionChart> consumptionChartList = measureRepository.getMonthlyConsuption(c);
        return ResponseEntity.ok(consumptionChartList);
    }

}
