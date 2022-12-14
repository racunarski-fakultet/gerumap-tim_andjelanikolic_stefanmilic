package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.io.IOException;

@NoArgsConstructor
@Getter
public class Element extends MapNode {
    private Color color = Color.black;
    private int stroke = 2;

//    public Element(Color color, int stroke) {
//        this.color = color;
//        this.stroke = stroke;
//    }

    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element(String name, MapNode parent, Color color, int stroke) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
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

    public void setColor(Color color) throws IOException {
        this.color = color;
        notify(this);
    }

    public void setStroke(int stroke) throws IOException {
        this.stroke = stroke;
    }
}
