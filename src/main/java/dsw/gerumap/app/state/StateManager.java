package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;
import dsw.gerumap.app.state.view.EditView;

public class StateManager {

    private State state;
    private ConnectionState connectionState;
    private SelectState selectState;
    private TopicState topicState;
    private DeleteState deleteState;
    private MoveState moveState;
    private ZoomState zoomState;

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
    public void setSelectionState() {
        state = selectState;
    }
    public void setZoomState() {
        state= zoomState;
    }
}
