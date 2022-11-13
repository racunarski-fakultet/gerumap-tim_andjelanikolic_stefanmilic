package dew.rudok.app.gui.swing.maprepository.factory;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;
import lombok.NoArgsConstructor;

public class ProjectFactory extends NodeFactory {

    public ProjectFactory() {
    }

    @Override
    public MapNode createNode(MapNode node) {
        return new Project("Project", node);
    }
}
