package giuseppe.leonardi.pasticceria;

import giuseppe.leonardi.pasticceria.webapp.models.dao.Pastry;
import giuseppe.leonardi.pasticceria.webapp.models.gui.TableRow;
import giuseppe.leonardi.pasticceria.webapp.service.PastryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class WebMainController {
    @Autowired
    private PastryService pastryService;

    @RequestMapping(value = { "/"})
    public String index(Model model) {
        List<TableRow> rows = pastryService.getAllSellPastries().stream().map(sellPastry -> {
            Double price = pastryService.getPrice(sellPastry);
            return new TableRow(sellPastry.getPastry().getName(), sellPastry.getQuantity(), price, sellPastry.getPastry().getId());
        }).collect(Collectors.toList());
        model.addAttribute("rows", rows);
        return "index";
    }

    @GetMapping("/viewPastry")
    public String getViewPastryModal(Model model, @RequestParam Optional<Long> pastryId){
        model.addAttribute("isNew", !pastryId.isPresent());
        model.addAttribute("editMode", false);
        Pastry pastry = pastryId.isPresent() ?  pastryService.getPastry(pastryId.get()) : new Pastry();
        model.addAttribute("pastry", pastry);
        return "pastryModal";
    }

    @RequestMapping(value = { "/login" })
    public String login(@RequestParam Optional<Boolean> error,@RequestParam Optional<Boolean> logout, Model model) {
        Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            model.addAttribute("error", error.isPresent() && error.get());
            model.addAttribute("logout", logout.isPresent() && logout.get());
            return "login";
        }else{
            return "redirect:/";
        }
    }


}