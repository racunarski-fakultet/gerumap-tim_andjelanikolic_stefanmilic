package dew.rudok.app.gui.swing.workspace.view;

import dew.rudok.app.gui.swing.maprepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;

@Setter
@Getter
@ToString
public class MapView extends JPanel {

    private MindMap mindMap;

    public MapView(MindMap mindMap){
        this.mindMap = mindMap;
    }

}
