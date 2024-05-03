package de.hsrm.mi.web.projekt.ui.benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/benutzer")
@SessionAttributes (names = {"formular", "benutzerID"})
public class BenutzerController {

    @ModelAttribute
    public void initFormular(Model m) {
        m.addAttribute("formular", new BenutzerFormular());
    }

    @GetMapping("/{zahl}")
    public String getMethodName(@PathVariable("zahl") Long zahl, Model m) {
        m.addAttribute("benutzerID", zahl);
        return "benutzerbearbeiten";
    }

    @PostMapping("/{zahl}")
    public String postMethodName(@ModelAttribute("formular") BenutzerFormular form, Model m) {
        return "benutzerbearbeiten";
    }
    
    
    
}
