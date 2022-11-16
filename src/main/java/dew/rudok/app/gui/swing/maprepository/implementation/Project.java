package dew.rudok.app.gui.swing.maprepository.implementation;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;
import lombok.NoArgsConstructor;

public class Project extends MapNodeComposite {

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().add(mindMap);
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().remove(mindMap);
        }
    }

}
