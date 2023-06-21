package marek.calculator.controllers;

import marek.calculator.models.dto.PercentDTO;
import marek.calculator.models.services.PercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/percent")
public class PercentController {

    @Autowired
    private PercentService percentService;
    @GetMapping
    public String renderPercent(PercentDTO percentDTO){
        return "pages/percent";
    }

    @PostMapping (value = "/first")
    public String calculateFirst(@ModelAttribute PercentDTO percentDTO, Model model){

        String result = percentService.calculateFirst(percentDTO);

        model.addAttribute("result1", result);

        return "pages/percent";
    }

    @PostMapping (value = "/second")
    public String calculateSecond(@ModelAttribute PercentDTO percentDTO, Model model){

        String result = percentService.calculateSecond(percentDTO);

        model.addAttribute("result2", result);

        return "pages/percent";
    }

    @PostMapping (value = "/third")
    public String calculateThird(@ModelAttribute PercentDTO percentDTO, Model model){

        String resultThird = percentService.calculateThird(percentDTO);
        String resultFourth = percentService.calculateFourth(percentDTO);

        model.addAttribute("result3", resultThird);
        model.addAttribute("result4", resultFourth);

        return "pages/percent";
    }
}
