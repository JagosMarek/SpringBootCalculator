package marek.calculator.models.services;

import marek.calculator.models.dto.FactorialDTO;
import org.springframework.stereotype.Service;

@Service
public class FactorialServiceImpl implements FactorialService{

    public long calculate(FactorialDTO factorialDTO){
        long n = 1;
        for(int i = 1; i <= factorialDTO.getNumber(); i++){
            n*=i;
        }
        return n;
    }
}
