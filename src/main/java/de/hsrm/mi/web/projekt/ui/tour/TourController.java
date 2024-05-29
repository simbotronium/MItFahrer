package de.hsrm.mi.web.projekt.ui.tour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.services.tour.TourService;

@Controller
@RequestMapping
@SessionAttributes(names={"tourID", "tourformular", "tour"})
public class TourController {
    private Tour tour;
    private TourFormular tourFormular;
    private TourService tourService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TourController(TourService ts) {
        this.tourService = ts;
    }

    public void initFormular(Model m) {
        m.addAttribute("tourformula", m);
    }
}
