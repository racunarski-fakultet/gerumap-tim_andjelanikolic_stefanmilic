package dew.rudok.app.gui.swing.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    String content;
    EventType type;

    public Message(String content, EventType type) {
        this.content = content;
        this.type = type;

        initialise();
    }

    private void initialise(){
        JOptionPane.showMessageDialog(new JFrame(), this, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String toString() {
        return content;
    }
}
