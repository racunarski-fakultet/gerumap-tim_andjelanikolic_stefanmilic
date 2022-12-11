package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.state.controller.*;
import dsw.gerumap.app.state.model.AddConnectionState;
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

    private AddConnectionStateController addConnectionStateController;
    private AddStateController addStateController;
    private DeleteStateController deleteStateAction;
    private MoveStateController moveStateController;
    private SelectStateContoller selectStateContoller;
    private ZoomStateController zoomStateController;



    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
        addConnectionStateController = new AddConnectionStateController();
        addStateController = new AddStateController();
        moveStateController = new MoveStateController();
        selectStateContoller = new SelectStateContoller();
        zoomStateController = new ZoomStateController();
        deleteStateAction = new DeleteStateController();
    }


}
