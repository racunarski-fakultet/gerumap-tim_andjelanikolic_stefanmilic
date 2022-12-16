package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@NoArgsConstructor
@Getter
@Setter
public class Connection extends Element {
    private Topic firstTopic;
    private Topic secondTopic;

    public Connection(String name, MapNode parent, Color color, int stroke, Topic firstTopic, Topic secondTopic) {
        super(name, parent, color, stroke);
        this.firstTopic = firstTopic;
        this.secondTopic = secondTopic;
    }

}
