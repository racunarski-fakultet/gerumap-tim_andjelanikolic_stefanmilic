package dew.rudok.app.gui.swing.error;

import dew.rudok.app.gui.swing.message.Message;
import jdk.jfr.EventType;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ErrorDialog extends JDialog {

    private JLabel labelMessage;
    private JPanel panel;
    private EventType eventType;
    private  Message message;


    public ErrorDialog (Frame owner, String title, boolean modal, EventType eventType, Message message) {
        super(owner, title, modal);
        this.eventType = eventType;
        this.message = message;

        initialise();

    }

    public void initialise() {
        labelMessage = new JLabel(message.getContent());
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.add(labelMessage);

        this.add(panel);
        panel.setVisible(true);
    }


}
