package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class TopicPainter extends ElementPainter{

    private Shape s;
    private Element element;

    public TopicPainter(Element element, Shape s) {
        this.element = element;
        this.s = s;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(element.getColor());
        graphics.setStroke(new BasicStroke(element.getStroke()));
        graphics.draw(getS());

        if (element instanceof Topic){
            Topic el = (Topic)element;
            g.drawString(el.getName(), (int)el.getX()+26,
                    (int)el.getY()+20);
        }
    }

    @Override
    public boolean elementAt(Point position) {
        return getS().contains(position);
    }
}