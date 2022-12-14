package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class SelectState extends State {

    @Override
    public void misKliknut(int x, int y, MapView map) throws IOException {
        if(!(map.getSelectionModel().getSelected().isEmpty())) {
            for(Element el : map.getSelectionModel().getSelected()){
                el.setColor(Color.BLACK);
            }
            map.getSelectionModel().getSelected().clear();
        }

        for(ElementPainter p : map.getPainters()){
            Point pos = new Point(x, y);
            if(p.elementAt(pos)){
                map.getSelectionModel().getSelected().add(p.getElement());
                System.out.println(map.getSelectionModel().getSelected().toString());
                System.out.println("selektovan");
                p.getElement().setColor(Color.BLUE);
                map.update(map);
            }
        }
    }

    @Override
    public void misOtpusten(int x, int y, MapView map) {

    }

    @Override
    public void misPovucen(int x, int y, MapView map) {

    }


}
