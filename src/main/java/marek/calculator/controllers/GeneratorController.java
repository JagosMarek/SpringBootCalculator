package marek.calculator.controllers;

import marek.calculator.models.dto.GeneratorDTO;
import marek.calculator.models.services.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @GetMapping
    public String renderGenerator(GeneratorDTO generatorDTO){
        return "pages/generator";
    }

    @PostMapping
    public String calculate(@ModelAttribute GeneratorDTO generatorDTO, Model model) {
        String result = generatorService.calculate(generatorDTO);

        model.addAttribute("result", result);
        return "pages/generator";
    }
}

