package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;

import java.io.IOException;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent) throws IOException;
    MapTreeItem getSelectedNode();
    MapTreeView getTreeView();
    void loadProject(Project node) throws IOException;
    void deleteChild (MapTreeItem chlild) throws IOException;

}
