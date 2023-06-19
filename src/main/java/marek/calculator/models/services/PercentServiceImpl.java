package marek.calculator.models.services;

import marek.calculator.models.dto.PercentDTO;
import org.springframework.stereotype.Service;

@Service
public class PercentServiceImpl implements PercentService {

    public double calculateFirst(PercentDTO percentDTO) {
        return ((double) percentDTO.getPercentNumberFirst() / 100) * percentDTO.getPercentNumberSecond();
    }

    public double calculateSecond(PercentDTO percentDTO) {
        return ((double) (percentDTO.getPercentNumberThird() / percentDTO.getPercentNumberFourth()) * 100);
    }

    public double calculateThird(PercentDTO percentDTO) {
        return ((double) ((percentDTO.getPercentNumberFifth() - percentDTO.getPercentNumberSixth()) / percentDTO.getPercentNumberSixth()) * 100);
    }

    public double calculateFourth(PercentDTO percentDTO) {
        return Math.abs((double) ( 100 - ((percentDTO.getPercentNumberSixth() / percentDTO.getPercentNumberFifth()) * 100)));
    }
}
