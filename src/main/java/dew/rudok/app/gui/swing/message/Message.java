package dew.rudok.app.gui.swing.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    String content;
    MessageType type;

    public Message(String content, MessageType type) {
        this.content = content;
        this.type = type;
    }


}
