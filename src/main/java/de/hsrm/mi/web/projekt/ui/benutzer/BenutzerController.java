package de.hsrm.mi.web.projekt.ui.benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.services.benutzer.BenutzerService;
import de.hsrm.mi.web.projekt.services.geo.GeoService;
import de.hsrm.mi.web.projekt.services.geo.GeoServiceImpl;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/benutzer")
@SessionAttributes(names = { "formular", "benutzerID", "maxwunsch", "benutzer" })

public class BenutzerController {
    Benutzer benutzer;
    BenutzerFormular benutzerFormular = new BenutzerFormular();
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

    @GetMapping("/{id}")
    public String getMethodName(@PathVariable("id") Long id, Model m) {
        Optional<Benutzer> optBenutzer = this.benutzerService.holeBenutzerMitId(id);

        m.addAttribute("benutzerID", id);
        logger.info("benutzerID = {}", id);        

        if (id == 0 || optBenutzer.isEmpty()) {
            logger.info("Neuer Benutzer");
            benutzerFormular = new BenutzerFormular();
            benutzer = new Benutzer();
            if(optBenutzer.isEmpty() && id > 0) {
                logger.info("Id nicht gefunden");
            }
        } else {
            benutzer = optBenutzer.get();
            benutzerFormular.fromBenutzer(benutzer);
        }
        m.addAttribute("benutzer", benutzer);
        m.addAttribute("formular", benutzerFormular);

        return "benutzer/benutzerbearbeiten";
    }

    @GetMapping("/{id}/del")
    public String deleteUser(Model m, @PathVariable("id") Long id) {
        this.benutzerService.loescheBenutzerMitId(id);

        return "redirect:/benutzer";
    }
    
    @GetMapping("/{id}/hx/feld/{feldname}")
    public String feldausgebenHX(@RequestParam String param) {
        //TODO: process GET request
        System.out.println("GET GET GET GET GET GET GET GET");
        return "benutzer/benutzerliste";
    }
    
    @PutMapping("/{id}/hx/feld/{feldname}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {
        //TODO: process PUT request
        System.out.println("PUT PUT PUT PUT PUT PUT PUT PUT");
        return entity;
    }


    @GetMapping
    public String getMethodName(Model m) {
        GeoService geoService = new GeoServiceImpl();
        geoService.findeAdressen("karlsruhe");
        m.addAttribute("benutzerliste", this.benutzerService.holeAlleBenutzer());
        return "benutzer/benutzerliste";
    }
    

    @PostMapping("/{id}")
    public String postMethodName(@Valid @ModelAttribute("formular") BenutzerFormular form, BindingResult result,
            Model m, @ModelAttribute("benutzer") Benutzer benutzer, @PathVariable("id") Long id) {
        if (form.getMag() != null && !form.getMag().equals(""))
            form.getMagList().add(form.getMag());
        if (form.getMagNicht() != null && !form.getMagNicht().equals(""))
            form.getMagNichtList().add(form.getMagNicht());
        if (form.getPassword().isEmpty() || form.getPassword() == null) {
            result.rejectValue("password", "benutzer.passwort.ungesetzt", "Passwort wurde noch nicht gesetzt");
        }
        if (result.hasErrors()) {
            return "benutzer/benutzerbearbeiten";
        }

        form.toBenutzer(benutzer);
        try {
            m.addAttribute("benutzer", benutzerService.speichereBenutzer(benutzer));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            m.addAttribute("info", e.getMessage());
        }
        if (id == 0) {
            return "redirect:/benutzer/" + benutzer.getId();
        }
        return "benutzer/benutzerbearbeiten";
    }

}
