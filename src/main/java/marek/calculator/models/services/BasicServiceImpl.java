package marek.calculator.models.services;

import marek.calculator.models.dto.BasicDTO;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

    public double calculate(BasicDTO basicDTO){
        if(basicDTO.getOperation().equals("+")){
            return basicDTO.getNumber1()+ basicDTO.getNumber2();
        } else if (basicDTO.getOperation().equals("-")){
            return basicDTO.getNumber1()- basicDTO.getNumber2();
        } else if (basicDTO.getOperation().equals("*")){
            return basicDTO.getNumber1()* basicDTO.getNumber2();
        } else {
            if(basicDTO.getNumber2() == 0){
                throw new IllegalArgumentException("Second number cannot be 0!");
            } return basicDTO.getNumber1()/ basicDTO.getNumber2();
        }
    }
}
