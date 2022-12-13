package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SettingsStateAction extends AbstractGeRuMapAction {

    public SettingsStateAction() {
//        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Settings");
        putValue(SHORT_DESCRIPTION, "Settings");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startSettingsState();
    }
}
