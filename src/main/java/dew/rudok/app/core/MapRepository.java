package dew.rudok.app.core;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;

public interface MapRepository {


    ProjectExplorer getProjectExplorer();
    public void addChild(MapNodeComposite parent, MapNode child);


}
