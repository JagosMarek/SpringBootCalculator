package marek.calculator.controllers;

import marek.calculator.models.dto.BasicDTO;
import marek.calculator.models.services.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/basic")
public class BasicController {

    @Autowired
    private BasicService basicService;

    @GetMapping
    public String renderBasic(@ModelAttribute BasicDTO basicDTO) {
        return "pages/basic";
    }

    @PostMapping
    public String calculate(@ModelAttribute BasicDTO basicDTO, Model model) {
        String result = basicService.calculate(basicDTO);

        model.addAttribute("result", result);
        return "pages/basic";
    }
}
