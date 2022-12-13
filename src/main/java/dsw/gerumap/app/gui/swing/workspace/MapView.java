package dsw.gerumap.app.gui.swing.workspace;

import dsw.gerumap.app.gui.swing.maprepository.composite.MapNode;
import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.workspace.panel.painters.ElementPainter;
import dsw.gerumap.app.observer.Subscriber;
import dsw.gerumap.app.gui.swing.maprepository.implementation.MindMap;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MapView extends JPanel implements Subscriber{
    private MindMap mindMap;
    private JLabel label;
    private int index;
    private List<ElementPainter> painters;

    public MapView(MindMap map, int index) {
        setLayout(new FlowLayout());
        label = new JLabel("");
        this.index = index;
        add(label);
        setMap(map);
        painters = new ArrayList<>();
        addMouseListener(new MouseController(this));
    }

    public void setMap(MindMap mindMap) {
        this.mindMap = mindMap;
        this.updateLabel();
        this.updateTabName();
        this.mindMap.addSubs(this);
    }

    public void updateLabel() {
        this.label.setText(this.mindMap.getName());
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
        updateLabel();
        repaint();
        System.out.println("update");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(ElementPainter p : painters){
            for(MapNode el : mindMap.getChildren()){
                p.draw(g, (Element) el);
            }
        }
        System.out.println("paint");
    }

    @Override
    public String toString() {
        return mindMap.getName();
    }
}
