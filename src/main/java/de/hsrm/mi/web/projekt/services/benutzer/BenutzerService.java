package de.hsrm.mi.web.projekt.services.benutzer;
import java.util.List;
import java.util.Optional;


import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;

public interface BenutzerService {
    List<Benutzer> holeAlleBenutzer();

    Optional<Benutzer> holeBenutzerMitId(long id);

    Benutzer speichereBenutzer(Benutzer b);

    boolean loescheBenutzerMitId(long id);

    Benutzer aktualisiereBenutzerAttribut(Long id, String feldname, String wert);
}
