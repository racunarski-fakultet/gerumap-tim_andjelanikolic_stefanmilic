package dew.rudok.app.gui.swing.tree.view;

import dew.rudok.app.gui.swing.maprepository.implementation.MindMap;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;
import dew.rudok.app.gui.swing.tree.model.MapTreeItem;
import lombok.NoArgsConstructor;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

@NoArgsConstructor
public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        URL imageURL = null;

        if (((MapTreeItem)value).getMapNode() instanceof ProjectExplorer) {
            imageURL = getClass().getResource("/images/projectExplorer.jpg");
        }
        else if (((MapTreeItem)value).getMapNode() instanceof Project) {
            imageURL = getClass().getResource("/images/tproject.gif");
        }
        else if(((MapTreeItem)value).getMapNode() instanceof MindMap){
          imageURL = getClass().getResource("/images/mindmap.jpg");
        }

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);

        return this;
    }
}
