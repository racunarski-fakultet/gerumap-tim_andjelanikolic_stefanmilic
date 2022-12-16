package dsw.gerumap.app.gui.swing.workspace.panel.painters;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
public abstract class ElementPainter{

    Element element;
    Shape s;
//    public ElementPainter(Element element) {}
//    public ElementPainter(Element firstElement, Element secondElement){}

    public abstract void draw (Graphics g);

    public abstract boolean elementAt (Point position);

}
