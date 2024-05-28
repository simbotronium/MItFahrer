package de.hsrm.mi.web.projekt.entities.tour;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.ort.Ort;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
@Entity
public class Tour implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    private LocalDateTime abfahrDateTime;
    @Positive
    private int preis;
    @Min(value=1)
    private int plaetze;
    private String info;
    @OneToOne
    private Ort startOrt;
    @OneToOne
    private Ort zielOrt;
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
    public Ort getStartOrt() {
        return startOrt;
    }
    public void setStartOrt(Ort startOrt) {
        this.startOrt = startOrt;
    }
    public Ort getZielOrt() {
        return zielOrt;
    }
    public void setZielOrt(Ort zielOrt) {
        this.zielOrt = zielOrt;
    }
}
