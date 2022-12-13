package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.NoArgsConstructor;

import java.awt.*;

public class Topic extends Element {

    private String nameTopic;
    private int x, y;
    private int w = 200, l = 100;

    public Topic(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
