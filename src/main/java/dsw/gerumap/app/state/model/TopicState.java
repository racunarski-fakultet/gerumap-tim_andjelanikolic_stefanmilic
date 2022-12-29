package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.TopicPainter;
import dsw.gerumap.app.state.State;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TopicState extends State {
    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        Point pos = new Point(x, y);
        int flag = 0;
        for(ElementPainter p : map.getPainters()){
            if(p.elementAt(pos)){
                flag = 1;
                break;
            }
        }
        if(flag == 1){
            x += 20;
            y += 20;
        }
        String name = JOptionPane.showInputDialog(MainFrame.getInstance(), "Input text");
        if(name == null)
            return;
        if(name.isEmpty()) {
            name = "Topic " + map.getMindMap().numberOfTopics();
        }

        Topic topic = new Topic(name, map.getMindMap(), Color.BLACK, 2, x, y);
        topic.addSubs(map);
        TopicPainter tp = new TopicPainter(topic);

        map.getPainters().add(tp);
        map.getMindMap().addChild(topic);
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }


}
