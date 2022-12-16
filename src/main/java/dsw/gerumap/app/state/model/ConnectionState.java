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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionState extends State {
    Topic t1;
    Topic t2;
    private ConnectionPainter connectionPainter;
    private Connection connection;
    List<ElementPainter> nova = new ArrayList<>();
    private Point pos1;
    private Point pos2;

    @Override
    public void misKliknut(int x, int y, MapView map) {

        pos1 = new Point(x, y);
        pos2 = new Point(x, y);
        nova.clear();

        for(ElementPainter p : map.getPainters()){
            if(p.elementAt(pos1)){
                t1 = (Topic) p.getElement();
                t2 = (Topic) p.getElement();
                connection = new Connection(t1, t2);
                connectionPainter = new ConnectionPainter(pos1, pos2,  connection);
                nova.add(connectionPainter);
            }
        }

        for(ElementPainter n : nova){
            map.getPainters().add(n);
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) throws IOException {
        pos2.setLocation(x, y);

        for(ElementPainter p : map.getPainters()){
            if(p.elementAt(pos2)){
                connectionPainter.setPos2(pos2);

                t2 = (Topic) p.getElement();
                connection.setSecondTopic(t2);

                t1.getConnectionList().add(connectionPainter);
                t2.getConnectionList().add(connectionPainter);
                map.getMindMap().addChild(connection);
            }
        }
    }

    @Override
    public void misPovucen(int x, int y, MapView map) {
        pos2.setLocation(x, y);
        map.update(connectionPainter);
    }
}
