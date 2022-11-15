package dew.rudok.app.gui.swing.view;

import dew.rudok.app.core.ApplicationFramework;
import dew.rudok.app.core.Subscriber;
import dew.rudok.app.gui.swing.controller.ActionManager;
import dew.rudok.app.gui.swing.tree.MapTree;
import dew.rudok.app.gui.swing.tree.MapTreeImplementation;
import dew.rudok.app.gui.swing.tree.view.MapTreeView;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class MainFrame extends JFrame implements Subscriber {

    private static MainFrame instance;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;

    private MapTree mapTree;
    private MapTreeView projectExplorer;

    private  MainFrame () {

    }

    private void initialise () {

        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());
        initialiseGui(projectExplorer);

    }

    private void initialiseGui(MapTreeView projectExplorer) {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        JPanel desktop = new JPanel();

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(split, BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);
    }

    public static MainFrame getInstance() {

        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    @Override
    public void update(Object object) {

    }
}
