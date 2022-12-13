package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.workspace.panel.ElementPanel;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TopicPainter extends ElementPainter{
    public TopicPainter(ElementPanel element, Shape s) {
        super(element, new Ellipse2D.Float());
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
