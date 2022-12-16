package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class MultiSelectionPainter extends ElementPainter{

    private int x, y, w, l;
    private Shape shape;

    public MultiSelectionPainter() {
    }

    public void updatePoints(Point start, Point end){
        this.x = Math.min(start.x, end.x);
        this.y = Math.min(start.y, end.y);
        this.w = Math.abs(end.x - start.x);
        this.l = Math.abs(end.y - start.y);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        shape = new Rectangle2D.Float(x, y, w, l);
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.draw(shape);
    }

    @Override
    public boolean elementAt(Point position) {
        return false;
    }
}
