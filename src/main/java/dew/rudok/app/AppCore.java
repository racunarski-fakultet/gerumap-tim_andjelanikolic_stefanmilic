package dew.rudok.app;

import dew.rudok.app.core.*;
import dew.rudok.app.gui.swing.SwingGui;
import dew.rudok.app.gui.swing.error.ErrorLoggerImplemetation;
import dew.rudok.app.gui.swing.maprepository.MapRepositoryImplemetation;
import dew.rudok.app.gui.swing.message.MessageGeneratorImplemetation;

public class AppCore  {


    public static void main(String[] args) {
        ApplicationFramework appCore = ApplicationFramework.getInstance();
        Gui gui = new SwingGui();
        MapRepository mapRepository = new MapRepositoryImplemetation();
        Logger errorLogger = new ErrorLoggerImplemetation();
        MessageGenerator messageGenerator = new MessageGeneratorImplemetation();
        //messageGenerator.addSubs((Subscriber) gui);


        appCore.initialise(gui, mapRepository, errorLogger, messageGenerator);
        appCore.run();
    }


}
