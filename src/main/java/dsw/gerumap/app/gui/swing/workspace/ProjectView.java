package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.state.StateManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements Subscriber {
    private JTabbedPane tabbedPane;
    private Project project;
    private List<MapView> tabs;
    private JLabel lblNameAndAuthor;
    private StateManager stateManager;

    public ProjectView(){
        initialise();
    }

    private void initialise(){
        tabs = new ArrayList<MapView>();
        lblNameAndAuthor = new JLabel("Autor i ime projekta");
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        stateManager = new StateManager();

        setLayout(new BorderLayout());

        add(lblNameAndAuthor, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
    }

    public void updateLabel() {
        if (project == null) {
            lblNameAndAuthor.setText("Autor i ime projekta");
            return;
        }

        lblNameAndAuthor.setText(project.getName() + " (" + project.getAuthor() + ")");
    }

    public void refreshTabs(MapNode selected){
        tabbedPane.removeAll();
        tabs.clear();
        project = (Project) selected;

        project.addSubs(this);
        System.out.println(project.getSubscribers().toString());

        if (project == null) {
            tabbedPane.setVisible(false);
            return;
        }

        for (MapNode child: ((Project) selected).getChildren()){
            if(!child.getSubscribers().isEmpty()) {
                child.getSubscribers().clear();
            }
            MapView tab = new MapView((MindMap)child, tabbedPane.getTabCount());
            child.addSubs(tab);
            tabs.add(tab);
        }

        for (MapView tabovi : tabs) {
            tabbedPane.addTab(tabovi.getMindMap().getName(), tabovi);
        }
        updateLabel();
        tabbedPane.setVisible(true);
    }

    public void clearTab(){
        tabbedPane.removeAll();
        tabs.clear();
        lblNameAndAuthor.setText("Autor i ime projekta");
    }

    @Override
    public void update(Object object) {
        if(project == null){
            return;
        }
        updateLabel();
        System.out.println("update pv");
    }

    public void startTopicState() {
        this.stateManager.setTopicState();
    }
    public void startConnectionState() {
        this.stateManager.setConnectionState();
    }
    public void startDeleteState() {
        this.stateManager.setDeleteState();
    }
    public void startMoveState() {
        this.stateManager.setMoveState();
    }
    public void startZoomState() {
        this.stateManager.setZoomState();
    }
    public void startSelectState() {this.stateManager.setSelectionState();}
    public void startEditState() {
        this.stateManager.setEditState();
    }

    public void misKliknut(int x, int y, MapView m) throws IOException {
        this.stateManager.getState().misKliknut(x, y, m);
        System.out.println("misklikunt pv");
    }

    public void misOtpusten(int x, int y, MapView m) throws IOException {
        this.stateManager.getState().misOtpusten(x, y, m);
    }

    public void misPovucen(int x, int y, MapView m) throws IOException {
        this.stateManager.getState().misPovucen(x, y, m);
    }
}
