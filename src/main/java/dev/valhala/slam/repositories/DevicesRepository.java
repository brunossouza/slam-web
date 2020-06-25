package dev.valhala.slam.repositories;

import dev.valhala.slam.enuns.DeviceStatus;
import dev.valhala.slam.models.Devices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevicesRepository extends CrudRepository<Devices, Long> {
    List<Devices> findAllByStatus(DeviceStatus status);
    Devices findByToken(String token);
}
