package de.hsrm.mi.web.projekt.entities.benutzer;
import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class Benutzer implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    private String name;
    private String email;
    private String passwort;
    private LocalDate geburtstag;

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public LocalDate getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(LocalDate geburtstag) {
        this.geburtstag = geburtstag;
    }
}
