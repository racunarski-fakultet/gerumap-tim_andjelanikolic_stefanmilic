package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;

public class SelectState extends State {

    @Override
    public void misKliknut(int x, int y, MapView map) {
//        for(ElementPainter p : map.getPainters()){
//            p.elementAt(x, y);
//        }
        System.out.println("selectstate");
    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misPovucen(MouseEvent e) {

    }
}
