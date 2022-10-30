package dew.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractRudokAction{

    public InfoAction() {
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Administrator info");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public boolean accept(Object sender) {
        return super.accept(sender);
    }
}
