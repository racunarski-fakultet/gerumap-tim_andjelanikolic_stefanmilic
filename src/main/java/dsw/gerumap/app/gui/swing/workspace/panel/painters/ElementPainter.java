package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter{

    Element element;

    public ElementPainter() {

    }

    public abstract void draw (Graphics g);

    public abstract boolean elementAt (Point position);

}
