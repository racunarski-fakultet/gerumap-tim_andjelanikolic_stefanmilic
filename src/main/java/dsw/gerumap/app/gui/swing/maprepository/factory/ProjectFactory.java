package dsw.gerumap.app.gui.swing.maprepository.factory;

import dsw.gerumap.app.gui.swing.maprepository.NodeFactory;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dsw.gerumap.app.observer.Subscriber;

public class ProjectFactory extends NodeFactory {

    public ProjectFactory() {
    }

    @Override
    public MapNode createNode(MapNode node) {
        return new Project("Project" + ((ProjectExplorer) node).getChildren().size(), node);
    }

    @Override
    public void addSubs(Subscriber subscriber) {

    }

    @Override
    public void removeSubs(Subscriber subscriber) {

    }

    @Override
    public void notify(Object notification) {

    }
}
