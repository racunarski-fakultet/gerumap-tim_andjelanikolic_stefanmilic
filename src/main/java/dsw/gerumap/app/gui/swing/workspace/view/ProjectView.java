package dsw.gerumap.app.gui.swing.workspace.view;

import dsw.gerumap.app.gui.swing.controller.MapTreeAction;
import dsw.gerumap.app.gui.swing.controller.MapTreeActionType;
import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Project;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.Workspace;
import dsw.gerumap.app.gui.swing.workspace.WorkspaceImplemetation;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ProjectView extends JPanel implements Subscriber {

    private String projectName;
    private String authorName;
    private JTabbedPane tabbedPane;
    private Project project;
    private List<MapView> tabs;
    private JLabel lblProjectName;
    private JLabel lblAuthor;
    private JLabel label;

    public ProjectView(){
        this.tabs = new ArrayList<MapView>();
        this.lblAuthor = new JLabel();
        this.lblProjectName = new JLabel();
        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        initialise();
    }

    private void initialise(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        label = new JLabel("Autor i ime projekta");

        add(label);
        add(tabbedPane);
    }

//    public void setProject(Project project) {
//        if(this.project != null)
//            this.project.removeSubs(this);
//        this.project = project;
//        this.project.addSubs(this);
//    }
    public void updateLabel() {

        authorName = project.getAuthor();
        projectName = project.getName();

        label.setText(authorName + " " + projectName);

        if (this.project == null) {
            this.lblProjectName.setText("");
            return;
        }
        this.lblProjectName.setText(this.project.getName() + " - " + this.project.getAuthor());
    }

    public void refreshTabs(MapNode selected){
        tabbedPane.removeAll();
        tabs.clear();
        this.project = (Project) selected;
        project.addSubs(this);

        if (this.project == null) {
            this.tabbedPane.setVisible(false);
            return;
        }

        for (MapNode child: ((Project) selected).getChildren()){
            MapView tab = new MapView((MindMap)child);
            tabs.add(tab);
        }

        for (MapView tabovi : tabs) {
            tabbedPane.addTab(tabovi.getMindMap().getName(), tabovi);
        }
        updateLabel();
        tabbedPane.setVisible(true);
    }

//    public void mousePressed(MouseEvent e) {
//        if(e.getClickCount() == 2){
//            MapTreeItem selectedWrapper = (MapTreeItem) map.getLastSelectedPathComponent();
//            MapNode selectedNode = selectedWrapper.getMapNode();
//
//            Workspace workspace = MainFrame.getInstance().getWorkspace();
//            if(workspace instanceof WorkspaceImplemetation && selectedNode instanceof Project){
//                ((WorkspaceImplemetation) workspace).getProjectView().refreshTabs();
//            }
//
//            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
//        }
//    }

    @Override
    public void update(Object object) {
//        if (!(object instanceof MapTreeAction)) return;
//        MapTreeAction action = (MapTreeAction) object;
//        MapTreeActionType actionType = action.getActionType();
//        if (actionType == MapTreeActionType.SELECT_PROJECT) {
//            Project newProject = (Project) action.getState();
//            this.setProject(newProject);
//        }
//        else if (actionType == MapTreeActionType.DELETE_PROJECT) {
//            this.setProject(null);
//        }
//        else if (actionType == MapTreeActionType.NEW_MAP || actionType == MapTreeActionType.DELETE_MAP) {
//            MindMap newMap = (MindMap) action.getState();
//            Project newProject = (Project) newMap.getParent();
//            this.setProject(newProject);
//        }
//
//        else if (actionType == MapTreeActionType.RENAME_PROJECT || actionType == MapTreeActionType.RENAME_AUTHOR) {
//            this.project = (Project) action.getState();
//            this.updateLabel();
//        }
        if(project == null){
            return;
        }
        updateLabel();
    }
}
