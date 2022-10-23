package dew.rudok.app.core;

//@Setter
//@NoArgsContstructor
public abstract class ApplicationFramework {

    protected Gui gui;

    public abstract void run ();

    public void initialise (Gui gui) {
        this.gui = gui;
    }

}
