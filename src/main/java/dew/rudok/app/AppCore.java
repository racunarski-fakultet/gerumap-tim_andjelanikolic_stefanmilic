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
        ErrorLogger errorLogger = new ErrorLoggerImplemetation();
        MessageGenerator messageGenerator = new MessageGeneratorImplemetation();

        appCore.initialise(gui, mapRepository, errorLogger, messageGenerator);
        appCore.run();
    }


}
