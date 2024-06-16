package de.hsrm.mi.web.projekt.api.ort;

import de.hsrm.mi.web.projekt.entities.ort.Ort;

public record OrtDTO(long id, String name, double geoBreite, double geoLaenge) {
    
    public static OrtDTO fromOrt(Ort o) {
        return new OrtDTO(o.getId(), o.getName(), o.getGeobreite(), o.getGeolaenge());
    }

    public static Ort toOrt(OrtDTO dto) {

        Ort curOrt = new Ort();
        curOrt.setName(dto.name());
        curOrt.setGeobreite(dto.geoBreite());
        curOrt.setGeolaenge(dto.geoLaenge());

        return curOrt;
    }

}
