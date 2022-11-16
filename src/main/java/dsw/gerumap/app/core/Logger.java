package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.message.Message;
import dsw.gerumap.app.observer.Subscriber;

public interface Logger extends Subscriber {
    public void log(Message message);

    @Override
    default void update(Object object) {
        Message message = (Message)object;
        log(message);
    }
}
