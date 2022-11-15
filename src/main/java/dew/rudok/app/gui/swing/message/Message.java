package dew.rudok.app.gui.swing.message;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    String content;
    EventType type;

    public Message(String content, EventType type) {
        this.content = content;
        this.type = type;
    }


}
