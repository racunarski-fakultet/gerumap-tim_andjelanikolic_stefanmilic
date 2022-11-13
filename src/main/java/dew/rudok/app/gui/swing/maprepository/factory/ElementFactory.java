package dew.rudok.app.gui.swing.maprepository.factory;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.Element;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ElementFactory  extends NodeFactory {
    @Override
    public MapNode createNode(MapNode node) {
        return new Element("Element", node);
    }
}
