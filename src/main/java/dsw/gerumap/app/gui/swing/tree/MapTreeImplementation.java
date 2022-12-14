package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.gui.swing.maprepository.NodeFactory;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.gui.swing.maprepository.factory.utils.FactoryUtils;
import dsw.gerumap.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;


import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.io.IOException;


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
    public void addChild(MapTreeItem parent) throws IOException {
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

    @Override
    public void deleteChild(MapTreeItem child) throws IOException {
        MapTreeItem parent = (MapTreeItem) child.getParent();
        parent.remove(child);
        ((MapNodeComposite) parent.getMapNode()).removeChild(child.getMapNode());
        SwingUtilities.updateComponentTreeUI(mapTreeView);
    }

    private MapNode createChild(MapNode parent) {
        NodeFactory nf = FactoryUtils.getNodeFactory(parent);
        return nf.getNode(parent);
    }
}
