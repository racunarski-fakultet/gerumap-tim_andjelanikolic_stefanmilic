package dsw.gerumap.app.state;

import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;

import java.awt.event.MouseEvent;

public interface State {

    void misKliknut (int x, int y, MindMap map);

    void misOtpusten (MouseEvent e);

    void misPovucen (MouseEvent e);

}
