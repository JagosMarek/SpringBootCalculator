package marek.calculator.models.dto;

public class GeneratorDTO {

    private String number1;
    private String number2;
    private int rangeNumber = 1;
    private String operation;

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public int getRangeNumber() {
        return rangeNumber;
    }

    public void setRangeNumber(int rangeNumber) {
        this.rangeNumber = rangeNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
