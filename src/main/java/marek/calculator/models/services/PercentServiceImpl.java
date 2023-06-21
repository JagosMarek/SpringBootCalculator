package marek.calculator.models.services;

import marek.calculator.models.dto.PercentDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PercentServiceImpl implements PercentService {

    private final int MAX_LENGTH = 500;

    public String calculateFirst(PercentDTO percentDTO) {
        try {
            // Verification of maximum length of numbers
            if (percentDTO.getNumber1().length() > MAX_LENGTH || percentDTO.getNumber2().length() > MAX_LENGTH) {
                return "Maximální délka čísla je 500 znaků";
            }

            BigDecimal num1 = new BigDecimal(percentDTO.getNumber1().trim());
            BigDecimal num2 = new BigDecimal(percentDTO.getNumber2().trim());

            BigDecimal result;

            // round the number to 10 places (if I get an infinite number)
            result = num1.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP).multiply(num2);

            // Round the result to the specified number of decimal places
            result = result.setScale(percentDTO.getDecimal1(), RoundingMode.HALF_UP);

            return result.toString();
        } catch (NumberFormatException e) {
            return "Chybný vstup";
        }
    }

    public String calculateSecond(PercentDTO percentDTO) {

        try {
            // Verification of maximum length of numbers
            if (percentDTO.getNumber3().length() > MAX_LENGTH || percentDTO.getNumber4().length() > MAX_LENGTH) {
                return "Maximální délka čísla je 500 znaků";
            }

            BigDecimal num1 = new BigDecimal(percentDTO.getNumber3().trim());
            BigDecimal num2 = new BigDecimal(percentDTO.getNumber4().trim());

            // round the number to 10 places (if I get an infinite number)
            BigDecimal result = num1.divide(num2, 10, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

            // Round the result to the specified number of decimal places
            result = result.setScale(percentDTO.getDecimal2(), RoundingMode.HALF_UP);

            return result.toString();
        } catch (NumberFormatException e) {
            return "Chybný vstup";
        }
    }


    public String calculateThird(PercentDTO percentDTO) {

        try {
            // Verification of maximum length of numbers
            if (percentDTO.getNumber5().length() > MAX_LENGTH || percentDTO.getNumber6().length() > MAX_LENGTH) {
                return "Maximální délka čísla je 500 znaků";
            }

            BigDecimal num1 = new BigDecimal(percentDTO.getNumber5().trim());
            BigDecimal num2 = new BigDecimal(percentDTO.getNumber6().trim());

            // round the number to 10 places (if I get an infinite number)
            BigDecimal result = ((num1.subtract(num2)).divide(num2, 10, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100));

            // Round the result to the specified number of decimal places
            result = result.setScale(percentDTO.getDecimal3(), RoundingMode.HALF_UP).abs();

            int comparison = num1.compareTo(num2);

            if (comparison < 0) {
                return num1 + " je o " + result + " % méně než " + num2;
            } else if (comparison > 0) {
                return num1 + " je o " + result + " % více než " + num2;
            } else {
               return "Obě hodnoty jsou stejné";
            }

        } catch (NumberFormatException e) {
            return "Chybný vstup";
        }
    }


    public String calculateFourth(PercentDTO percentDTO) {

        try {

            BigDecimal num1 = new BigDecimal(percentDTO.getNumber5().trim());
            BigDecimal num2 = new BigDecimal(percentDTO.getNumber6().trim());

            // round the number to 10 places (if I get an infinite number)
            BigDecimal result = BigDecimal.valueOf(100).subtract((num2.divide(num1, 10, RoundingMode.HALF_UP)).multiply(BigDecimal.valueOf(100)));

            // Round the result to the specified number of decimal places
            result = result.setScale(percentDTO.getDecimal3(), RoundingMode.HALF_UP).abs();

            int comparison = num2.compareTo(num1);

            if (comparison < 0) {
                return num2 + " je o " + result + " % méně než " + num1;
            } else if (comparison > 0) {
                return num2 + " je o " + result + " % více než " + num1;
            } else {
                return "";
            }

        } catch (NumberFormatException e) {
            return "";
        }
    }
}
