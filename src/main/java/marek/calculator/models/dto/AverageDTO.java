package marek.calculator.models.dto;



public class AverageDTO {

    private String averageNumbers;
    private String medianNumbers;
    private int averageDecimal = 1;
    private int medianDecimal = 1;

    public int getMedianDecimal() {
        return medianDecimal;
    }
    public void setMedianDecimal(int medianDecimal) {
        this.medianDecimal = medianDecimal;
    }
    public int getAverageDecimal() {
        return averageDecimal;
    }

    public void setAverageDecimal(int averageDecimal) {
        this.averageDecimal = averageDecimal;
    }

    public String getMedianNumbers() {
        return medianNumbers;
    }

    public void setMedianNumbers(String medianNumbers) {
        this.medianNumbers = medianNumbers;
    }

    public String getAverageNumbers() {
        return averageNumbers;
    }
    public void setAverageNumbers(String averageNumbers) {
        this.averageNumbers = averageNumbers;
    }
}
