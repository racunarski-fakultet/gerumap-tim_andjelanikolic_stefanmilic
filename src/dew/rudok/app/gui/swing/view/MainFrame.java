package dew.rudok.app.gui.swing.view;

import dew.rudok.app.gui.swing.controller.ActionManager;

import javax.swing.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;

    private  MainFrame () {

    }

    private void initialise () {



    }

    public static MainFrame getInstance() {

        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }


}
