package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.state.model.AddConnectionState;

import java.awt.event.ActionEvent;

public class AddConnectionStateController extends AbstractGeRuMapAction {

    public AddConnectionStateController() {
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Add connection");
        putValue(SHORT_DESCRIPTION, "Add conneciton");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddConnectionState();
    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}
