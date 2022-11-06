package dew.rudok.app.gui.swing.tree.model;


import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

import javax.swing.tree.DefaultMutableTreeNode;
@Setter
@Getter
public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem (MapNode mapNode) {
        this.mapNode = mapNode;
    }

    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName (String name) {
        this.mapNode.setName(name);
    }

}
