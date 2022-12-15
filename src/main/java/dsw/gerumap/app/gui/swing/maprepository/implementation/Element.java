package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.io.IOException;

@NoArgsConstructor
@Getter
public class Element extends MapNode {
    private Color color;
    private int stroke;

    public Element(String name, MapNode parent) {
        super(name, parent);
    }

    public Element(String name, MapNode parent, Color color, int stroke) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
    }

    public void setColor(Color color) throws IOException {
        this.color = color;
        notify(this);
    }

}
