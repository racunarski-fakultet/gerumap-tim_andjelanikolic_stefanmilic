package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.commands.CommandManager;
import dsw.gerumap.app.observer.Subscriber;

public interface Gui extends Subscriber {

    public void start();

    public void disableUndoAction();
    public void disableRedoAction();
    public void enableUndoAction();
    public void enableRedoAction();

    CommandManager getCommandManager();


}
