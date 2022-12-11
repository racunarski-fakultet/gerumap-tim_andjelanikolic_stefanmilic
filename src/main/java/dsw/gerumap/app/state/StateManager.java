package dsw.gerumap.app.state;

import dsw.gerumap.app.state.model.*;

public class StateManager {

    private State state;
    private AddConnectionState addConnectionState;

    private SelectState selectState;
    private AddState addState;
    private DeleteState deleteState;
    private MoveState moveState;
    private ZoomState zoomState;
    private SettingsState settingState;

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
        addState = new AddState();
        addConnectionState = new AddConnectionState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        zoomState = new ZoomState();
        selectState = new SelectState();
        settingState = new SettingsState();
        state = selectState;
    }

    public State getState () {
        return state;
    }

    public void setAddState () {
        state = addState;
    }

    public void setAddConnectionState() {
        state = addConnectionState;
    }

    public void setDeleteState() {
        state = deleteState;
    }

    public void setMoveState() {
        state = moveState;
    }

    public void setSettingState() {
        state = settingState;
    }

    public void setSelectionState() {
        state = selectState;
    }

    public void setZoomState() {
        state= zoomState;
    }
}
