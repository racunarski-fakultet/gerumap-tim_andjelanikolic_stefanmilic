package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State state;
    private ConnectionState connectionState;
    private SelectState selectState;
    private TopicState topicState;
    private DeleteState deleteState;
    private MoveState moveState;
    private ZoomState zoomState;
    private EditState editState;

    /*public StateManager(State state, AddConnectionState addConnectionState, AddState addState, DeleteState deleteState, MoveState moveState, ZoomState zoomState, SelectState selectState) {
        this.state = state;
        this.addConnectionState = addConnectionState;
        this.addState = addState;
        this.deleteState = deleteState;
        this.moveState = moveState;
        this.zoomState = zoomState;
        this.selectState = selectState;

    }*/

    public StateManager () {
         initialise();
    }

    public void initialise () {
        topicState = new TopicState();
        connectionState = new ConnectionState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        zoomState = new ZoomState();
        selectState = new SelectState();
//        editState = new EditState();
        state = selectState;
    }

    public State getState () {
        return state;
    }

    public void setTopicState() {
        state = topicState;
    }

    public void setConnectionState() {
        state = connectionState;
    }

    public void setDeleteState() {
        state = deleteState;
    }

    public void setMoveState() {
        state = moveState;
    }

//    public void setEditState() {
//        state = editState;
//    }
    public void setSelectionState() {
        state = selectState;
    }

    public void setZoomState() {
        state= zoomState;
    }
}
