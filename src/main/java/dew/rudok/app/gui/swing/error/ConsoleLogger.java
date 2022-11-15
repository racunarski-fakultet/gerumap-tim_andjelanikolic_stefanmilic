package dew.rudok.app.gui.swing.error;

import dew.rudok.app.core.ErrorLogger;
import dew.rudok.app.gui.swing.message.Message;
import dew.rudok.app.gui.swing.message.MessageType;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
public class ConsoleLogger implements ErrorLogger {

    @Override
    public void log(Message message) {
        MessageType et = message.getType();
        String content = message.getContent();
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        String d = dateFormat.format(date);
        int hour = date.getHours();
        int min = date.getMinutes();
        System.out.println("[" + et.toString() + "] [" + d + "] [" + hour + ":" + min + "]" + message.getContent());
    }
}
