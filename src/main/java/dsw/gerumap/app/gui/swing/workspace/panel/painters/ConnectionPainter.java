package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.workspace.panel.ElementPanel;

import java.awt.*;
import java.awt.geom.Line2D;

public class ConnectionPainter extends ElementPainter {
    public ConnectionPainter(ElementPanel element, Shape s) {
        super(element, new Line2D.Float());
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    @Override
    public void elementAt(int x, int y) {
        super.elementAt(x, y);
    }

}
