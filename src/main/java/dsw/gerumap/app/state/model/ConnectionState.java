package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Connection;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ConnectionPainter;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;

public class ConnectionState extends State {

    List<ElementPainter> lista;
    Topic t1;
    Topic t2;

    @Override
    public void misKliknut(int x, int y, MapView map) {
        Point position1 = new Point(x, y);
        lista = map.getPainters();

        for(ElementPainter p : lista){
            if(p.elementAt(position1)){
                for(MapNode e : map.getMindMap().getChildren()){
                    if(p.getElement().getName().equals(e.getName())){
                        t1 = (Topic) e;
                        System.out.println(t1);
                    }
                }
                map.setPos1(position1);
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {
        Point position2 = new Point(x, y);
        lista = map.getPainters();

        for(ElementPainter p : lista){
            if(p.elementAt(position2)){
                map.setPos2(position2);
                for(MapNode e : map.getMindMap().getChildren()){
                    if(p.getElement().getName().equals(e.getName())){
                        t2 = (Topic) e;
                        System.out.println(t2);
                    }
                }
                Connection con = new Connection(t1, t2);
                Line2D line = new Line2D.Float(map.getPos1().x, map.getPos1().y, map.getPos2().x, map.getPos2().y);
                ConnectionPainter cp = new ConnectionPainter(line);
                map.getPainters().add(cp);
                map.getMindMap().getChildren().add(con);
            }
        }
    }

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }
}
