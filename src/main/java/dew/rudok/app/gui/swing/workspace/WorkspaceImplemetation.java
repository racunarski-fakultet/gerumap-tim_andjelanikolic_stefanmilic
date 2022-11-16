package dew.rudok.app.gui.swing.workspace;

import dew.rudok.app.gui.swing.workspace.view.ProjectView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkspaceImplemetation implements Workspace{

    ProjectView projectView;

    @Override
    public ProjectView generateWorkspace() {
        this.projectView = projectView;
        return projectView;
    }
}
