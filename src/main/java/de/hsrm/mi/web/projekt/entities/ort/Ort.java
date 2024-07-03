package de.hsrm.mi.web.projekt.entities.ort;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Version;

import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.services.geo.GeoAdresse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ort implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    @Version
    private long version;
    @NotBlank
    String name;
    double geobreite;
    double geolaenge;
    @OneToMany(mappedBy="startort", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<Tour> startTouren = new HashSet<>();
    @OneToMany(mappedBy="zielort", cascade=CascadeType.ALL, orphanRemoval = true)
    private Set<Tour> zielTouren = new HashSet<>();
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getGeobreite() {
        return geobreite;
    }
    public void setGeobreite(double geobreite) {
        this.geobreite = geobreite;
    }
    public double getGeolaenge() {
        return geolaenge;
    }
    public void setGeolaenge(double geolaenge) {
        this.geolaenge = geolaenge;
    }
    public long getId() {
        return this.id;
    }

    public Set<Tour> getStartTouren() {
        return this.startTouren;
    }

    public void setStartTouren(Set<Tour> t) {
        this.startTouren = t;
    }

    public Set<Tour> getZielTouren() {
        return this.zielTouren;
    }

    public void setZielTouren(Set<Tour> t) {
        this.zielTouren = t;
    }

    public Ort fromGeoAdresse(GeoAdresse geoAdresse) {
        this.geobreite = geoAdresse.lat();
        this.geolaenge = geoAdresse.lon();
        this.name = geoAdresse.name();
        return this;
    }
}
