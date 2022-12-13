package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteStateAction extends AbstractGeRuMapAction {

    public DeleteStateAction() {
//        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete element");
        putValue(SHORT_DESCRIPTION, "Delete element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startDeleteState();
    }
}
