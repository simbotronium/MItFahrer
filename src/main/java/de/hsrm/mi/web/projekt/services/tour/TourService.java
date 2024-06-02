package de.hsrm.mi.web.projekt.services.tour;

import java.util.List;
import java.util.Optional;

import de.hsrm.mi.web.projekt.entities.tour.Tour;

public interface TourService {

    List<Tour> holeAlleTouren();

    Optional<Tour> holeTourMitId(long id);

    Tour speichereTour(Tour o);

    void loescheTourMitId(long id);

    Tour speichereTourAngebot(long anbieterid, Tour tour, long startortid, long zielortid);

}
