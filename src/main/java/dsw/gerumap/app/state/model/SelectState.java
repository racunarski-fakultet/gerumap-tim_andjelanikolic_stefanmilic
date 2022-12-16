package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.MultiSelectionPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

public class SelectState extends State {

    private Shape selection;
    private int flag;
    MultiSelectionPainter msp;
    private Point start;
    private Point end;
//    int x1, y1;

    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        if(!(map.getSelectionModel().getSelected().isEmpty())) {
            map.getSelectionModel().clearList();
        }

        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                map.getSelectionModel().addElement(p.getElement());
                flag = 1;
                System.out.println("selektovani: " + map.getSelectionModel().getSelected().toString());
            }
//            else{
//                msp = new MultiSelectionPainter();
//                start = new Point(x, y);
//                end = new Point(x, y);
//                msp.updatePoints(start, end);
//                flag = 0;
//            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misPovucen(int x, int y, MapView map) throws IOException {
        for(ElementPainter p : map.getPainters()){
            Topic t = (Topic) p.getElement();

            if(map.getSelectionModel().getSelected().contains(t)) {
                if (flag == 1) {
                    t.setX(x);
                    t.setY(y);
                }
//                else if(flag == 0){
//                    end = new Point(x, y);
//                    msp.updatePoints(start, end);
////                    if(msp.getShape().intersects(p.getS().getBounds().getX(), p.getS().getBounds().getY(), p.getS().getBounds().getWidth(), p.getS().getBounds().getHeight())){
////                        map.getSelectionModel().addElement(p.getElement());
////                    }
//                }
            }
        }
    }


}
