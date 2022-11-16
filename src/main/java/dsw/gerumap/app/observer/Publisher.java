package dsw.gerumap.app.observer;

public interface Publisher {

    public void addSubs(Subscriber subscriber);
    public void removeSubs(Subscriber subscriber);
    public void notify(Object notification);

}
