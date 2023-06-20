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

import java.text.DecimalFormat;

@Controller
@RequestMapping(value = "/percent")
public class PercentController {

    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    @Autowired
    private PercentService percentService;
    @GetMapping
    public String renderPercent(PercentDTO percentDTO){
        return "pages/percent";
    }

    @PostMapping (value = "/first")
    public String calculateFirst(@ModelAttribute PercentDTO percentDTO, Model model){

        double result = percentService.calculateFirst(percentDTO);

        String formattedResultFirst = decimalFormat.format(result);

        model.addAttribute("percentResultFirst", formattedResultFirst);

        return "pages/percent";
    }

    @PostMapping (value = "/second")
    public String calculateSecond(@ModelAttribute PercentDTO percentDTO, Model model){

        double result = percentService.calculateSecond(percentDTO);

        String formattedResultSecond = decimalFormat.format(result);

        model.addAttribute("percentResultSecond", formattedResultSecond);

        return "pages/percent";
    }

    @PostMapping (value = "/third")
    public String calculateThird(@ModelAttribute PercentDTO percentDTO, Model model){

        double resultThird = percentService.calculateThird(percentDTO);
        double resultFourth = percentService.calculateFourth(percentDTO);

        String formattedResultThird = decimalFormat.format(resultThird);
        String formattedResultFourth = decimalFormat.format(resultFourth);

        model.addAttribute("percentResultThird", formattedResultThird);
        model.addAttribute("percentResultFourth", formattedResultFourth);

        return "pages/percent";
    }

}
