package dev.valhala.slam.repositories;

import dev.valhala.slam.beans.MonthlyConsumptionChart;
import dev.valhala.slam.models.Measures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
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

    @Query(value = "SELECT NEW dev.valhala.slam.beans.MonthlyConsumptionChart(to_char(m.createdAt, 'MM'), avg(m.power)) FROM Measures m WHERE m.createdAt >= :limit GROUP BY to_char(m.createdAt, 'MM') ORDER BY to_char(m.createdAt, 'MM')")
    List<MonthlyConsumptionChart> getMonthlyConsuption(@Param("limit") Calendar data);
}
