package de.hsrm.mi.web.projekt.api.tour;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.services.tour.TourService;


@RestController
@RequestMapping("/api/tour")
public class TourAPIController {
    
    private TourService tourService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TourAPIController(TourService ts) {
        this.tourService = ts;
    }

    @GetMapping
    public String apiAlleTouren() {
        
        List<Tour> touren = this.tourService.holeAlleTouren();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            return objectMapper.writeValueAsString(
                touren.stream().map(tour -> TourDTD.fromTour(tour)).collect(Collectors.toList())
            );
        } catch (IOException e) {
            logger.error("etwas ging beim Serialisieren der Tourliste schief", e);
        }
        return new String();
    }

}
