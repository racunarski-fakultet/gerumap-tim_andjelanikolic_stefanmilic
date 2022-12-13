package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.workspace.panel.ElementPanel;

import javax.swing.*;
import java.awt.*;

public abstract class ElementPainter{

    ElementPanel element;
    Shape s;

    public ElementPainter(ElementPanel element, Shape s) {
        this.element = element;
        this.s = s;
    }

    public void draw (Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(element.getColor());
        graphics.setStroke(new BasicStroke(element.getStroke()));
        graphics.draw(s);
    }

    public void elementAt (int x, int y) {
        s.contains(x, y);
    }

}
