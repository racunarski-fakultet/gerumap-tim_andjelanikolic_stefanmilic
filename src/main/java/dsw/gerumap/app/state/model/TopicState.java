package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.TopicPainter;
import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.IOException;

public class TopicState extends State {
    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        String name = JOptionPane.showInputDialog(MainFrame.getInstance(), "Input text");
        if(name.isEmpty())
            name = "Pojam" + map.getMindMap().numberOfTopics();

        Topic topic = new Topic(name, map.getMindMap(), Color.BLACK, 2, x, y);
        topic.addSubs(map);
        TopicPainter tp = new TopicPainter(topic);

        map.getPainters().add(tp);
        map.getMindMap().addChild(topic);
        System.out.println("topicstate");
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }


}
