package dsw.gerumap.app.gui.swing.error;

import dsw.gerumap.app.core.Logger;
import dsw.gerumap.app.gui.swing.message.Message;
import lombok.NoArgsConstructor;

import java.io.*;

@NoArgsConstructor
public class FileLogger implements Logger {

    String text;

    @Override
    public void log(Message m) throws IOException {
        text = m.getContent();
        writeInFile();
    }

    public void writeInFile() throws IOException{
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/log.txt"), "UTF-8"))){
            writer.write(text);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
