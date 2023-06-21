package marek.calculator.models.services;

import marek.calculator.models.dto.GeneratorDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    public String calculate(GeneratorDTO generatorDTO) {

        try {
            String number1 = generatorDTO.getNumber1().trim();
            String number2 = generatorDTO.getNumber2().trim();

            // Verification of maximum length of numbers
            if (number1.length() > 18 || number2.length() > 18) {
                return "Maximální délka čísla je 18 znaků";
            }

            long num1 = Long.parseLong(number1);
            long num2 = Long.parseLong(number2);

            // Check if the first number is greater than the second number
            if (num1 > num2) {
                return "Číslo \"od\" nemůže být větší než číslo \"do\"";
            }

            int repetition = generatorDTO.getRangeNumber();
            StringBuilder result = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < repetition; i++) {
                long randomNumber = random.nextLong(num1 -1, num2) +1;
                if(i+1 == repetition){
                    result.append(randomNumber);
                } else {
                    result.append(randomNumber).append(" ");
                }
            }

            if(generatorDTO.getOperation().equals("comma")){
                return result.toString().replace(" ", ", ");
            } else if (generatorDTO.getOperation().equals("noSpace")) {
                return result.toString().replace(" ", "");
            } else {
                return result.toString();
            }

        } catch (NumberFormatException e) {
            return "Chybný vstup";
        }
    }
}
