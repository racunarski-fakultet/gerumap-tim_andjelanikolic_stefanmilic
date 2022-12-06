package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State state;
    private AddConnectionState addConnectionState;
    private AddState addState;
    private DeleteState deleteState;
    private MoveState moveState;
    private ZoomState zoomState;

    public StateManager(State state, AddConnectionState addConnectionState, AddState addState, DeleteState deleteState, MoveState moveState, ZoomState zoomState) {
        this.state = state;
        this.addConnectionState = addConnectionState;
        this.addState = addState;
        this.deleteState = deleteState;
        this.moveState = moveState;
        this.zoomState = zoomState;

    }


}
