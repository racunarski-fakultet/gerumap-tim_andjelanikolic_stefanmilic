package dew.rudok.app.gui.swing.maprepository.implementation;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;

public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            this.getChildren().add(project);
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            this.getChildren().remove(project);
        }
    }


}

