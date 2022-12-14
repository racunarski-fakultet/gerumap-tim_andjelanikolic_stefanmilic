package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
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
    private Point pos1 = null;
    private Point pos2 = null;
    private JScrollBar vertical;
    private JScrollBar horizontal;

    public MapView(MindMap map, int index) {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

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
        this.mindMap.addSubs(this);
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
//        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        for(ElementPainter p : painters){
            p.draw(g2d);
        }
        System.out.println("paint");
    }

    public void setPos1(Point pos1) {
        this.pos1 = pos1;
        update(pos1);
    }

    public void setPos2(Point pos2) {
        this.pos2 = pos2;
        update(pos2);
    }

    public void setElementColor(Element element, Color color) throws IOException {
        for(MapNode mn : mindMap.getChildren()){
            Element el = (Element) mn;
            if(el.equals(element)){
                el.setColor(color);
                update(element);
            }
        }
    }

    @Override
    public String toString() {
        return mindMap.getName();
    }
}
