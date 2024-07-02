package de.hsrm.mi.web.projekt.messaging;

public class FrontendNachrichtEvent {

    private EventTyp eventTyp;
    private long id;
    private Operation operation;

    public FrontendNachrichtEvent(EventTyp et, Operation op, long id) {
        this.eventTyp = et;
        this.operation = op;
        this.id = id;
    }

    public EventTyp getEventTyp() {
        return this.eventTyp;
    }

    public long getId() {
        return this.id;
    }

    public Operation getOperation() {
        return this.operation;
    }

    public void setEventTyp(EventTyp et) {
        this.eventTyp = et;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOperation(Operation op) {
        this.operation = op;
    }

    @Override
    public String toString() {
        return "FrontendNachrichtEvent: [" + this.eventTyp.toString() + ", " + this.id + ", " + this.operation.toString() + "]";
    }
    
}
