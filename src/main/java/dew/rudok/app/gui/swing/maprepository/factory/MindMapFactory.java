package dew.rudok.app.gui.swing.maprepository.factory;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.implementation.MindMap;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MindMapFactory extends NodeFactory {

    @Override
    public MapNode createNode(MapNode node) {
        return new MindMap("MindMap" + ((Project) node).getChildren().size(), node);
    }
}
