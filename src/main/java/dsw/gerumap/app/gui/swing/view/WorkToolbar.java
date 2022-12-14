package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class WorkToolbar extends JToolBar {

    public WorkToolbar () {
        super(VERTICAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getSelectStateContoller());
        add(MainFrame.getInstance().getActionManager().getMoveStateController());
        add(MainFrame.getInstance().getActionManager().getAddStateController());
        add(MainFrame.getInstance().getActionManager().getAddConnectionStateController());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomStateController());
        add(Box.createGlue());
        add(MainFrame.getInstance().getActionManager().getEditStateAction());
    }

}
