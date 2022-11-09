package dew.rudok.app.gui.swing.maprepository;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;

public abstract class NodeFactory extends MapNode{

    public NodeFactory(String name, MapNode parent) {
        super(name, parent);
    }

    public MapNode getNode () {
        MapNode n = createNode();
        n.setName(super.getName());
        n.setParent(super.getParent());

        return n;
    }

    public abstract MapNode createNode ();

}
