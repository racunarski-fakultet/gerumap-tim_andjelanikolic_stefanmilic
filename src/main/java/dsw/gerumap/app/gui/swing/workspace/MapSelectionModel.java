package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.observer.Publisher;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MapSelectionModel implements Publisher {

    private List<Element> selected;
    protected List<Subscriber> subscribers;

    public MapSelectionModel() {
        selected = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addSubs(Subscriber subscriber) {
        if (subscriber == null || subscribers.contains(subscriber))
            return;
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubs(Subscriber subscriber) {
        if (subscriber == null || !subscribers.contains(subscriber))
            return;
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(Object notification) throws IOException {
        if ((notification == null) || subscribers.isEmpty()) {
            return;
        }

        for (Subscriber subscriber:subscribers)
            subscriber.update(notification);
    }
}
