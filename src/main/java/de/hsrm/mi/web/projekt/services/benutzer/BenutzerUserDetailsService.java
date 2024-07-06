package de.hsrm.mi.web.projekt.services.benutzer;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.benutzer.BenutzerRepository;

@Service
public class BenutzerUserDetailsService implements UserDetailsService {

    private BenutzerRepository benutzerRepository;

    public BenutzerUserDetailsService(BenutzerRepository br) {
        this.benutzerRepository = br;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Benutzer benutzer = this.benutzerRepository.findByMail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(benutzer.getPassword())
                .roles(this.getRole(benutzer.getMagList()))
                .build();
    }
    
    private String getRole(Set<String> mag) {
        for (String m: mag) {
            if (m.equals("MACHT")) {
                return "CHEF";
            }
        }
        return "USER";
    }

}
