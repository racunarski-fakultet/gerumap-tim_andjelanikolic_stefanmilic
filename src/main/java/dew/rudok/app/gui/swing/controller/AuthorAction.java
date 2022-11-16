package dew.rudok.app.gui.swing.controller;

import dew.rudok.app.core.ApplicationFramework;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dew.rudok.app.gui.swing.message.EventType;
import dew.rudok.app.gui.swing.tree.model.MapTreeItem;
import dew.rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AuthorAction extends AbstractGeRuMapAction {


    public AuthorAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/author.png"));
        putValue(NAME, "Create author");
        putValue(SHORT_DESCRIPTION, "Create author");


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeItem selected = MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected.getMapNode() instanceof Project){
            JOptionPane.showInputDialog(MainFrame.getInstance(), "Input your name");
        }else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.CANNOT_ADD_CHILD);
        }


    }
}
