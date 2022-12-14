package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;

@Getter
@Setter
@ToString
public class Topic extends Element {
    private int x, y;
    private int w = 100, l = 50;

    public Topic(String name, MapNode parent, Color color, int stroke, int x, int y) {
        super(name, parent, color, stroke);
        this.x = x;
        this.y = y;
    }
}
