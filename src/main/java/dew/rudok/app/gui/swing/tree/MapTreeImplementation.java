package dew.rudok.app.gui.swing.tree;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dew.rudok.app.gui.swing.tree.model.MapTreeItem;
import dew.rudok.app.gui.swing.tree.view.MapTreeView;


import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;



public class MapTreeImplementation implements MapTree{

    private MapTreeView mapTreeView;
    private DefaultTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {

        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        mapTreeView = new MapTreeView(treeModel);

        return mapTreeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if (!((parent.getMapNode()) instanceof MapNodeComposite)) {
            return;
        }

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {

        return (MapTreeItem) mapTreeView.getLastSelectedPathComponent();
    }

    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer)
            return  new Project("Project" + ((ProjectExplorer) parent).getChildren().size(), parent);
        return null;
    }
}
