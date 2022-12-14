package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Line2D;

@Getter
@Setter
public class ConnectionPainter extends ElementPainter {

    private Shape s;
    private Element element1;
    private Element element2;

    public ConnectionPainter(Element element1, Element element2, Shape s) {
        this.element1 = element1;
        this.element2 = element2;
        this.s = s;
    }

    public ConnectionPainter(Shape s) {
        this.s = s;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2));
        graphics.draw(getS());
    }

    @Override
    public boolean elementAt(Point position) {
        return getS().contains(position);
    }
}
