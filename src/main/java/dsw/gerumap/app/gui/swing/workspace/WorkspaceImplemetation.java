package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.workspace.view.ProjectView;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkspaceImplemetation implements Workspace{

    ProjectView projectView;

    @Override
    public ProjectView generateWorkspace() {
        this.projectView = projectView;
        System.out.println("view");
        return projectView;
    }
}
