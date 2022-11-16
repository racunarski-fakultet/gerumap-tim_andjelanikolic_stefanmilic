package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();
    void deleteChild (MapTreeItem chlild);

}
