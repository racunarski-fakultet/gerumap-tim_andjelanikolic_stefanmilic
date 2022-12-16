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
import java.util.ArrayList;
import java.util.List;

public class SelectState extends State {
    private MultiSelectionPainter msp = new MultiSelectionPainter();
    private int x1, y1;
    private int flag;
    private List<ElementPainter> nova = new ArrayList<>();

    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        if(!(map.getSelectionModel().getSelected().isEmpty())) {
            map.getSelectionModel().clearList();
        }

        nova.clear();

        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                map.getSelectionModel().addElement(p.getElement());
                System.out.println("selektuj");
            }
            else{
//                msp = new MultiSelectionPainter(x, y, x, y);
                msp.setX(x);
                msp.setY(y);

                x1 = x;
                y1 = y;

                System.out.println("klik");
                nova.add(msp);
            }
        }
        if(!nova.isEmpty()) {
            for (ElementPainter n : nova) {
                map.getPainters().add(n);
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) throws IOException {

        for(ElementPainter p : map.getPainters()){
            if(p == msp || p instanceof MultiSelectionPainter)
                continue;

            if(msp.getShape() == null){
                map.getPainters().remove(msp);
                return;
            }

            if(msp.getShape().intersects(p.getS().getBounds().getX(), p.getS().getBounds().getY(), p.getS().getBounds().getWidth(), p.getS().getBounds().getHeight())){
                map.getSelectionModel().addElement(p.getElement());
            }
        }

        if(!nova.isEmpty()) {
            for (ElementPainter n : nova) {
                map.getPainters().remove(n);
                msp = new MultiSelectionPainter();
            }
        }
        map.update(this);
    }

    @Override
    public void misPovucen(int x, int y, MapView map){

        msp.updatePoints(x1, y1, x, y);
        map.update(msp);
        System.out.println("pravivuce");


//        for(ElementPainter p : map.getPainters()){
//            Topic t = (Topic) p.getElement();
//
////            if(flag == 1){
//                if(map.getSelectionModel().getSelected().contains(t)) {
//                    t.setX(x);
//                    t.setY(y);
//                }else{
//                    msp.updatePoints(x1, y1, x, y);
//                    map.update(msp);
//                    System.out.println("pravi2");
//                }
////            }
////            else if(flag == 0){
//
////            }
//        }
    }


}
