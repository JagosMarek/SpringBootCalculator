package marek.calculator.models.services;

import marek.calculator.models.dto.AverageDTO;

public interface AverageService {

    String average(AverageDTO averageDTO);

    String median(AverageDTO averageDTO);
}
