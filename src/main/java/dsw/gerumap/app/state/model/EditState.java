package dsw.gerumap.app.state.model;

import dsw.gerumap.app.gui.swing.maprepository.implementation.Element;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.workspace.MapView;
import dsw.gerumap.app.state.State;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.ColorSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EditState extends JDialog{

    JButton btnColor;
    JButton btnStroke;
    JButton btnName;

    public EditState(Frame owner, String title, boolean modal) throws IOException {
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

        mainPanel.add(btnColor);
        mainPanel.add(btnStroke);
        mainPanel.add(btnName);

        btnColor.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
            MapView map = MainFrame.getInstance().getProjectView().getTabs().get(0);
            for(Element element : map.getSelectionModel().getSelected()){
                try {
                    element.setColor(newColor);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnStroke.addActionListener(e -> {
            int stroke = Integer.parseInt(JOptionPane.showInputDialog(MainFrame.getInstance(), "Input new stroke"));
        });

        btnName.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(MainFrame.getInstance(), "Input your name");
        });

        add(mainPanel);
    }

}
