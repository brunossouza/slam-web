package dev.valhala.slam.repositories;

import dev.valhala.slam.models.Measures;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasureRepository extends CrudRepository<Measures, Long> {
}
