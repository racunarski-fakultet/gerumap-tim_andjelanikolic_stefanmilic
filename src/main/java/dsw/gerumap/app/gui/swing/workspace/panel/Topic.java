package dsw.gerumap.app.gui.swing.workspace.panel;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.awt.*;
import java.io.IOException;

@Getter
@Setter
@ToString
public class Topic extends Element{
    private int x, y;
    private int w = 100, l = 50;

    public Topic(String name, MapNode parent, Color color, int stroke, int x, int y) {
        super(name, parent, color, stroke);
        this.x = x;
        this.y = y;
    }

    public void setX(int x) throws IOException {
        this.x = x;
        notify(this);
    }

    public void setY(int y) throws IOException {
        this.y = y;
        notify(this);
    }
}
