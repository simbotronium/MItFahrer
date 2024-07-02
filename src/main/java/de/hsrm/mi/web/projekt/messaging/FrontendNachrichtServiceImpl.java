package de.hsrm.mi.web.projekt.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class FrontendNachrichtServiceImpl implements FrontendNachrichtService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SimpMessagingTemplate messaging;

    @Override
    public void sendEvent(FrontendNachrichtEvent ev) {
        logger.info("sende Nachricht: " + ev.toString());
        messaging.convertAndSend("/topic/tour", ev);
    }
    
}
