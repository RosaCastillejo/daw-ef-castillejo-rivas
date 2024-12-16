package pe.edu.daw_ef_castillejo_rivas.service;

import pe.edu.daw_ef_castillejo_rivas.dto.CarDetailDto;
import pe.edu.daw_ef_castillejo_rivas.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDto carDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
