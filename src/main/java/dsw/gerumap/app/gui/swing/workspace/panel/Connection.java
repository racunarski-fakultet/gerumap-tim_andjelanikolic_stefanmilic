package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.NoArgsConstructor;

import java.awt.*;

@NoArgsConstructor
public class Connection extends Element {

    private Topic firstTopic;
    private Topic secondTopic;

    public Connection(Color color, int stroke) {
        super(color, stroke);
    }

    public Connection(Topic firstTopic, Topic secondTopic) {
        this.firstTopic = firstTopic;
        this.secondTopic = secondTopic;
    }
}
