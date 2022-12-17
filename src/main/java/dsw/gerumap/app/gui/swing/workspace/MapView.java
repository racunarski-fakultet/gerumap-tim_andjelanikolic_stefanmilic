package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.workspace.panel.Topic;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class MapView extends JPanel implements Subscriber{
    private MindMap mindMap;
    private int index;
    private List<ElementPainter> painters;
    private MapSelectionModel selectionModel;
    private JScrollBar vertical;
    private JScrollBar horizontal;
    double translateX = 0;
    double translateY = 0;
    double scalingf = 1;
    private AffineTransform transformation = new AffineTransform();

    public MapView(MindMap map, int index) {
        setLayout(new BorderLayout());

        horizontal = new JScrollBar(0);
        vertical = new JScrollBar(1);
        add(horizontal, BorderLayout.SOUTH);
        add(vertical, BorderLayout.EAST);

        this.index = index;
        selectionModel = new MapSelectionModel();
        painters = new ArrayList<>();

        addMouseListener(new MouseController(this));
        addMouseMotionListener(new MouseController(this));

        setMap(map);
    }

    public void setMap(MindMap mindMap) {
        this.mindMap = mindMap;
        this.updateTabName();
//        this.mindMap.addSubs(this);
//        System.out.println(this.mindMap.getSubscribers().toString());
    }

    public void updateTabName() {
        JTabbedPane tabbedPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, this);
        if (tabbedPane == null) return;
        tabbedPane.setTitleAt(index, mindMap.getName());
    }

    @Override
    public void update(Object object) {
        if(mindMap == null){
            return;
        }

        repaint();
        System.out.println("update");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setTransform(transformation);

//        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        for(ElementPainter p : painters){
            p.draw(g2d);
        }
        System.out.println("paint");
        System.out.println(this.mindMap.getSubscribers().toString());
    }

//    public Element findElement(int x, int y){
//        for(ElementPainter p : getPainters()){
//            Topic t = (Topic) p.getElement();
//            if(t.getX() == x && t.getY() == y)
//                return p.getElement();
//        }
//        return null;
//    }

    private void setUpTransformation(){
        transformation.setToScale(scalingf,scalingf);
        transformation.translate(translateX,translateY);
        repaint();
    }

    public void zoomIn(){
        scalingf *= 1.2;
        if(scalingf > 3) scalingf = 3;
        setUpTransformation();

    }
    public void zoomOut(){
        scalingf *= 0.8;
        if(scalingf < 0.4) scalingf = 0.4;
        setUpTransformation();
    }

    @Override
    public String toString() {
        return mindMap.getName();
    }
}
