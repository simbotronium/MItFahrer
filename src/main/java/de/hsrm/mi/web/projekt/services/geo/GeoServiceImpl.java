package de.hsrm.mi.web.projekt.services.geo;

import java.util.*;
import java.util.stream.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service

public class GeoServiceImpl implements GeoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<GeoAdresse> findeAdressen(String ort) {
        if (ort == null) {
            logger.error("ein Ort 'null' kann nicht gefunden werden");
            return new ArrayList<GeoAdresse>();
        }

        WebClient webClient = WebClient.create("https://nominatim.openstreetmap.org");
        return webClient.get().uri("/search?q={ort}&format=json&countrycodes=de", ort)
                .retrieve()
                .bodyToFlux(GeoAdresse.class)
                .collectList()
                .block()
                .stream()
                .filter(adresse -> adresse.addresstype().equals("city")
                                    || adresse.addresstype().equals("town")
                                    || adresse.addresstype().equals("village"))
                .collect(Collectors.toList());
    }
    
}
