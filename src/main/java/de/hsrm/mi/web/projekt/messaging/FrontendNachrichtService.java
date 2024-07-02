package de.hsrm.mi.web.projekt.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class FrontendNachrichtService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/topic/tour")
    @SendTo("/topic/tour")
    public FrontendNachrichtEvent sendEvent(FrontendNachrichtEvent ev) {
        logger.info("sende Nachricht: " + ev.toString());
        return ev;
    }
    
}
