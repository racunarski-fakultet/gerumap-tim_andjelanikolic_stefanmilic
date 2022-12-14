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

    private String name;
    private int x, y;
    private int w = 100, l = 50;

    public Topic(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Topic(Color color, int stroke, String name, int x, int y) {
        super(color, stroke);
        this.name = name;
        this.x = x;
        this.y = y;
    }

}
