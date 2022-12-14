package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {

    List<ElementPainter> nova = new ArrayList<>();

    @Override
    public void misKliknut(int x, int y, MapView map) {
        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                Topic el = (Topic) map.getMindMap().getChildByName(p.getElement().getName());
                map.getMindMap().getChildren().remove(el);
                nova.add(p);
                map.update(map);
            }
        }

        for(ElementPainter n : nova){
            map.getPainters().remove(n);
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }


}
