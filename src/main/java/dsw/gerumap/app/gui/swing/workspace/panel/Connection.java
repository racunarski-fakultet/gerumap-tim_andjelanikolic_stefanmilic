package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;

public class Connection extends Element {

    private Topic firstTopic;
    private Topic secondTopic;
    public Connection(String name, MapNode parent) {
        super(name, parent);
    }
}
