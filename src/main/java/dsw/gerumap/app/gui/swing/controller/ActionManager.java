package dsw.gerumap.app.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private DeleteAction deleteAction;
    private InfoAction infoAction;
    private AuthorAction authorAction;


    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
    }


}
