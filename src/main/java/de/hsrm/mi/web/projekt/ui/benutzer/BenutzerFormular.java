package de.hsrm.mi.web.projekt.ui.benutzer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.validators.GutesPasswort;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class BenutzerFormular {

    @NotBlank(message="{benutzer.name.ungesetzt}")
    @Size(min=3, max=80, message="{benutzer.name.zeichenlaenge}")
    private String name = "";
    @NotBlank
    @Email(message="{benutzer.email.falschesformat}")
    private String mail = "";
    @NotBlank
    @GutesPasswort
    private String password = "";
    @NotBlank
    @DateTimeFormat(iso=ISO.DATE)
    @Past(message = "{benutzer.geburtstag.zukunft}")
    private LocalDate birthday;
    private Set<String> magList = new HashSet<>();
    private Set<String> magNichtList = new HashSet<>();
    private String mag;
    private String magNicht;

    public void toBenutzer(Benutzer b) {
        b.setName(name);
        b.setMail(mail);
        b.setBirthday(birthday);
        b.setMagList(magList);
        b.setMagNichtList(magNichtList);
    }
    
    public void fromBenutzer(Benutzer b) {
        this.name = b.getName();
        this.mail = b.getMail();
        this.birthday = b.getBirthday();
        this.magList = b.getMagList();
        this.magNichtList = b.getMagNichtList();
    }

    public Set<String> getMagList() {
        return this.magList;
    }

    public Set<String> getMagNichtList() {
        return this.magNichtList;
    }

    public void setMagList(Set <String> _mag) {
        this.magList = _mag;
    }

    public void setMagNichtList(Set <String> magNicht) {
        this.magNichtList = magNicht;
    }

    public void addMag(String _mag) {
        this.magList.add(_mag);
    }

    public void addMagNicht(String _magNicht) {
        this.magNichtList.add(_magNicht);
    }

    public String getName() {
        return name;
    }

    public String getMag() {
        return this.mag;
    }

    public String getMagNicht() {
        return this.magNicht;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public void setMagNicht(String magNicht) {
        this.magNicht = magNicht;
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
