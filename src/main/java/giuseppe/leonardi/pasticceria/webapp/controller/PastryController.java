package giuseppe.leonardi.pasticceria.webapp.controller;

import giuseppe.leonardi.pasticceria.webapp.models.Ingredient;
import giuseppe.leonardi.pasticceria.webapp.models.Pastry;
import giuseppe.leonardi.pasticceria.webapp.service.PastryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/pastry")
public class PastryController {
    @Autowired
    private PastryService pastryService;

    @GetMapping("/managePastry")
    public String getPastryBackOffice(Model model){
        model.addAttribute("pastries", pastryService.getAllPastries());
        return "managePastry";
    }

    @GetMapping({"/newPastry", "/editPastry"})
    public String getPastryModal(Model model, @RequestParam Optional<Long> pastryId){
        model.addAttribute("isNew", !pastryId.isPresent());
        model.addAttribute("pastry", pastryId.isPresent() ? pastryService.getPastry(pastryId.get()) : new Pastry());
        return "pastryModal";
    }

    @PostMapping("/savePastry")
    public String savePastry(@ModelAttribute Pastry thePastry){
        pastryService.savePastry(thePastry);
        return "redirect:/pastry/managePastry";
    }

    @GetMapping("/addRecipe")
    public String getRecipeModal(Model model, @RequestParam Optional<Long> pastryId){
        model.addAttribute("pastryId", pastryId);
        model.addAttribute("ingredient", new Ingredient());
        return "recipeModal";
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute Ingredient Ingredient, @RequestParam Optional<Long> pastryId){

        return "redirect:/pastry/managePastry";
    }

}
