package dew.rudok.app;

import dew.rudok.app.core.*;
import dew.rudok.app.gui.swing.SwingGui;
import dew.rudok.app.gui.swing.error.ConsoleLogger;
import dew.rudok.app.gui.swing.error.FileLogger;
import dew.rudok.app.gui.swing.maprepository.MapRepositoryImplemetation;
import dew.rudok.app.gui.swing.message.MessageGeneratorImplemetation;

public class AppCore  {


    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();

        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImplemetation();
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger();

        MessageGenerator messageGenerator = new MessageGeneratorImplemetation();
        messageGenerator.addSubs(gui);
        messageGenerator.addSubs(consoleLogger);
        messageGenerator.addSubs(fileLogger);


        appCore.initialise(gui, mapRepository, consoleLogger, messageGenerator, fileLogger);
        appCore.run();
    }


}
