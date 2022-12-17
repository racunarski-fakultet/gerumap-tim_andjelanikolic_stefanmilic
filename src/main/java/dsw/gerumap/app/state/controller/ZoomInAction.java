package dsw.gerumap.app.state.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.controller.AbstractGeRuMapAction;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.ProjectView;

import java.awt.event.ActionEvent;

public class ZoomInAction extends AbstractGeRuMapAction {

    public ZoomInAction() {
        putValue(SMALL_ICON, loadIcon("/images/zoom.png"));
        putValue(NAME, "Zoom");
        putValue(SHORT_DESCRIPTION, "Zoom");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().getTabs().get(MainFrame.getInstance().getProjectView().getSelectedIndex()).zoomIn();
    }
}
