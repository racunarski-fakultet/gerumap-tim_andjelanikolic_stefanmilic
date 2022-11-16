package dsw.gerumap.app.gui.swing.workspace.view;

import dsw.gerumap.app.gui.swing.controller.MapTreeAction;
import dsw.gerumap.app.gui.swing.controller.MapTreeActionType;
import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;
import java.awt.*;

@Setter
@Getter
@ToString
public class MapView extends JPanel implements Subscriber {

    private MindMap mindMap;
    private  JLabel label;
    private int index;


    public MapView(MindMap map, int index) {
        this.setLayout(new FlowLayout());
        this.label = new JLabel("");
        this.add(label);
        this.index = index;
        this.setMap(map);
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
        tabbedPane.setTitleAt(this.index, this.mindMap.getName());
    }

    @Override
    public void update(Object object) {
        if (!(object instanceof MapTreeAction)) return;
        MapTreeAction action = (MapTreeAction) object;
        MapTreeActionType actionType = action.getActionType();
        if (actionType == MapTreeActionType.RENAME_MAP) {
            this.setMap((MindMap)action.getState());
        }
    }
}

