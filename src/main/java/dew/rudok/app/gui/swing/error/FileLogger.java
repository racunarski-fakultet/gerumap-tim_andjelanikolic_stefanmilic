package dew.rudok.app.gui.swing.error;

import dew.rudok.app.core.Logger;
import dew.rudok.app.gui.swing.message.Message;
import lombok.NoArgsConstructor;

import java.io.File;

@NoArgsConstructor
public class FileLogger implements Logger {

    File f;

    @Override
    public void log(Message message) {

    }
}
