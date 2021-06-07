package windows;

import FileClasses.fileReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getFileWindow {
    JFileChooser fileChooser;
    public getFileWindow(String name) throws IOException {
        fileChooser = new JFileChooser();
        //look only for text files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION){
            fileReader reader = new fileReader();
            String text = reader.loadFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            fileReader.saveToFile(text," "+name+" cv "+timeStamp);
        }
    }

}
