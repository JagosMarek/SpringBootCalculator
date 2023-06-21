package marek.calculator.models.services;

import marek.calculator.models.dto.BasicDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

                    // round the number to 10 places (if I get an infinite number)
                    result = num1.divide(num2,10, RoundingMode.HALF_UP);
                    break;
                default:
                    return "Nesprávný operátor";
            }

            // Round the result to the specified number of decimal places
            result = result.setScale(basicDTO.getDecimal(), RoundingMode.HALF_UP);

            return result.toString();
        } catch (NumberFormatException e) {
            return "Chybný vstup";
        }
    }
}
