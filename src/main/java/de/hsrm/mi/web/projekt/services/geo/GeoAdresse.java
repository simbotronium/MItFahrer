package de.hsrm.mi.web.projekt.services.geo;

public record GeoAdresse (String name, String addresstype, String display_name, double lat, double lon) {

    @Override
    public String toString() {
        return name  + " " + addresstype  + " " + display_name  + " " + Double.toString(lat)  + " " + Double.toString(lon) + "\n";
    }

}
