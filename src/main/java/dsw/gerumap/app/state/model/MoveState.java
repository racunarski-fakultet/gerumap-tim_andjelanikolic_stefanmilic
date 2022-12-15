package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MoveState extends State {
    int flag = 0;
    @Override
    public void misKliknut(int x, int y, MapView map) {
//        Topic topic = (Topic) map.getSelectionModel().getSelected().get(map.getSelectionModel().getSelected().size() - 1);
//        if(topic.getX() == x && topic.getY() == y){
        Point point = new Point(x, y);
        for(ElementPainter p : map.getPainters()){
            Topic t = (Topic) p.getElement();
            if(map.getSelectionModel().getSelected().contains(t)){
                if(p.elementAt(point)){
                    flag = 1;
                }
            }
        }
    }
    @Override
    public void misOtpusten(int x, int y, MapView map) throws IOException {
//        Topic topic = (Topic) map.getSelectionModel().getSelected().get(map.getSelectionModel().getSelected().size() - 1);
//        topic.setX(x);
//        topic.setY(y);
//        map.update(map);
    }

    @Override
    public void misPovucen(int x, int y, MapView map) throws IOException {
//        Topic topic = (Topic) map.getSelectionModel().getSelected().get(map.getSelectionModel().getSelected().size() - 1);
        for(ElementPainter p : map.getPainters()){
            Topic t = (Topic) p.getElement();
            if(map.getSelectionModel().getSelected().contains(t)) {
                if (flag == 1) {
                    t.setX(x);
                    t.setY(y);
                }
            }
        }
//        topic.setX(x);
//        topic.setY(y);
//        map.update(topic);
    }

}
