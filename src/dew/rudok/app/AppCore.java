package dew.rudok.app;

import dew.rudok.app.core.ApplicationFramework;

public class AppCore extends ApplicationFramework {

    public static AppCore instance = null;

    private AppCore () {

    }

    @Override
    public void run() {

    }

    public static AppCore getInstance() {
        if (instance == null) {
            instance = new AppCore();
            instance.run();
        }
        return instance;
    }
}
