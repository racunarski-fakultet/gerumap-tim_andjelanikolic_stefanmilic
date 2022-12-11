package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.state.model.SelectState;

import java.awt.event.ActionEvent;

public class SelectStateContoller extends AbstractGeRuMapAction {

    public SelectStateContoller () {
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startSelectState();
    }
}
