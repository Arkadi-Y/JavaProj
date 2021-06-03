package FileClasses;

import windows.ErrorWindow;

import java.io.*;
import java.util.Scanner;

public class fileReader {
    public static void saveToFile(String text,String name) throws IOException {
        String savePath=System.getProperty("user.home") + "/Desktop/SV-"+name+".txt";
        try
        {
            File file = new File(savePath);
            PrintWriter writer= new PrintWriter(file);
            Scanner scanner = new Scanner(text);
            String currentLine = "";
            while (scanner.hasNext()){
                currentLine = scanner.nextLine();
                writer.println(currentLine);
            }
            scanner.close();
            writer.close();

        } catch (FileNotFoundException e) {
            new ErrorWindow(e);
            if (createFile(savePath))
                saveToFile(text,name);
        }
    }

    public static String loadFromFile(String filename){
            String result = "";
            try {
                File openFile = new File(filename);
                Scanner fileScanner = new Scanner(openFile);
                String currentLine = fileScanner.nextLine();
                while (fileScanner.hasNextLine()){
                    result+=currentLine+"\n";
                    currentLine=fileScanner.nextLine();
                }
                result+=currentLine+"\n";
                fileScanner.close();
            } catch (FileNotFoundException e) {
                    new ErrorWindow(e);
            }
            return result;
    }
    public static boolean createFile(String path) throws IOException {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("file created at" + file.getAbsolutePath());
                return true;
            }
            else
                return false;

        }
}

