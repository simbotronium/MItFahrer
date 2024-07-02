package de.hsrm.mi.web.projekt.api.ort;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.hsrm.mi.web.projekt.entities.ort.Ort;
import de.hsrm.mi.web.projekt.services.ort.OrtService;



@RestController
@RequestMapping("/api/ort")
public class OrtAPIController {

    private OrtService ortService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public OrtAPIController(OrtService os) {
        this.ortService = os;
    }
    
    
    @GetMapping
    public String apiAlleOrte() {

        List<Ort> orte = this.ortService.holeAlleOrte();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(orte.stream().map(ort -> OrtDTO.fromOrt(ort)).collect(Collectors.toList()));
        } catch(IOException e) {
            logger.error("etwas ging beim Serialisieren der Ortliste schief", e);
        }

        return new String();
    }

    @GetMapping("/{id}")
    public Record apiOrtFromID(@PathVariable("id") Long id) {
        Optional<Ort> optOrt = this.ortService.holeOrtMitId(id);
        if (optOrt.isPresent()) {
            return OrtDTO.fromOrt(optOrt.get());
        }
        logger.info("Kein Ort für id " + id + " gefunden");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    
    

}
