package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Connection;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ConnectionPainter;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteState extends State {

    List<ElementPainter> nova = new ArrayList<>();

    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                if(p.getElement() instanceof Topic){
                    Topic t = (Topic) p.getElement();
                    for(ConnectionPainter painter : t.getConnectionList()){
//                        map.getMindMap().removeChild(painter.getElement());
                        nova.add(painter);
                    }
                    map.getMindMap().removeChild(p.getElement());
                    nova.add(p);
                    System.out.println("topic");
                }
                else if(p.getElement() instanceof Connection){
                    System.out.println("veza");
                    map.getMindMap().removeChild(p.getElement());
                    nova.add(p);
                }
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
