package giuseppe.leonardi.pasticceria.webapp.controller;

import giuseppe.leonardi.pasticceria.webapp.models.dao.Ingredient;
import giuseppe.leonardi.pasticceria.webapp.models.dao.Pastry;
import giuseppe.leonardi.pasticceria.webapp.models.dao.SellPastry;
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
        Pastry pastry = pastryId.isPresent() ?  pastryService.getPastry(pastryId.get()) : new Pastry();
        model.addAttribute("pastry", pastry);
        return "pastryModal";
    }

    @PostMapping("/savePastry")
    public String savePastry(@ModelAttribute Pastry thePastry){
        pastryService.savePastry(thePastry);
        return "redirect:/pastry/managePastry";
    }

    @DeleteMapping("/deletePastry/{pastryId}")
    @ResponseBody
    public String deletePastry(@PathVariable("pastryId") Optional<Long> pastryId){
        pastryService.deletePastry(pastryId);
        return "ok";
    }

    @GetMapping("/addRecipe")
    public String getRecipeModal(Model model, @RequestParam Optional<Long> pastryId){
        Ingredient ingredient = new Ingredient();
        ingredient.setParentPastry(pastryService.getPastry(pastryId.get()));
        model.addAttribute("ingredient", ingredient);
        return "recipeModal";
    }

    @PostMapping("/saveRecipe")
    public String saveRecipe(@ModelAttribute Ingredient ingredient){
        pastryService.saveIngredient(ingredient);
        return "redirect:/pastry/managePastry";
    }

    @DeleteMapping("/deleteIngredient/{ingredientId}")
    @ResponseBody
    public String deleteIngredient(@PathVariable("ingredientId") Optional<Long> ingredientId){
        pastryService.deleteIngredient(ingredientId);
        return "ok";
    }

    @GetMapping("/newSellPastry")
    public String getNewSellPastryModal(Model model, @RequestParam Optional<Long> pastryId){
        SellPastry sellPastry = new SellPastry();
        sellPastry.setPastry(pastryService.getPastry(pastryId.get()));
        model.addAttribute("sellPastry", sellPastry);
        return "sellPastryModal";
    }

    @PostMapping("/saveSellPastry")
    public String saveSellPastry(@ModelAttribute SellPastry sellPastry){
        pastryService.saveSellPastry(sellPastry);
        return "redirect:/pastry/managePastry";
    }



}
