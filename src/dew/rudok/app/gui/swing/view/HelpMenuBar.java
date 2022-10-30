package dew.rudok.app.gui.swing.view;

import javax.swing.*;

public class HelpMenuBar extends JMenuBar {

    public HelpMenuBar() {
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());

        this.add(helpMenu);
    }
}
