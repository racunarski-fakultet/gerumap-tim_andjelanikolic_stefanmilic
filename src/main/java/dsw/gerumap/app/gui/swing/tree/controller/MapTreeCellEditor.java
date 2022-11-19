package dsw.gerumap.app.gui.swing.tree.controller;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clicked = null;
    private JTextField edit = null;


    public MapTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent (JTree tree, Object clicked, boolean arg1, boolean arg2, boolean arg3, int arg4) {

        this.clicked = clicked;
        this.edit = new JTextField(clicked.toString());
        this.edit.addActionListener(this);

        return edit;
    }

    public boolean isCellEditable (EventObject arg) {
        if (arg instanceof MouseEvent) {
            if (((MouseEvent)arg).getClickCount() == 3) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!(this.clicked instanceof MapTreeItem)) {
            return;
        }

        MapTreeItem click = (MapTreeItem) clicked;
        click.setName(e.getActionCommand());

        if(click.getMapNode() instanceof  Project){
            MainFrame.getInstance().getProjectView().refreshTabs(click.getMapNode());
        }

        if(click.getMapNode() instanceof MindMap){
            MainFrame.getInstance().getProjectView().refreshTabs(click.getMapNode().getParent());
        }
    }
}
