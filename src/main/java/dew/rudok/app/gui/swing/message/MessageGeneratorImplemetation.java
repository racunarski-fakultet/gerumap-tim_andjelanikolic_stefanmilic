package dew.rudok.app.gui.swing.message;

import dew.rudok.app.core.MessageGenerator;
import dew.rudok.app.core.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
public class MessageGeneratorImplemetation implements MessageGenerator {

    private List<Subscriber> subscribers;
    private Message message;

    @Override
    public void generateMessage(MessageType messageType) {
        if (messageType.equals(MessageType.CANNOT_ADD_CHILD)) {
            this.notify();
        } else if (messageType.equals(MessageType.DELETE_PROJECT_EXPLORER)) {
            this.notify();
        } else if (messageType.equals(MessageType.NAME_CANNOT_BE_EMPTY)) {
            this.notify();
        }else if (messageType.equals(MessageType.NOTHING_IS_SELECTED)) {
            this.notify();
        }else {
            this.notify();
        }
    }

    @Override
    public void addSubs(Subscriber subscriber) {
        if (subscriber != null) {
            if (this.subscribers == null) {
                this.subscribers = new ArrayList();
            }

            if (!this.subscribers.contains(subscriber)) {
                this.subscribers.add(subscriber);
            }
        }
    }

    @Override
    public void removeSubs(Subscriber subscriber) {
        if (subscriber != null && this.subscribers != null && this.subscribers.contains(subscriber)) {
            this.subscribers.remove(subscriber);
        }
    }

    @Override
    public void notify(Object notification) {
        if (notification != null && this.subscribers != null && !this.subscribers.isEmpty()) {
            Iterator iterator = this.subscribers.iterator();

            while(iterator.hasNext()) {
                Subscriber subscriber = (Subscriber)iterator.next();
                subscriber.update(notification);
            }

        }
    }

}
