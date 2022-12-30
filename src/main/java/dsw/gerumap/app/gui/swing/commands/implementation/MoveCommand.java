package dsw.gerumap.app.gui.swing.commands.implementation;

import dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.gui.swing.workspace.panel.Connection;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ConnectionPainter;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;

import java.awt.*;
import java.io.IOException;

public class MoveCommand extends AbstractCommand {

    private MapView map;
    private int x;
    private int y;
    private int xPrvo;
    private int yPrvo;

    public MoveCommand(MapView map, int x, int y, int xPrvo, int yPrvo) {
        this.map = map;
        this.x = x;
        this.y = y;
        this.xPrvo = xPrvo;
        this.yPrvo = yPrvo;
    }

    @Override
    public void doCommand() throws IOException {

    }

    @Override
    public void undoCommand() throws IOException {

    }
}
