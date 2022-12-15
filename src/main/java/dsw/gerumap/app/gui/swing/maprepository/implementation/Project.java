package dsw.gerumap.app.gui.swing.maprepository.implementation;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.composite.MapNodeComposite;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;

@Getter
public class Project extends MapNodeComposite {

    String author;

    public Project(String name, MapNode parent) {
        super(name, parent);
    }

    public Project(String name, MapNode parent, String author) {
        super(name, parent);
        this.author = author;
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().add(mindMap);
        }
    }

    @Override
    public void removeChild(MapNode child) {
        if (child != null && child instanceof MindMap) {
            MindMap mindMap = (MindMap) child;
            this.getChildren().remove(mindMap);
        }
    }

//    @Override
//    public void addSubs(Subscriber subscriber) {
//        if(subscriber == null)
//            return;
//        if(this.subscribers ==null)
//            this.subscribers = new ArrayList<>();
//        if(this.subscribers.contains(subscriber))
//            return;
//        this.subscribers.add(subscriber);
//    }
//
//    @Override
//    public void removeSubs(Subscriber subscriber) {
//        if(subscriber == null || this.subscribers == null || !this.subscribers.contains(subscriber))
//            return;
//        this.subscribers.remove(subscriber);
//    }
//
//    @Override
//    public void notify(Object notification) throws IOException {
//        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
//            return;
//
//        for(Subscriber sub : subscribers){
//            sub.update(notification);
//        }
//    }

    public void setAuthor(String author) throws IOException {
        this.author = author;
    }
}
