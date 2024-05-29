package de.hsrm.mi.web.projekt.ui.tour;

import java.util.Optional;

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

import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.services.benutzer.BenutzerService;
import de.hsrm.mi.web.projekt.services.ort.OrtService;
import de.hsrm.mi.web.projekt.services.tour.TourService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("tour")
@SessionAttributes(names={"tourID", "tourformular", "tour"})
public class TourController {
    private Tour tour;
    private TourFormular tourFormular = new TourFormular();
    private TourService tourService;
    private BenutzerService benutzerService;
    private OrtService ortService; 
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TourController(TourService ts, BenutzerService bs, OrtService os) {
        this.tourService = ts;
        this.benutzerService = bs;
        this.ortService = os;
    }

    public void initFormular(Model m) {
        m.addAttribute("tourformular", m);
    }

    @GetMapping("/{id}")
    public String getMethodName(@PathVariable("id") Long id, Model m) {
        Optional<Tour> optTour = this.tourService.holeTourMitId(id);

        m.addAttribute("tourID", id);
        logger.info("tourID = {}", id);        

        if (id == 0 || optTour.isEmpty()) {
            logger.info("Neue Tour");
            tourFormular = new TourFormular();
            tour = new Tour();
            if (optTour.isEmpty() && id > 0) {
                logger.info("Id nicht gefunden");
            }
        } else {
            tour = optTour.get();
            tourFormular.fromTour(tour);
        }
        m.addAttribute("tour", tour);
        m.addAttribute("tourformular", tourFormular);

        return "tour/tourbearbeiten";
    }

    @GetMapping("/{id}/del")
    public String deletePlace(Model m, @PathVariable("id") Long id) {
        this.tourService.loescheTourMitId(id);

        return "redirect:/tour";
    }
    

    @GetMapping
    public String getMethodName(Model m) {
        m.addAttribute("tourliste", this.tourService.holeAlleTouren());
        return "tour/tourliste";
    }
    

    @PostMapping("/{id}")
    public String postMethodName(@Valid @ModelAttribute("tourformular") TourFormular form, BindingResult result,
            Model m, @ModelAttribute("tour") Tour tour, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "tour/tourbearbeiten";
        }

        form.toTour(tour);
        form.setBenutzerliste(this.benutzerService.holeAlleBenutzer());
        form.setOrtliste(this.ortService.holeAlleOrte());
        try {
            m.addAttribute("tour", tourService.speichereTour(tour));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            m.addAttribute("info", e.getMessage());
        }
        if (id == 0) {
            return "redirect:/tour/" + tour.getId();
        }
        return "tour/tourbearbeiten";
    }

}
