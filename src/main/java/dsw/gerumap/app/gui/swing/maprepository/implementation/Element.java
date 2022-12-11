package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.observer.Subscriber;

import java.awt.*;

public class Element extends MapNode {

    private Color color;
    private Stroke stroke;

    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addSubs(Subscriber subscriber) {

    }

    @Override
    public void removeSubs(Subscriber subscriber) {

    }

    @Override
    public void notify(Object notification) {

    }
}
