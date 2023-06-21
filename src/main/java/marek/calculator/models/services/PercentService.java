package marek.calculator.models.services;

import marek.calculator.models.dto.PercentDTO;

public interface PercentService {

    String calculateFirst(PercentDTO percentDTO);
    String calculateSecond(PercentDTO percentDTO);
    String calculateThird(PercentDTO percentDTO);
    String calculateFourth(PercentDTO percentDTO);

}
