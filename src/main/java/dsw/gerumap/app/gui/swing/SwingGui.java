package dsw.gerumap.app.gui.swing;

import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.message.Message;
import dsw.gerumap.app.gui.swing.view.MainFrame;

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
        JOptionPane.showMessageDialog(MainFrame.getInstance(), ((Message)object), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
