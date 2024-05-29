package de.hsrm.mi.web.projekt.ui.ort;

import org.springframework.data.annotation.Version;

import de.hsrm.mi.web.projekt.entities.ort.Ort;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class OrtFormular {
    @Version
    private long version;
    @NotBlank
    String name;
    double geobreite;
    double geolaenge;


    public void toOrt(Ort o) {
        o.setGeobreite(geobreite);
        o.setGeolaenge(geolaenge);
        o.setName(name);
    }
    
    public void fromOrt(Ort o) {
        this.geobreite = o.getGeobreite();
        this.geolaenge = o.getGeolaenge();
        this.name = o.getName();
    }

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
