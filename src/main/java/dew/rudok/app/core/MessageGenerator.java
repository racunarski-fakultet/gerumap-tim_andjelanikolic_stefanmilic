package dew.rudok.app.core;

import dew.rudok.app.gui.swing.message.EventType;

public interface MessageGenerator {

    public void generateMessage(EventType messageType);
    public void addSubs(Subscriber subscriber);
    public void removeSubs(Subscriber subscriber);
    public void notify(Object notification);

}
