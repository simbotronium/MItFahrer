package de.hsrm.mi.web.projekt.ui.benutzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class BenutzerFormular {

    private String name = "";
    private String mail = "";
    private String password = "";
    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate birthday;
    private Set<String> mag = new HashSet<>(Arrays.asList("a", "b", "c", "d", "e"));
    private Set<String> magNicht = new HashSet<>(Arrays.asList("f", "g"));

    public Set<String> getMag() {
        return mag;
    }

    public Set<String> getMagNicht() {
        return magNicht;
    }

    public void setMag(Set<String> mag) {
        this.mag = mag;
    }

    public void setMagNicht(Set<String> magNicht) {
        this.magNicht = magNicht;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
