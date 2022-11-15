package dew.rudok.app.gui.swing.error;

import dew.rudok.app.core.ErrorLogger;
import dew.rudok.app.gui.swing.message.Message;
import lombok.NoArgsConstructor;

import java.io.File;

@NoArgsConstructor
public class FileLogger implements ErrorLogger {

    File f;

    @Override
    public void log(Message message) {

    }
}
