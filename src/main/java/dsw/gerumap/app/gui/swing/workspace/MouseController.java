package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.observer.Subscriber;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MouseController extends MouseAdapter implements Subscriber{

    MapView mapView;

    public MouseController(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point position = e.getPoint();
        try {
            MainFrame.getInstance().getProjectView().misKliknut(position.x, position.y, mapView);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("mousecontroler");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point position = e.getPoint();
        MainFrame.getInstance().getProjectView().misOtpusten(position.x, position.y, mapView);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point position = e.getPoint();
        MainFrame.getInstance().getProjectView().misPovucen(position.x, position.y, mapView);
    }

    @Override
    public void update(Object object) throws IOException {
    }
}
