package de.hsrm.mi.web.projekt.ui.tour;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Version;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.ort.Ort;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TourFormular {
    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    private LocalDateTime abfahrDateTime;
    @Min(value = 0)
    private int preis;
    @Positive
    private int plaetze;
    @Size(min = 0, max = 400)
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
