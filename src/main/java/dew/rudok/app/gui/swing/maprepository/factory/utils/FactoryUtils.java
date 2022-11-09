package dew.rudok.app.gui.swing.maprepository.factory.utils;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.factory.ElementFactory;
import dew.rudok.app.gui.swing.maprepository.implementation.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FactoryUtils {
    
    private NodeFactory nodeFactory;

    public NodeFactory getNodeFactory() {
        return nodeFactory;
    }
}
