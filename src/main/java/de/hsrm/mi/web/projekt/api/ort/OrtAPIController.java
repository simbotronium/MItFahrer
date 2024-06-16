package de.hsrm.mi.web.projekt.api.ort;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.hsrm.mi.web.projekt.entities.ort.Ort;
import de.hsrm.mi.web.projekt.services.ort.OrtService;


@Controller
@RequestMapping("/api/ort")
public class OrtAPIController {

    private OrtService ortService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public OrtAPIController(OrtService os) {
        this.ortService = os;
    }
    
    @GetMapping
    public String getMethodName() {

        List<Ort> orte = this.ortService.holeAlleOrte();
        
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(orte);
        } catch(IOException e) {

        }

        return new String();
    }
    

}
