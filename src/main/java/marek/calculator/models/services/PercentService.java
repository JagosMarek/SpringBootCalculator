package marek.calculator.models.services;

import marek.calculator.models.dto.PercentDTO;

public interface PercentService {

    double calculateFirst(PercentDTO percentDTO);

    double calculateSecond(PercentDTO percentDTO);

    double calculateThird(PercentDTO percentDTO);

    double calculateFourth(PercentDTO percentDTO);
}
