package dew.rudok.app.gui.swing.view;

import dew.rudok.app.gui.swing.controller.ActionManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;

    private  MainFrame () {

    }

    private void initialise () {
        actionManager = new ActionManager();
        intialiseGui();

    }

    private void intialiseGui() {

        Toolkit kit = Toolkit.getDefaultToolkit();




    }

    public static MainFrame getInstance() {

        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }


}
