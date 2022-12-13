package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;

public class TopicState extends State {
    @Override
    public void misKliknut(int x, int y, MapView map) {
        Topic topic = new Topic(x, y);
        map.getMindMap().addChild(topic);
        System.out.println("topicstate");
    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misPovucen(MouseEvent e) {

    }
}
