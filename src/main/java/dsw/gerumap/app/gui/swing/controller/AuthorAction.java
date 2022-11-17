package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.message.EventType;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;

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
            String author = JOptionPane.showInputDialog(MainFrame.getInstance(), "Input your name");
            if(!author.isEmpty()) {
                ((Project) selected.getMapNode()).setAuthor(author);
            }else
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.MUST_INSERT_NAME);
        }else if(!(selected.getMapNode() instanceof Project)){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(EventType.AUTHOR_PROJECT_NOT_SELECTED);
        }
    }
}
