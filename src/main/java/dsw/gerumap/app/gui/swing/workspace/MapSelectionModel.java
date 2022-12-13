package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.observer.Publisher;
import dsw.gerumap.app.observer.Subscriber;

import java.io.IOException;
import java.util.List;

public class MapSelectionModel implements Publisher {

    private List<Element> selected;

    @Override
    public void addSubs(Subscriber subscriber) {

    }

    @Override
    public void removeSubs(Subscriber subscriber) {

    }

    @Override
    public void notify(Object notification) throws IOException {

    }
}
