package dew.rudok.app.gui.swing.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());

        JMenu helpMenu = new JMenu("Help");
        JMenuItem infoDialog = new JMenuItem("Info");

        infoDialog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoDialog help = null;
                try {
                    help = new InfoDialog(MainFrame.getInstance(), "Info", false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                help.setVisible(true);
            }
        });

        helpMenu.add(infoDialog);

        this.add(fileMenu);
        this.add(helpMenu);
    }
}
