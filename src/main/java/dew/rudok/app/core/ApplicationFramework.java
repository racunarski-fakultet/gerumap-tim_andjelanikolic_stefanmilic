package dew.rudok.app.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected Logger errorLogger;
    protected MessageGenerator messageGenerator;
    private static ApplicationFramework instance;
    private ApplicationFramework() {

    }

    public void run (){this.gui.start();};

    public void initialise (Gui gui, MapRepository mapRepository, Logger errorLogger, MessageGenerator messageGenerator) {
        this.gui = gui;
        this.mapRepository= mapRepository;
        this.errorLogger = errorLogger;
        this.messageGenerator = messageGenerator;
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }


}
