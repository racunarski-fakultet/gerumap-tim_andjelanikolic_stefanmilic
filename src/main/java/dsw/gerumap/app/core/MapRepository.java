package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.gui.swing.maprepository.implementation.ProjectExplorer;

public interface MapRepository {


    ProjectExplorer getProjectExplorer();
    public void addChild(MapNodeComposite parent, MapNode child);
}
