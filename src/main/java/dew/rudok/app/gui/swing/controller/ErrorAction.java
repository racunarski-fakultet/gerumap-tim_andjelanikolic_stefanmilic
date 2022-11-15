package dew.rudok.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class ErrorAction extends AbstractGeRuMapAction{

    public Error error;


    @Override
    public void actionPerformed(ActionEvent e) {
        error = new Error();
    }


}
