package dev.valhala.slam.repositories;

import dev.valhala.slam.models.Measures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeasureRepository extends CrudRepository<Measures, Long> {

    @Query(value = "SELECT AVG(m.current) FROM measures m WHERE m.created_at BETWEEN '2020-08-01' and '2020-08-31'", nativeQuery = true)
    Double getMeasuresCurrentAverage();

    @Query(value = "SELECT AVG(m.voltage) FROM measures m WHERE m.created_at BETWEEN '2020-08-01' and '2020-08-31'", nativeQuery = true)
    Double getMeasuresVoltageAverage();

    @Query(value = "SELECT AVG(m.power) FROM measures m WHERE m.created_at BETWEEN '2020-08-01' and '2020-08-31'", nativeQuery = true)
    Double getMeasuresPowerAverage();
}
