//package dsw.gerumap.app.gui.swing.maprepository.factory;
//
//import dsw.gerumap.app.gui.swing.maprepository.NodeFactory;
//import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
//import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
//import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
//import dsw.gerumap.app.observer.Subscriber;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//public class ElementFactory  extends NodeFactory {
//    @Override
//    public MapNode createNode(MapNode node) {
//        return new Element("Element" + ((MindMap) node).getChildren().size(), node);
//    }
//
//    @Override
//    public void addSubs(Subscriber subscriber) {
//
//    }
//
//    @Override
//    public void removeSubs(Subscriber subscriber) {
//
//    }
//
//    @Override
//    public void notify(Object notification) {
//
//    }
//}
