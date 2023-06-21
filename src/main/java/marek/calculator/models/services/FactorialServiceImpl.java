package marek.calculator.models.services;

import marek.calculator.models.dto.FactorialDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FactorialServiceImpl implements FactorialService {

    private final int MAX_LENGTH = 10;

    public String calculate(FactorialDTO factorialDTO) {

        if (factorialDTO.getNumber().length() > 10) {
            return "Maximální délka čísla je 10 znaků";
        }
        // Check if the input is a valid number
        String number = factorialDTO.getNumber().trim();
        if (!number.matches("\\d+")) {
            return "Chybný vstup";
        }

        BigDecimal num = new BigDecimal(number);

        if (num.compareTo(new BigDecimal("171")) >= 0) {
            return "Nekonečno";
        }

        if (num.equals(BigDecimal.ZERO)) {
            return "1";
        }

        BigDecimal result = BigDecimal.ONE;
        BigDecimal n = new BigDecimal(num.toBigInteger());

        while (n.compareTo(BigDecimal.ZERO) > 0) {
            result = result.multiply(n);
            n = n.subtract(BigDecimal.ONE);
        }

        return result.toString();
    }
}

