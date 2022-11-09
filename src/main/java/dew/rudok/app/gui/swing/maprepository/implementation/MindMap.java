package dew.rudok.app.gui.swing.maprepository.implementation;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;

public class MindMap extends MapNode {

    private boolean template;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    public MindMap(String name, MapNode parent, boolean template) {
        super(name, parent);
        this.template = template;
    }
}
