package dsw.gerumap.app.gui.swing.maprepository.composite;

import dsw.gerumap.app.observer.Publisher;
import dsw.gerumap.app.observer.Subscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract  class MapNode implements Publisher {

    private String name;
    private List<Subscriber> subscribers;
    @ToString.Exclude
    private MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

}