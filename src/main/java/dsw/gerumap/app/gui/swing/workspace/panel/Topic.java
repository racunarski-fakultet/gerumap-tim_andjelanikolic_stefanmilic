package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Topic extends Element {

    private String nameTopic;
    private int x, y;
    private int w = 200, l = 100;

    public Topic(String nameTopic, int x, int y) {
        this.nameTopic = nameTopic;
        this.x = x;
        this.y = y;
    }

}
