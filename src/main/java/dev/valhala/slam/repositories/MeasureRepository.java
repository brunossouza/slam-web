package dev.valhala.slam.repositories;

import dev.valhala.slam.models.Measures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface MeasureRepository extends CrudRepository<Measures, Long> {

    @Query(value = "SELECT AVG(m.current) FROM Measures m")
    Double getMeasuresCurrentAverage();

    @Query(value = "SELECT AVG(m.voltage) FROM Measures m")
    Double getMeasuresVoltageAverage();

    @Query(value = "SELECT AVG(m.power) FROM Measures m")
    Double getMeasuresPowerAverage();

    @Query(value = "SELECT to_char(m.createdAt, 'MM'), avg(m.power) FROM Measures m WHERE m.createdAt >= '2019-08-26' GROUP BY to_char(m.createdAt, 'MM') ORDER BY to_char(m.createdAt, 'MM')")
    Object[][] getMonthlyConsuption();
}
