package dew.rudok.app.gui.swing.controller;

import dew.rudok.app.gui.swing.view.InfoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction{

    private JFrame infoFrame;

    public InfoAction() {
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Administrator info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoFrame = new InfoFrame();


    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}
