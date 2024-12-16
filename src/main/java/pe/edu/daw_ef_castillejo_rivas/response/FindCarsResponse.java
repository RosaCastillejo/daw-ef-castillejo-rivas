package pe.edu.daw_ef_castillejo_rivas.response;

import pe.edu.daw_ef_castillejo_rivas.dto.CarDto;

public record FindCarsResponse(
        String code,
        String error,
        Iterable<CarDto> users) {
}
