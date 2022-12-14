package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.state.controller.*;
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

    private ConnectionStateAction addConnectionStateController;
    private TopicStateAction addStateController;
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateController;
    private SelectStateAction selectStateContoller;
    private ZoomStateAction zoomStateController;
    private EditStateAction editStateAction;



    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
        addConnectionStateController = new ConnectionStateAction();
        addStateController = new TopicStateAction();
        moveStateController = new MoveStateAction();
        selectStateContoller = new SelectStateAction();
        zoomStateController = new ZoomStateAction();
        deleteStateAction = new DeleteStateAction();
        editStateAction = new EditStateAction();
    }


}
