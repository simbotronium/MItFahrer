package de.hsrm.mi.web.projekt.services.tour;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hsrm.mi.web.projekt.entities.benutzer.BenutzerRepository;
import de.hsrm.mi.web.projekt.entities.ort.OrtRepository;
import de.hsrm.mi.web.projekt.entities.tour.Tour;
import de.hsrm.mi.web.projekt.entities.tour.TourRepository;
import de.hsrm.mi.web.projekt.services.benutzer.BenutzerServiceImpl;

@Service
public class TourServiceImpl implements TourService {

    Logger logger = LoggerFactory.getLogger(BenutzerServiceImpl.class);
    
    @Autowired
    private final TourRepository tourRepository;
    @Autowired
    private final BenutzerRepository benutzerRepository;
    @Autowired 
    private final OrtRepository ortRepository;


    public TourServiceImpl(TourRepository tr, BenutzerRepository br, OrtRepository or) {
        this.tourRepository = tr;
        this.benutzerRepository = br;
        this.ortRepository = or;
    }

    
    @Transactional
    public Tour speichereTourAngebot(long anbieterid, Tour tour, long startortid, long zielortid) {
        tour.setAnbieter(benutzerRepository.findById(anbieterid).get());
        tour.setStartort(ortRepository.findById(startortid).get());
        tour.setZielort(ortRepository.findById(zielortid).get());
        return tour;
    }
    

    @Override
    public List<Tour> holeAlleTouren() {
        return this.tourRepository.findAll(Sort.by(Sort.Direction.ASC, "abfahrDateTime"));
    }

    @Override
    @Transactional
    public Optional<Tour> holeTourMitId(long id) {
        return this.tourRepository.findById(id);
    }

    @Override
    @Transactional
    public Tour speichereTour(Tour t) {
        logger.info("Speichere Tour {}" ,t.getAbfahrDateTime());
        
        return this.tourRepository.save(t);
    }

    @Override
    @Transactional
    public void loescheTourMitId(long id) {
        logger.info("Lösche Tour mit ID {}", id);
        this.tourRepository.deleteById(id);
    }

    
    
}
