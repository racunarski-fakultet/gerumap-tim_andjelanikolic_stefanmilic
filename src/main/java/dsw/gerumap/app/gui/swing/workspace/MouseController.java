package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseController extends MouseAdapter {

    MapView mapView;

    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        MainFrame.getInstance().getProjectView().clickedMouse(position.x, position.y, mapView.getMindMap());
    }

}
