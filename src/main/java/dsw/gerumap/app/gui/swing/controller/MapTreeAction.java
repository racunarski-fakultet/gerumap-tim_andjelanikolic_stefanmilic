package dsw.gerumap.app.gui.swing.controller;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MapTreeAction {

    private final MapTreeActionType actionType;
    private final Object state;

    public MapTreeAction(MapTreeActionType actionType, Object state) {
        this.actionType = actionType;
        this.state = state;
    }

}
