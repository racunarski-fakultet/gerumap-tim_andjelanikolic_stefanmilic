package dew.rudok.app.gui.swing.maprepository.factory;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;

public class ProjectFactory extends NodeFactory {

    protected Project project;

    public ProjectFactory(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public MapNode createNode() {
        return new Project(project.getName(), project.getParent());
    }
}
