package dsw.gerumap.app.gui.swing.controller;


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
    private RenameAction renameAction;
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
        renameAction = new RenameAction();
        authorAction = new AuthorAction();
    }


}
