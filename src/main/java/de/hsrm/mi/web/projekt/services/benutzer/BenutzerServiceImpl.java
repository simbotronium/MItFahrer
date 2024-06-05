package de.hsrm.mi.web.projekt.services.benutzer;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hsrm.mi.web.projekt.entities.benutzer.Benutzer;
import de.hsrm.mi.web.projekt.entities.benutzer.BenutzerRepository;

@Service
public class BenutzerServiceImpl implements BenutzerService{
    Logger logger = LoggerFactory.getLogger(BenutzerServiceImpl.class);
    
    @Autowired
    private final BenutzerRepository benutzerRepository;
    
    public BenutzerServiceImpl(BenutzerRepository br) {
        this.benutzerRepository = br;
    }

    @Override
    public List<Benutzer> holeAlleBenutzer() {
        return this.benutzerRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Benutzer> holeBenutzerMitId(long id) {
        return this.benutzerRepository.findById(id);
    }

    @Override
    @Transactional
    public Benutzer speichereBenutzer(Benutzer b) {
        logger.info("Speichere Benutzer {}" ,b.getName());

        /* 
        if (this.benutzerRepository.findById(b.getId()).isPresent() && 
            (b.getPassword().isEmpty() || b.getPassword() == null)) {
            b.setPassword(this.benutzerRepository.findById(b.getId()).get().getPassword());
        }
        */
        
        return this.benutzerRepository.save(b);
    }

    @Override
    @Transactional
    public void loescheBenutzerMitId(long id) {
        logger.info("Lösche Benutzer mit ID {}", id);
        this.benutzerRepository.deleteById(id);
    }

    @Transactional
    public Benutzer aktualisiereBenutzerAttribut(Long id, String feldname, String wert) {
        Benutzer res = this.benutzerRepository.findById(id).get();
        if (feldname.equals("name")) {
            res.setName(wert);
        } else if (feldname.equals("mail")){
            res.setMail(wert);
        }
        return res;
    }

}
