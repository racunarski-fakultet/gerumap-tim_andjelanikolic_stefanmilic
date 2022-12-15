package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.state.State;

import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import java.awt.*;
import java.awt.event.MouseEvent;

public class EditState extends State {

    @Override
    public void misKliknut(int x, int y, MapView map) {
//        for(Element el: map.getSelectionModel().getSelected()){
//            Color color1 = Color.BLACK;
//            Color color = JColorChooser.showDialog( el, "Select color", color1);
//        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }

}
