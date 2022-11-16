package dew.rudok.app.gui.swing.error;

import dew.rudok.app.core.Logger;
import dew.rudok.app.gui.swing.message.Message;
import lombok.NoArgsConstructor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@NoArgsConstructor
public class FileLogger implements Logger {

    File file;

    @Override
    public void log(Message message) {

        file =  new File("/resources");

        String str = message.toString();
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
