package de.hsrm.mi.web.projekt.ui.benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@Controller
@RequestMapping("/benutzer")
@SessionAttributes (names = {"formular", "benutzerID", "maxwunsch"})
public class BenutzerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final int maxwunsch = 5;

    @ModelAttribute("formular")
    public void initFormular(Model m) {
        m.addAttribute("formular", new BenutzerFormular());
        m.addAttribute("maxwunsch", Integer.toString(maxwunsch));
    }

    @GetMapping("/{zahl}")
    public String getMethodName(@PathVariable("zahl") Long zahl, Model m) {
        m.addAttribute("benutzerID", zahl);
        return "benutzerbearbeiten";
    }

    @PostMapping("/{zahl}")
    public String postMethodName(@SessionAttribute("formular") BenutzerFormular form,
     String name, String mail, String password, LocalDate birthday,
     Model m) {
        form.setName(name);
        form.setBirthday(birthday);
        form.setMail(mail);
        form.setPassword(password);
        return "benutzerbearbeiten";
    }
    
    
    
}
