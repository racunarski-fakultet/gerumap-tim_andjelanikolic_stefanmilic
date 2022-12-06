package dsw.gerumap.app.state;

import java.awt.event.MouseEvent;

public interface State {

    void mousePressed (MouseEvent e);

    void mouseRelased (MouseEvent e);

    void mouseDragged (MouseEvent e);

}
