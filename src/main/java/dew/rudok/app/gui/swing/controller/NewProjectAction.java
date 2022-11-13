package dew.rudok.app.gui.swing.controller;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.factory.utils.FactoryUtils;
import dew.rudok.app.gui.swing.tree.model.MapTreeItem;
import dew.rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGeRuMapAction {

    public NewProjectAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapNode selected = MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        NodeFactory nf = FactoryUtils.getNodeFactory(selected);
        MapTreeItem item = new MapTreeItem(nf.getNode(selected));
//        MainFrame.getInstance().getMapTree().addChild(selected, item);
    }
}
