package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.controller.ActionManager;

import javax.swing.*;

public class WorkToolbar extends JToolBar {

    public WorkToolbar () {
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getAddStateController());
        add(MainFrame.getInstance().getActionManager().getAddConnectionStateController());
        add(MainFrame.getInstance().getActionManager().getSelectStateContoller());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomStateController());
        add(MainFrame.getInstance().getActionManager().getMoveStateController());
        add(Box.createGlue());
        add(MainFrame.getInstance().getActionManager().getSettingsStateController());
    }

}
