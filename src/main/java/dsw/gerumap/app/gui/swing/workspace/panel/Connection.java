package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;

import java.awt.*;

public class Connection extends Element {

    private Topic firstTopic;
    private Topic secondTopic;

    public Connection(Color color, int stroke) {
        super(color, stroke);
    }
}
