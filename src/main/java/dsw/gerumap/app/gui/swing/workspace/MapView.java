package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
public class MapView extends JPanel implements Subscriber {

    private MindMap mindMap;
    private JLabel label;
    private int index;


    public MapView(MindMap map, int index) {
        setLayout(new FlowLayout());
        label = new JLabel("");
        this.index = index;
        add(label);
        setMap(map);
    }

    public void setMap(MindMap mindMap) {
        this.mindMap = mindMap;
        this.updateLabel();
        this.updateTabName();
    }

    public void updateLabel() {
        this.label.setText(this.mindMap.getName());
    }

    public void updateTabName() {
        JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
        if (tabbedPane == null) return;
        tabbedPane.setTitleAt(index, mindMap.getName());
    }

    @Override
    public void update(Object object) {
        if(mindMap == null){
            return;
        }
        updateLabel();
    }

    @Override
    public String toString() {
        return mindMap.getName();
    }
}

