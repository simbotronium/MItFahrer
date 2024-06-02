package de.hsrm.mi.web.projekt.entities.tour;

import java.io.Serializable;
import java.time.LocalDateTime;


import org.springframework.data.annotation.Version;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.ort.Ort;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
@Entity
public class Tour implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    private LocalDateTime abfahrDateTime;
    @Min(value=0)
    private int preis;
    @Positive
    private int plaetze;
    @Size(min=0, max=400)
    private String info;
    @ManyToOne
    private Ort startort;
    @ManyToOne
    private Ort zielort;
    @ManyToOne
    private Benutzer anbieter;

    public Benutzer getAnbieter() {
        return anbieter;
    }
    public void setAnbieter(Benutzer anbieter) {
        this.anbieter = anbieter;
    }
    public LocalDateTime getAbfahrDateTime() {
        return abfahrDateTime;
    }
    public void setAbfahrDateTime(LocalDateTime abfahrDateTime) {
        this.abfahrDateTime = abfahrDateTime;
    }
    public int getPreis() {
        return preis;
    }
    public void setPreis(int preis) {
        this.preis = preis;
    }
    public int getPlaetze() {
        return plaetze;
    }
    public void setPlaetze(int plaetze) {
        this.plaetze = plaetze;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Ort getStartort() {
        return startort;
    }
    public void setStartort(Ort startOrt) {
        this.startort = startOrt;
    }
    public Ort getZielort() {
        return zielort;
    }
    public void setZielort(Ort zielOrt) {
        this.zielort = zielOrt;
    }
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tour von " + anbieter.getName();
    }
}
