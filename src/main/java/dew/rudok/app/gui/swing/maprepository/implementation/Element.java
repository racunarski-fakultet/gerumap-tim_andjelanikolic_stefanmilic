package dew.rudok.app.gui.swing.maprepository.implementation;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Element extends MapNode {
    public Element(String name, MapNode parent) {
        super(name, parent);
    }
}
