package dew.rudok.app.core;

import dew.rudok.app.gui.swing.message.MessageGeneratorImplemetation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Setter
@Getter
public class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected Logger consoleLogger;
    protected Logger fileLogger;
    protected MessageGenerator messageGenerator;
    private static ApplicationFramework instance;
    private ApplicationFramework() {

    }

    public void run (){this.gui.start();};

    public void initialise (Gui gui, MapRepository mapRepository, Logger consoleLogger, MessageGenerator messageGenerator, Logger fileLogger) {
        this.gui = gui;
        this.mapRepository= mapRepository;
        this.consoleLogger = consoleLogger;
        this.messageGenerator = messageGenerator;
        this.fileLogger = fileLogger;
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }


}
