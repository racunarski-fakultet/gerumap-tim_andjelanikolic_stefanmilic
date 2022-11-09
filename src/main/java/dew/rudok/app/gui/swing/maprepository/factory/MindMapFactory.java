package dew.rudok.app.gui.swing.maprepository.factory;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.MindMap;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;

public class MindMapFactory extends NodeFactory {

    private MindMap map;

    public MindMapFactory(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public MindMap createNode() {
        return new MindMap(map.getName(), map.getParent());
    }
}
