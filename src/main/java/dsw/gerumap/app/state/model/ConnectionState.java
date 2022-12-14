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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionState extends State {
    Topic t1;
    Topic t2;
    List<ElementPainter> nova = new ArrayList<>();
    Point p = new Point(0, 0);

    @Override
    public void misKliknut(int x, int y, MapView map) {
        map.setPos1(p);
        map.setPos1(p);
        Point position1 = new Point(x, y);

        for(ElementPainter p : map.getPainters()){
            if(p.elementAt(position1)){
                for(MapNode e : map.getMindMap().getChildren()){
                    if(p.getElement().getName().equals(e.getName())){
                        t1 = (Topic) e;
                    }
                }
                map.setPos1(position1);
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {
        Point position2 = new Point(x, y);

        for(ElementPainter p : map.getPainters()){
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
                ConnectionPainter cp = new ConnectionPainter(t1, t2, line);
                nova.add(cp);
                map.getMindMap().getChildren().add(con);
            }
        }

        for(ElementPainter n : nova){
            map.getPainters().add(n);
        }
    }

    @Override
    public void misPovucen(int x, int y, MapView map) {



    }
}
