package marek.calculator.models.services;

import marek.calculator.models.dto.AverageDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Service
public class AverageServiceImpl implements AverageService {

    private final int MAX_LENGTH = 500;

    public String average(AverageDTO averageDTO) {
        String allowedNumbers = validNumbersAverage(averageDTO);
        if (allowedNumbers.length() > MAX_LENGTH) {
            return "Too long, max length si 500";
        }

        String[] numberStrings = allowedNumbers.split(" ");
        BigDecimal[] numbers = new BigDecimal[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            try {
                numbers[i] = new BigDecimal(numberStrings[i]);
            } catch (NumberFormatException e) {
                return "Incorrect input.";
            }
        }

        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal number : numbers) {
            sum = sum.add(number);
        }

        BigDecimal mean = sum.divide(BigDecimal.valueOf(numbers.length), averageDTO.getAverageDecimal(), RoundingMode.HALF_UP);
        return mean.toPlainString();
    }

    public String median(AverageDTO averageDTO) {
        String allowedNumbers = validNumbersMedian(averageDTO);
        if (allowedNumbers.length() > MAX_LENGTH) {
            return "Too long, max length si 500";
        }

        String[] numberStrings = allowedNumbers.split(" ");
        BigDecimal[] numbers = new BigDecimal[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            try {
                numbers[i] = new BigDecimal(numberStrings[i]);
            } catch (NumberFormatException e) {
                return "Incorrect input.";
            }
        }

        Arrays.sort(numbers);
        int length = numbers.length;
        int middleIndex = length / 2;

        if (length % 2 != 0) {
            return numbers[middleIndex].setScale(averageDTO.getMedianDecimal(), RoundingMode.HALF_UP).toPlainString();
        } else {
            BigDecimal sum = numbers[middleIndex - 1].add(numbers[middleIndex]);
            BigDecimal median = sum.divide(BigDecimal.valueOf(2), averageDTO.getMedianDecimal(), RoundingMode.HALF_UP);
            return median.toPlainString();
        }
    }

    private String validNumbersAverage(AverageDTO averageDTO) {
        String allowedChar = "0123456789.- ";
        StringBuilder validChars = new StringBuilder();

        String text = averageDTO.getAverageNumbers().trim();
        text = text.replaceAll("\\s+", " ");

        for (char c : text.toCharArray()) {
            if (allowedChar.contains(String.valueOf(c))) {
                validChars.append(c);
            } else {
                return "";
            }
        }
        return validChars.toString();
    }

    private String validNumbersMedian(AverageDTO averageDTO) {
        String allowedChar = "0123456789.- ";
        StringBuilder validChars = new StringBuilder();

        String text = averageDTO.getMedianNumbers().trim();
        text = text.replaceAll("\\s+", " ");

        for (char c : text.toCharArray()) {
            if (allowedChar.contains(String.valueOf(c))) {
                validChars.append(c);
            } else {
                return "";
            }
        }
        return validChars.toString();
    }
}
