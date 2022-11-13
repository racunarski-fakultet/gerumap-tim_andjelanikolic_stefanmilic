package dew.rudok.app.gui.swing.maprepository;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;


public abstract class NodeFactory extends MapNode{
    public MapNode getNode(MapNode parent){
        MapNode n = createNode(parent);
        n.setParent(parent);
        return n;
    }

    public abstract MapNode createNode(MapNode node);

}
