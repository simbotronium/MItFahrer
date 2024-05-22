package de.hsrm.mi.web.projekt.services.benutzer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.benutzer.BenutzerRepository;

@Service
public class BenutzerServiceImpl implements BenutzerService{
    Logger logger = LoggerFactory.getLogger(BenutzerServiceImpl.class);
    
    private final BenutzerRepository benutzerRepository;
    
    public BenutzerServiceImpl(BenutzerRepository br) {
        this.benutzerRepository = br;
    }

    @Override
    public List<Benutzer> holeAlleBenutzer() {
        return this.benutzerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public Optional<Benutzer> holeBenutzerMitId(long id) {
        Optional<Benutzer> oBenutzerMitId = this.benutzerRepository.findById(id);
        if(oBenutzerMitId.isEmpty()) {
            logger.debug("id nicht gefunden");
            return Optional.empty();
        }
        return oBenutzerMitId;
    }

    @Override
    public Benutzer speichereBenutzer(Benutzer b) {
        //Wo ist der Unterschied zum hereingereichten b?????????heeeelp meeee
        return this.benutzerRepository.save(b);
    }

    @Override
    public void loescheBenutzerMitId(long id) {
        this.benutzerRepository.deleteById(id);
    }

}
