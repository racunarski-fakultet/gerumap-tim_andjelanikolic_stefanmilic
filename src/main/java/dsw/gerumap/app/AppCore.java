package dsw.gerumap.app;

import dsw.gerumap.app.core.*;
import dsw.gerumap.app.gui.swing.SwingGui;
import dsw.gerumap.app.gui.swing.error.ConsoleLogger;
import dsw.gerumap.app.gui.swing.error.FileLogger;
import dsw.gerumap.app.gui.swing.maprepository.MapRepositoryImplemetation;
import dsw.gerumap.app.gui.swing.message.MessageGeneratorImplemetation;

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


        appCore.initialise(gui, mapRepository, messageGenerator);
        appCore.run();
    }


}