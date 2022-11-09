package dew.rudok.app.gui.swing.maprepository.factory;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.Element;


public class ElementFactory extends NodeFactory {

    private Element element;

    public ElementFactory(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public Element createNode() {
        return new Element(element.getName(), element.getParent());
    }
}
