package dew.rudok.app.gui.swing.workspace.view;

import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.composite.MapNodeComposite;
import dew.rudok.app.gui.swing.maprepository.implementation.MindMap;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import dew.rudok.app.gui.swing.tree.model.MapTreeItem;
import dew.rudok.app.gui.swing.tree.view.MapTreeView;
import dew.rudok.app.gui.swing.view.MainFrame;
import dew.rudok.app.gui.swing.workspace.Workspace;
import dew.rudok.app.gui.swing.workspace.WorkspaceImplemetation;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class ProjectView extends JPanel{

    String projectName;
    String author;
    JTabbedPane tabbedPane;
    MapNode project;
    List<MapView> tabs;

    JLabel lblProjectName;
    JLabel lblAuthor;

    public ProjectView(){
        author = String.valueOf(lblAuthor);
        projectName = String.valueOf(lblProjectName);
    }

    public void refreshWorkspace(MapNodeComposite selectedProject){
        tabs.clear();
        tabbedPane.removeAll();

        for (MapNode child: selectedProject.getChildren()) {
            MapView tab1 = new MapView((MindMap)child);
            tabs.add(tab1);
        }

        for(MapView tab : tabs)
            tabbedPane.addTab(tab.getMindMap().toString(), tab);

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

}
