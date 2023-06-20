package marek.calculator.models.services;

import marek.calculator.models.dto.BasicDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BasicServiceImpl implements BasicService {

    private final int MAX_LENGTH = 500;

    public String calculate(BasicDTO basicDTO) {

        try {
            // Verification of maximum length of numbers
            if (basicDTO.getNumber1().length() > MAX_LENGTH || basicDTO.getNumber2().length() > MAX_LENGTH) {
                return "Maximální délka čísla je 500 znaků";
            }

            BigDecimal num1 = new BigDecimal(basicDTO.getNumber1().trim());
            BigDecimal num2 = new BigDecimal(basicDTO.getNumber2().trim());

            BigDecimal result;

            switch (basicDTO.getOperation()) {
                case "+":
                    result = num1.add(num2);
                    break;
                case "-":
                    result = num1.subtract(num2);
                    break;
                case "*":
                    result = num1.multiply(num2);
                    break;
                case "/":
                    if (num2.compareTo(BigDecimal.ZERO) == 0) {
                        return "Nulou nelze dělit";
                    }
                    result = num1.divide(num2, basicDTO.getDecimal(), BigDecimal.ROUND_HALF_UP);
                    break;
                default:
                    return "Nesprávný operátor";
            }

            // Round the result to the specified number of decimal places
            result = result.setScale(basicDTO.getDecimal(), BigDecimal.ROUND_HALF_UP);

            return result.toString();
        } catch (NumberFormatException e) {
            return "Chybný vstup";
        }
    }
}
