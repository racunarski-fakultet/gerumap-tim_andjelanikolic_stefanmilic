package dsw.gerumap.app.gui.swing.tree.controller;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import org.w3c.dom.events.MouseEvent;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class MapTreeSelectionListener implements TreeSelectionListener {


    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath treePath = e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem) treePath.getLastPathComponent();


        System.out.println("Selektovan node: " + treeItemSelected.getMapNode().getName());
        System.out.println("Putanja: " +  e.getPath());

    }
}
