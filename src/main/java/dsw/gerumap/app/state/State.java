package dsw.gerumap.app.state;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.workspace.MapView;

import java.awt.event.MouseEvent;

public abstract class State {

    public abstract void misKliknut(int x, int y, MapView map);

    public abstract void misOtpusten(MouseEvent e);

    public abstract void misPovucen(MouseEvent e);
}
