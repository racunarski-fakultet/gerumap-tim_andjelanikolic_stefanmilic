package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State state;
    private ConnectionState connectionState;
    private SelectState selectState;
    private TopicState topicState;
    private MoveState moveState;

    public StateManager () {
         initialise();
    }

    public void initialise () {
        topicState = new TopicState();
        connectionState = new ConnectionState();
        moveState = new MoveState();
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
    public void setMoveState() {
        state = moveState;
    }
    public void setSelectionState() {
        state = selectState;
    }
}
