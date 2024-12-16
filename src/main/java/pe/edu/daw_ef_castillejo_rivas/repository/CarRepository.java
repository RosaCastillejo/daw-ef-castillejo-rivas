package pe.edu.daw_ef_castillejo_rivas.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.daw_ef_castillejo_rivas.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
