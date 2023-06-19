package marek.calculator.controllers;

import marek.calculator.models.dto.AverageDTO;
import marek.calculator.models.services.AverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/average")
public class AverageController {

    @Autowired
    private AverageService averageService;

    @GetMapping
    public String renderAverage(AverageDTO averageDTO){
        return "pages/average";
    }

    @PostMapping (value = "/mean")
    public String calculateAverage(AverageDTO averageDTO, Model model){

        String result = averageService.average(averageDTO);

        model.addAttribute("resultAverage", result);

        return "pages/average";
    }

    @PostMapping (value = "/median")
    public String calculateMedian(AverageDTO averageDTO, Model model){
        String result = averageService.median(averageDTO);
        model.addAttribute("resultMedian", result);
        return "pages/average";

    }
}
