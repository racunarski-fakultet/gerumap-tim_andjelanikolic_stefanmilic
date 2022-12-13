package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.TopicPainter;
import dsw.gerumap.app.state.State;

import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

public class TopicState extends State {
    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        Topic topic = new Topic("Pojam " + map.getMindMap().getChildren().size(), x, y);
        Ellipse2D shape = new Ellipse2D.Float(topic.getX(), topic.getY(), topic.getW(), topic.getL());
        TopicPainter tp = new TopicPainter(topic, shape);
        map.getPainters().add(tp);
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
