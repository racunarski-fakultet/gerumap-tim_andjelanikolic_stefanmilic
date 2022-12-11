package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddStateController extends AbstractGeRuMapAction {

    public AddStateController () {;
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "AddElement");
        putValue(SHORT_DESCRIPTION, "AddElement");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startAddState();
    }
}
