package giuseppe.leonardi.pasticceria;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class WebMainController {


    @RequestMapping(value = { "/"})
    public String index() {
        return "index";
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