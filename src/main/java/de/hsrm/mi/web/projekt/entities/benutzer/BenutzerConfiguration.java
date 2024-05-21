package de.hsrm.mi.web.projekt.entities.benutzer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BenutzerConfiguration {
    @Bean public Benutzer benutzer() {
        Benutzer b = new Benutzer();
        return b;
    }
}
