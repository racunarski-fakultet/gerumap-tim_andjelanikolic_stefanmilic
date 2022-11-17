package dew.rudok.app.gui.swing;

import dew.rudok.app.core.Gui;
import dew.rudok.app.gui.swing.message.Message;
import dew.rudok.app.gui.swing.view.MainFrame;

import javax.swing.*;

public class SwingGui implements Gui {

    private MainFrame instance;

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }

    @Override
    public void update(Object object) {
        JOptionPane.showInputDialog(MainFrame.getInstance(), ((Message)object).getContent());
    }
}
