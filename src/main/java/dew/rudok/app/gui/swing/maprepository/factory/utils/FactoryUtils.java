package dew.rudok.app.gui.swing.maprepository.factory.utils;

import dew.rudok.app.gui.swing.maprepository.NodeFactory;
import dew.rudok.app.gui.swing.maprepository.composite.MapNode;
import dew.rudok.app.gui.swing.maprepository.factory.ElementFactory;
import dew.rudok.app.gui.swing.maprepository.factory.MindMapFactory;
import dew.rudok.app.gui.swing.maprepository.factory.ProjectFactory;
import dew.rudok.app.gui.swing.maprepository.implementation.Element;
import dew.rudok.app.gui.swing.maprepository.implementation.MindMap;
import dew.rudok.app.gui.swing.maprepository.implementation.Project;
import dew.rudok.app.gui.swing.maprepository.implementation.ProjectExplorer;
import lombok.NoArgsConstructor;

public class FactoryUtils {

    public static NodeFactory getNodeFactory(MapNode parent) {

        if(parent instanceof ProjectExplorer){
            return new ProjectFactory();
        }else if(parent instanceof Project){
            return new MindMapFactory();
        }else if(parent instanceof MindMap){
            return new ElementFactory();
        }

        return null;
    }
}
