package dew.rudok.app.core;

import dew.rudok.app.gui.swing.message.Message;

public interface Logger extends Subscriber{
    public void log(Message message);

    @Override
    default void update(Object object) {
        Message message = (Message)object;
        log(message);
    }
}
