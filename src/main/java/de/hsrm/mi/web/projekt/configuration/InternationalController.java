package de.hsrm.mi.web.projekt.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Locale; 
import java.text.NumberFormat;


@Controller
public class InternationalController {
    @GetMapping("/international")
    public String getInternational(Locale locale, Model m) {
        // m.addAttribute("sprache", locale.getDisplayLanguage());

        // var numformat = NumberFormat.getInstance(locale);
        // var zahl = numformat.format(1234567891);
        // m.addAttribute("zahl", zahl);
        
        // return "international/international";
        return "benutzerformular";
    }
        
}
