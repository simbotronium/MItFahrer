package de.hsrm.mi.web.projekt.services.ort;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hsrm.mi.web.projekt.entities.ort.Ort;
import de.hsrm.mi.web.projekt.entities.ort.OrtRepository;
import de.hsrm.mi.web.projekt.services.benutzer.BenutzerServiceImpl;

@Service
public class OrtServiceImpl implements OrtService {

    Logger logger = LoggerFactory.getLogger(BenutzerServiceImpl.class);
    
    @Autowired
    private final OrtRepository ortRepository;

    public OrtServiceImpl(OrtRepository or) {
        this.ortRepository = or;
    }

    @Override
    public List<Ort> holeAlleOrte() {
        return this.ortRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ort> holeOrtMitId(long id) {
        return this.ortRepository.findById(id);
    }

    @Override
    @Transactional
    public Ort speichereOrt(Ort o) {
        logger.info("Speichere Ort {}" ,o.getName());
        
        return this.ortRepository.save(o);
    }

    @Override
    @Transactional
    public void loescheOrtMitId(long id) {
        logger.info("Lösche Ort mit ID {}", id);
        this.ortRepository.deleteById(id);
    }


    
    
}
