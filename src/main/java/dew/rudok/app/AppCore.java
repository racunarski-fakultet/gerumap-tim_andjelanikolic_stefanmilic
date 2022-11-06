package dew.rudok.app;

import dew.rudok.app.core.ApplicationFramework;
import dew.rudok.app.core.Gui;
import dew.rudok.app.core.MapRepository;
import dew.rudok.app.gui.swing.SwingGui;
import dew.rudok.app.gui.swing.maprepository.MapRepositoryImpl;

public class AppCore  {


    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImpl();
        appCore.initialise(gui, mapRepository);
        appCore.run();
    }


}
