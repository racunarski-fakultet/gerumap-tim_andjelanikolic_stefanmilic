package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;

import java.awt.*;

public abstract class ElementPainter{

    Element element;

    public ElementPainter(Element element) {
        this.element = element;
    }

    public abstract void draw (Graphics g, Element element);

    public abstract boolean elementAt (Point position, Element element);

}
