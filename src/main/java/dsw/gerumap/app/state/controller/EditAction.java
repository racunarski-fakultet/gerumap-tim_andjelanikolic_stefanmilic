package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.state.view.EditView;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class EditAction extends AbstractGeRuMapAction {

    public EditAction() {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        MainFrame.getInstance().getProjectView().startEditState();
        EditView edit;
        try {
            edit = new EditView(MainFrame.getInstance(), "Edit", false);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        edit.setVisible(true);
    }
}
