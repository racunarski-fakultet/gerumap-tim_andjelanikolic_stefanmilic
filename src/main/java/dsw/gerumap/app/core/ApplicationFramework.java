package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.workspace.Workspace;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationFramework {

    protected Gui gui;
    protected MapRepository mapRepository;
    protected MessageGenerator messageGenerator;
    protected Workspace workspace;
    private static ApplicationFramework instance;
    private ApplicationFramework() {

    }

    public void run (){this.gui.start();};

    public void initialise (Gui gui, MapRepository mapRepository, MessageGenerator messageGenerator, Workspace workspace) {
        this.gui = gui;
        this.mapRepository= mapRepository;
        this.messageGenerator = messageGenerator;
        this.workspace = workspace;
    }

    public static ApplicationFramework getInstance(){
        if(instance==null){
            instance = new ApplicationFramework();
        }
        return instance;
    }


}
