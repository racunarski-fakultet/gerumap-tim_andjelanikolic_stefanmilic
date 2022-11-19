package dsw.gerumap.app.gui.swing.message;

import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MessageGeneratorImplemetation implements MessageGenerator {
    private List<Subscriber> subscribers;
    private Message message;

    public MessageGeneratorImplemetation(){
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void generateMessage(EventType type) throws IOException {
        notify(createMessage(type));
    }

    private Message createMessage(EventType type) {
        switch (type) {

            case CANNOT_DELETE_PROJECT_EXPLORER:
                return new Message("Cannot delete My Project Explorer", EventType.ERROR);
            case CANNOT_ADD_CHILD_TO_LEAF:
                return new Message("Cannot add child to leaf node.", EventType.ERROR);
            case NODE_NOT_SELECTED:
                return new Message("Node not selected.", EventType.ERROR);
            case AUTHOR_PROJECT_NOT_SELECTED:
                return new Message("You can only set the author for Projects.", EventType.ERROR);
            case MUST_INSERT_NAME:
                return new Message("Must insert name", EventType.ERROR);
            case CANNOT_DELETE_FILE:
                return new Message("Cannot delete this file", EventType.ERROR);
            case RESOURCE_NOT_FOUND:
                return new Message("Resource not found", EventType.ERROR);
            case NODE_ALREADY_EXISTS:
                return new Message("There is already a node with this name.", EventType.ERROR);
            default:
                return null;
        }
    }

    @Override
    public void addSubs(Subscriber sub) {
        if (sub == null || subscribers.contains(sub))
            return;
        subscribers.add(sub);
    }

    @Override
    public void removeSubs(Subscriber sub) {
        if (sub == null || !subscribers.contains(sub))
            return;
        subscribers.remove(sub);
    }

    @Override
    public void notify(Object state) throws IOException {
        if (state == null || subscribers.isEmpty()) {
            System.out.println(subscribers.size());
            return;
        }

        for (Subscriber subscriber:subscribers)
            subscriber.update(state);
    }
}

