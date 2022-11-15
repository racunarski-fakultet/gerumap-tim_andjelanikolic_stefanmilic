package dew.rudok.app.core;

import dew.rudok.app.gui.swing.message.MessageType;

public interface MessageGenerator {

    public void generateMessage(MessageType messageType);
    public void addSubs(Subscriber subscriber);
    public void removeSubs(Subscriber subscriber);
    public void notify(Object notification);

}
