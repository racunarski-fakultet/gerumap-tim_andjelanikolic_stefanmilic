package dew.rudok.app.gui.swing.maprepository.implementation;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;
import lombok.NoArgsConstructor;

public class MindMap extends MapNodeComposite {

    private boolean template;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {

    }

    public MindMap(String name, MapNode parent, boolean template) {
        super(name, parent);
        this.template = template;
    }
}
