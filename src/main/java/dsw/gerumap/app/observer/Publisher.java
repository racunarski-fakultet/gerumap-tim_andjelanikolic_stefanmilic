package dsw.gerumap.app.observer;

import java.io.IOException;

public interface Publisher {

    public void addSubs(Subscriber subscriber);
    public void removeSubs(Subscriber subscriber);
    public void notify(Object notification) throws IOException;

}
