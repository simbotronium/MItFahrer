package de.hsrm.mi.web.projekt.ui.benutzer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/benutzer")
public class BenutzerController {

    @GetMapping("/{zahl}")
    public String getMethodName(@PathParam("zahl") int zahl, Model m) {
        m.addAttribute("benutzerID", zahl);
        return "benutzerbearbeiten";
    }
    
}
