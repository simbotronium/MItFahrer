package de.hsrm.mi.web.projekt.messaging;

import org.springframework.stereotype.Service;


public interface FrontendNachrichtService {

    void sendEvent(FrontendNachrichtEvent ev);

}
