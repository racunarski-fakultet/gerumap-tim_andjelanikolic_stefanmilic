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

    private ConnectionStateAction connectionStateAction;
    private TopicStateAction topicStateAction;
    private MoveStateAction moveStateAction;
    private SelectStateAction selectStateAction;
    private DeleteElementsAction deleteElementsAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private EditAction editAction;




    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        deleteAction = new DeleteAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
        connectionStateAction = new ConnectionStateAction();
        topicStateAction = new TopicStateAction();
        moveStateAction = new MoveStateAction();
        selectStateAction = new SelectStateAction();
        zoomInAction = new ZoomInAction();
        zoomOutAction = new ZoomOutAction();
        deleteElementsAction = new DeleteElementsAction();
        editAction = new EditAction();
    }


}
