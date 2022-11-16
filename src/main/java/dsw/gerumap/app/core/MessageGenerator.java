package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.message.EventType;
import dsw.gerumap.app.observer.Publisher;
import dsw.gerumap.app.observer.Subscriber;

public interface MessageGenerator extends Publisher {

    public void generateMessage(EventType messageType);

}
