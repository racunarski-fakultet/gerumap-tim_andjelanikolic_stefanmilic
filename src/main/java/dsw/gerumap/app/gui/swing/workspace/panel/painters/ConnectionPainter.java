package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Line2D;

@Getter
@Setter
public class ConnectionPainter extends ElementPainter {

    Shape s;
    public ConnectionPainter(Element element, Shape s) {
        super(element);
        this.s = s;
    }

    @Override
    public void draw(Graphics g, Element element) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(element.getColor());
        graphics.setStroke(new BasicStroke(element.getStroke()));
        graphics.draw(getS());
    }

    @Override
    public boolean elementAt(Point position, Element element) {
        return getS().contains(position);
    }
}
