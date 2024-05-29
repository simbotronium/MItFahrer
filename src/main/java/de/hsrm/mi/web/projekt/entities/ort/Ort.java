package de.hsrm.mi.web.projekt.entities.ort;

import java.io.Serializable;

import org.springframework.data.annotation.Version;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
