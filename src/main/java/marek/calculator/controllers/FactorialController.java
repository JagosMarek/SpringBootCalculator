package marek.calculator.controllers;

import marek.calculator.models.dto.FactorialDTO;
import marek.calculator.models.services.FactorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/factorial")
public class FactorialController {

    @Autowired
    private FactorialService factorialService;

    @GetMapping
    public String renderFactorial(FactorialDTO factorialDTO){
        return "pages/factorial";
    }

    @PostMapping
    public String calculate(FactorialDTO factorialDTO, Model model){

        String result = factorialService.calculate(factorialDTO);

        model.addAttribute("result", result);

        return "pages/factorial";
    }

}
