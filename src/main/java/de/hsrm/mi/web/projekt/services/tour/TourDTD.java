package de.hsrm.mi.web.projekt.services.tour;

import java.time.LocalDateTime;

import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.services.geo.GeoDistanz;

public record TourDTD(
    long id,
    LocalDateTime abfahrDateTime,
    int preis,
    int plaetze,
    int buchungen,
    String startOrtName,
    long startOrtId,
    String zielOrtName,
    long zielOrtId,
    String anbieterName,
    long anbieterId,
    double distanz,
    String info
) {

    public static TourDTD fromTour(Tour t) {
        return new TourDTD(
            t.getId(),
            t.getAbfahrDateTime(),
            t.getPreis(),
            t.getPlaetze(),
            t.getMitfahrgaeste().size(),
            t.getStartort().getName(),
            t.getStartort().getId(),
            t.getZielort().getName(),
            t.getZielort().getId(),
            t.getAnbieter().getName(),
            t.getAnbieter().getId(),
            GeoDistanz.calculateDistance(t.getStartort().getGeobreite(), t.getStartort().getGeolaenge(), t.getZielort().getGeobreite(), t.getZielort().getGeolaenge()),
            t.getInfo()
        );
    }
}
