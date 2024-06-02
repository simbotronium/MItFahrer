package de.hsrm.mi.web.projekt.ui.tour;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Version;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.ort.Ort;
import de.hsrm.mi.web.projekt.entities.tour.Tour;
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
    private long startOrt;
    @OneToOne
    private long zielOrt;
    @ManyToOne
    private long anbieter;
    private List<Benutzer> benutzerliste;
    private List<Ort> ortliste;

    public void toTour(Tour t) {
        t.setAbfahrDateTime(abfahrDateTime);
        t.setInfo(info);
        t.setPreis(preis);
        t.setPlaetze(plaetze);
    }

    public void fromTour(Tour t) {
        this.abfahrDateTime = t.getAbfahrDateTime();
        this.info = t.getInfo();
        this.plaetze = t.getPlaetze();
        this.preis = t.getPreis();
    }

    public long getAnbieter() {
        return anbieter;
    }

    public void setAnbieter(long anbieter) {
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

    public long getStartOrt() {
        return startOrt;
    }

    public void setStartOrt(long startOrt) {
        this.startOrt = startOrt;
    }

    public long getZielOrt() {
        return zielOrt;
    }

    public void setZielOrt(long zielOrt) {
        this.zielOrt = zielOrt;
    }

    public List<Benutzer> getBenutzerliste() {
        return benutzerliste;
    }

    public void setBenutzerliste(List<Benutzer> bl) {
        this.benutzerliste = bl;
    }

    public List<Ort> getOrtliste() {
        return ortliste;
    }

    public void setOrtliste(List<Ort> ol) {
        this.ortliste = ol;
    }

}
