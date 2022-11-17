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
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProjectView extends JPanel implements Subscriber {
    private JTabbedPane tabbedPane;
    private Project project;
    private List<MapView> tabs;

    private JLabel lblProjectName;
    private JLabel lblAuthor;

    public ProjectView(Project project){
        this.setLayout(new BorderLayout());
        this.project = project;
        this.lblAuthor = new JLabel(project.getAuthor());
        this.lblProjectName = new JLabel(project.getName());

        this.tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        this.tabbedPane.setVisible(false);
        this.add(this.lblProjectName, BorderLayout.NORTH);
        this.add(this.tabbedPane, BorderLayout.CENTER);
    }

    public void setProject(Project project) {
        if(this.project != null)
            this.project.removeSubs(this);
        this.project = project;
        this.project.addSubs(this);
    }
    public void updateLabel() {
        if (this.project == null) {
            this.lblProjectName.setText("");
            return;
        }
        this.lblProjectName.setText(this.project.getName() + " - " + this.project.getAuthor());
    }

    public void refreshWorkspace(MapNodeComposite selectedNode){
        this.tabbedPane.removeAll();

        if (this.project == null || this.project.getChildren().size() == 0) {
            this.tabbedPane.setVisible(false);
            return;
        }

        for (MapNode map : this.project.getChildren()) {
            map.getSubscribers().clear();
            MapView view = new MapView((MindMap)map, this.tabbedPane.getTabCount());
            map.addSubs(view);
            this.tabbedPane.addTab(map.getName(), view);
        }
        this.tabbedPane.setVisible(true);
    }

    public void mousePressed(MouseEvent e) {
        MapTreeView map = MainFrame.getInstance().getProjectExplorer();
        int selRow = map.getRowForLocation(e.getX(), e.getY());

        if(selRow != -1 && e.getClickCount() == 2){
            MapTreeItem selectedWrapper = (MapTreeItem) map.getLastSelectedPathComponent();
            MapNode selectedNode = selectedWrapper.getMapNode();

            Workspace workspace = MainFrame.getInstance().getWorkspace();
            if(workspace instanceof WorkspaceImplemetation && selectedNode instanceof Project){
                ((WorkspaceImplemetation) workspace).getProjectView().refreshWorkspace((MapNodeComposite) selectedNode);
            }

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
        }
    }

    @Override
    public void update(Object object) {
        if (!(object instanceof MapTreeAction)) return;
        MapTreeAction action = (MapTreeAction) object;
        MapTreeActionType actionType = action.getActionType();
        if (actionType == MapTreeActionType.SELECT_PROJECT) {
            Project newProject = (Project) action.getState();
            this.setProject(newProject);
        }
        else if (actionType == MapTreeActionType.DELETE_PROJECT) {
            this.setProject(null);
        }
        else if (actionType == MapTreeActionType.NEW_MAP || actionType == MapTreeActionType.DELETE_MAP) {
            MindMap newMap = (MindMap) action.getState();
            Project newProject = (Project) newMap.getParent();
            this.setProject(newProject);
        }

        else if (actionType == MapTreeActionType.RENAME_PROJECT || actionType == MapTreeActionType.RENAME_AUTHOR) {
            this.project = (Project) action.getState();
            this.updateLabel();
        }
    }
}
