package windows;

import FileClasses.fileReader;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

public class getFileWindow {
    JFileChooser fileChooser;
    public getFileWindow() throws IOException {
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION){
            fileReader reader = new fileReader();
            String text = reader.loadFromFile(fileChooser.getSelectedFile().getAbsolutePath());
            fileReader.saveToFile(text,"path","dibi");
        }
    }

}
