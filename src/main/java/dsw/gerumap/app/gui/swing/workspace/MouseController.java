package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.observer.Subscriber;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MouseController implements MouseListener, Subscriber {

    MapView mapView;

    public MouseController(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point position = e.getPoint();
        MainFrame.getInstance().getProjectView().misKliknut(position.x, position.y, mapView);
        System.out.println("mousecontroler");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void update(Object object) throws IOException {
    }
}
