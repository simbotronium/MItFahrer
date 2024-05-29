package de.hsrm.mi.web.projekt.ui.ort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hsrm.mi.web.projekt.entities.ort.Ort;
import de.hsrm.mi.web.projekt.services.ort.OrtService;
import jakarta.validation.Valid;

import java.util.Optional;


@Controller
@RequestMapping("/ort")
@SessionAttributes(names = {"ortID", "ortformular", "ort"})
public class OrtController {

    private Ort ort;
    private OrtFormular ortFormular = new OrtFormular();
    private OrtService ortService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public OrtController(OrtService os) {
        this.ortService = os;
    }

    public void initFormular(Model m) {
        m.addAttribute("ortformular", m);
    }

    @GetMapping("/{id}")
    public String getMethodName(@PathVariable("id") Long id, Model m) {
        Optional<Ort> optOrt = this.ortService.holeOrtMitId(id);

        m.addAttribute("ortID", id);
        logger.info("ortID = {}", id);        

        if (id == 0 || optOrt.isEmpty()) {
            logger.info("Neuer Ort");
            ortFormular = new OrtFormular();
            ort = new Ort();
            if(optOrt.isEmpty() && id > 0) {
                logger.info("Id nicht gefunden");
            }
        } else {
            ort = optOrt.get();
            ortFormular.fromOrt(ort);
        }
        m.addAttribute("ort", ort);
        m.addAttribute("ortformular", ortFormular);

        return "ort/ortbearbeiten";
    }

    @GetMapping("/{id}/del")
    public String deletePlace(Model m, @PathVariable("id") Long id) {
        this.ortService.loescheOrtMitId(id);

        return "redirect:/ort";
    }
    

    @GetMapping
    public String getMethodName(Model m) {
        m.addAttribute("ortsliste", this.ortService.holeAlleOrte());
        return "ort/ortliste";
    }
    

    @PostMapping("/{id}")
    public String postMethodName(@Valid @ModelAttribute("ortformular") OrtFormular form, BindingResult result,
            Model m, @ModelAttribute("ort") Ort ort, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "ort/ortbearbeiten";
        }

        form.toOrt(ort);
        try {
            m.addAttribute("ort", ortService.speichereOrt(ort));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            m.addAttribute("info", e.getMessage());
        }
        if (id == 0) {
            return "redirect:/ort/" + ort.getId();
        }
        return "ort/ortbearbeiten";
    }

}

