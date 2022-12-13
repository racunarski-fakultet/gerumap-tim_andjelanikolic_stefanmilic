package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.Subscriber;

import java.io.IOException;

public class MindMap extends MapNodeComposite {

    private boolean template;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }
    public MindMap(String name, MapNode parent, boolean template) {
        super(name, parent);
        this.template = template;
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
            }
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
        }
    }

    @Override
    public void addSubs(Subscriber subscriber) {
        if (subscriber == null || subscribers.contains(subscriber))
            return;
        subscribers.add(subscriber);
        System.out.println(subscriber.toString());
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

    @Override
    public String toString() {
        return getName();
    }
}
