package de.hsrm.mi.web.projekt.ui.benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.services.benutzer.BenutzerService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Controller
@RequestMapping("/benutzer")
@SessionAttributes (names = {"formular", "benutzerID", "maxwunsch", "benutzer"})

public class BenutzerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final int maxwunsch = 5;
    private final BenutzerService benutzerService;

    public BenutzerController(BenutzerService bs) {
        this.benutzerService = bs;
    }

    @ModelAttribute("formular")
    public void initFormular(Model m) {
        m.addAttribute("formular", new BenutzerFormular());
        m.addAttribute("maxwunsch", Integer.toString(maxwunsch));

        logger.info("maxwunsch = {}", maxwunsch);
    }

    @GetMapping("/{zahl}")
    public String getMethodName(@PathVariable("zahl") Long zahl, Model m) {
        m.addAttribute("benutzerID", zahl);
        logger.info("benutzerID = {}", zahl);

        Optional<Benutzer> optBenutzer = this.benutzerService.holeBenutzerMitId(zahl);
        Benutzer benutzer = new Benutzer();
        BenutzerFormular benutzerFormular = new BenutzerFormular();
        if (zahl == 0 || optBenutzer.isEmpty()) {
            logger.info("BenutzerId nicht gefunden!");

        } else {
            benutzer = optBenutzer.get();
            benutzerFormular.fromBenutzer(benutzer);
        }
        m.addAttribute("benutzer", benutzer);
        m.addAttribute("formular", benutzerFormular);

        return "benutzerbearbeiten";
    }

    @PostMapping("/{zahl}")
    public String postMethodName(@Valid @ModelAttribute("formular") BenutzerFormular form, BindingResult result,
     Model m, @ModelAttribute("benutzer") Benutzer benutzer) {
        if (form.getMag() != null && !form.getMag().equals("")) form.getMagList().add(form.getMag());
        if (form.getMagNicht() != null && !form.getMagNicht().equals("")) form.getMagNichtList().add(form.getMagNicht());
        if (form.getPassword().isEmpty() || form.getPassword() == null) {
            result.rejectValue("password", "benutzer.passwort.ungesetzt", "Passwort wurde noch nicht gesetzt");
        }
        if(result.hasErrors()) {
            return "benutzerbearbeiten";
        }

        form.toBenutzer(benutzer);
        m.addAttribute("benutzer", benutzerService.speichereBenutzer(benutzer));
        return "benutzerbearbeiten";
    }
    
}
