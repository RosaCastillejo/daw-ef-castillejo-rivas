package pe.edu.daw_ef_castillejo_rivas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import pe.edu.daw_ef_castillejo_rivas.dto.CarDetailDto;
import pe.edu.daw_ef_castillejo_rivas.dto.CarDto;
import pe.edu.daw_ef_castillejo_rivas.response.*;
import pe.edu.daw_ef_castillejo_rivas.service.ManagerService;


@RestController
@RequestMapping("/manager-car")
public class ManagerCarApi {


        @Autowired
        ManagerService managerService;

        @GetMapping("/all")
        public FindCarsResponse findCars() {

            try {
                List<CarDto> users = managerService.getAllCars();
                if (!users.isEmpty())
                    return new FindCarsResponse("01", null, users);
                else
                    return new FindCarsResponse("02", "Users not found", null);

            } catch (Exception e) {
                e.printStackTrace();
                return new FindCarsResponse("99", "An error ocurred, please try again", null);

            }

        }

    @GetMapping("/detail")
    public FindCarResponse findCar(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<CarDetailDto> optional = managerService.getCarById(Integer.parseInt(id));
            return optional.map(car ->
                    new FindCarResponse("01", null, car)
            ).orElse(
                    new FindCarResponse("02", "User not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarResponse("99", "An error ocurred, please try again", null);

        }

    }

        @PutMapping("/update")
        public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {

            try {
                if (managerService.updateCar(carDto))
                    return new UpdateCarResponse("01", null);
                else
                    return new UpdateCarResponse("02", "User not found");

            } catch (Exception e) {
                e.printStackTrace();
                return new UpdateCarResponse("99", "An error ocurred, please try again");

            }

        }

    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {

        try {
            if (managerService.deleteCarById(Integer.parseInt(id)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "User not found");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error ocurred, please try again");

        }

    }

        @PostMapping("/create")
        public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {

            try {
                if (managerService.addCar(carDetailDto))
                    return new CreateCarResponse("01", null);
                else
                    return new CreateCarResponse("02", "User already exists");

            } catch (Exception e) {
                e.printStackTrace();
                return new CreateCarResponse("99", "An error ocurred, please try again");

            }

        }

    }

