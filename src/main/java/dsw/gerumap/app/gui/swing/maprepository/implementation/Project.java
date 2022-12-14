package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
public class Project extends MapNodeComposite {

    String author;

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    public Project(String name, MapNode parent, String author) {
        super(name, parent);
        this.author = author;
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().add(mindMap);
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().remove(mindMap);
        }
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
        if (notification == null || subscribers.isEmpty()) {
            return;
        }

        for (Subscriber subscriber:subscribers)
            subscriber.update(notification);
    }

    public void setAuthor(String author) throws IOException {
        this.author = author;
        notify(this);
    }
}
