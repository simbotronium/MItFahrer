package de.hsrm.mi.web.projekt.entities.benutzer;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.validators.GutesPasswort;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Benutzer implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @NotBlank(message="{benutzer.name.ungesetzt}")
    @Size(min=3, max=80, message="{benutzer.name.zeichenlaenge}")
    private String name = "";
    @NotBlank
    @Email(message="{benutzer.email.falschesformat}")
    private String mail = "";
    @NotBlank
    @GutesPasswort
    private String password = "";
    @NotNull
    @DateTimeFormat(iso=ISO.DATE)
    @Past(message = "{benutzer.geburtstag.zukunft}")
    private LocalDate birthday;
    @ElementCollection
    private Set<String> magList = new HashSet<>();
    @ElementCollection
    private Set<String> magNichtList = new HashSet<>();
    private String mag;
    private String magNicht;
    @OneToMany(mappedBy = "anbieter", cascade = CascadeType.REMOVE)
    private Set<Tour> angeboteneTouren = new HashSet<>();
    @OneToMany(mappedBy = "anbieter")
    private Set<Tour> gebuchteTouren = new HashSet<>();

    public void add(Tour neueTour) {
        this.angeboteneTouren.add(neueTour);
        neueTour.setAnbieter(this);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Tour> getGebuchteTouren() {
        return this.angeboteneTouren;
    }    

}
