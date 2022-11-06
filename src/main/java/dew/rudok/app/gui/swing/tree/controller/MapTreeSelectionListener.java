package dew.rudok.app.gui.swing.tree.controller;

import dew.rudok.app.gui.swing.tree.model.MapTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class MapTreeSelectionListener implements TreeSelectionListener {


    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath treePath = e.getPath();
        MapTreeItem treeItemSelectedc = (MapTreeItem) treePath.getLastPathComponent();

        System.out.println("Selektovan node: " + treeItemSelectedc.getMapNode().getName());
        System.out.println("Putanja: " +  e.getPath());

    }
}
