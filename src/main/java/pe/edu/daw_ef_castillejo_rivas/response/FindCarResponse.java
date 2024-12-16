package pe.edu.daw_ef_castillejo_rivas.response;

import pe.edu.daw_ef_castillejo_rivas.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto user) {

}
