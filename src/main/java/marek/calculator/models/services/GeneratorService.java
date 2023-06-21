package marek.calculator.models.services;

import marek.calculator.models.dto.FactorialDTO;
import marek.calculator.models.dto.GeneratorDTO;

public interface GeneratorService {

    String calculate(GeneratorDTO generatorDTO);
}
