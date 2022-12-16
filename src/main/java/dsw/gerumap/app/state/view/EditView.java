package dsw.gerumap.app.state.view;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.MapView;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

public class EditView extends JDialog{

    JButton btnColor;
    JButton btnStroke;
    JButton btnName;
    JButton btnExit;

    public EditView(Frame owner, String title, boolean modal) throws IOException {
        super(owner, title, modal);

        initialise();

        setSize(400, 200);
        setLocationRelativeTo(owner);
    }

    private void initialise(){
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));

        mainPanel.setBorder(new TitledBorder(new EtchedBorder(), "Edit"));

        btnColor = new JButton("Set color");
        btnStroke = new JButton("Set stroke");
        btnName = new JButton("Set name");
        btnExit = new JButton("Exit");

        mainPanel.add(btnColor);
        mainPanel.add(btnStroke);
        mainPanel.add(btnName);
        mainPanel.add(btnExit);

        btnColor.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);

            for(MapView map : MainFrame.getInstance().getProjectView().getTabs()){
                for(Element element : map.getSelectionModel().getSelected()){
                    try {
                        element.setColor(newColor);
                        map.getSelectionModel().setOldColor(newColor);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        btnStroke.addActionListener(e -> {
            int stroke = Integer.parseInt(JOptionPane.showInputDialog(MainFrame.getInstance(), "Input new stroke"));

            for(MapView map : MainFrame.getInstance().getProjectView().getTabs()) {
                for (Element element : map.getSelectionModel().getSelected()) {
                    try {
                        element.setStroke(stroke);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        btnName.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(MainFrame.getInstance(), "Input your name");

            for(MapView map : MainFrame.getInstance().getProjectView().getTabs()) {
                for (Element element : map.getSelectionModel().getSelected()) {
                    try {
                        element.setName(name);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        add(mainPanel);
    }

}
