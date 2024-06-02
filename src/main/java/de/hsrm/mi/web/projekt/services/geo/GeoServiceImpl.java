package de.hsrm.mi.web.projekt.services.geo;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeoServiceImpl implements GeoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<GeoAdresse> findeAdressen(String ort) {
        if (ort == null) {
            logger.error("ein Ort 'null' kann nicht gefunden werden");
            return new ArrayList<GeoAdresse>();
        }

        
        return null;
    }
    
}
