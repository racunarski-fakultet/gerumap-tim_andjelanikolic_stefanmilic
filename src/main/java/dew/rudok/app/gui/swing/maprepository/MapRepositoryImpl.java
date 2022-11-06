package dew.rudok.app.gui.swing.maprepository;

import dew.rudok.app.core.MapRepository;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl () {
        projectExplorer = new ProjectExplorer("Мој пројект експлорер");
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {

    }


    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }


}