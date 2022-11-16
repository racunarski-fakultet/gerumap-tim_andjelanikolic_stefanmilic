package dew.rudok.app.gui.swing.controller;


import dew.rudok.app.gui.swing.tree.controller.MapTreeCellEditor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private DeleteAction deleteAction;
    private ErrorAction errorAction;
    private InfoAction infoAction;
    private AuthorAction authorAction;


    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteAction = new DeleteAction();
        errorAction = new ErrorAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
    }


}
