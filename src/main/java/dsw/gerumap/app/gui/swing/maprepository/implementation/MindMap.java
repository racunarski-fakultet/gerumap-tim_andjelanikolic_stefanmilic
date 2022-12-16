package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.Subscriber;

import java.io.IOException;
import java.util.ArrayList;

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
    public void addChild(MapNode child) throws IOException {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
//            if (!this.getChildren().contains(element)) {
//                this.getChildren().add(element);
//            }
            this.getChildren().add(element);
            notify(this);
        }
    }

    @Override
    public void removeChild(MapNode child) throws IOException {
        if (child != null && child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
            notify(this);
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
