package FileClasses;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

public class fileReader {
    public static void saveToFile(String text,String path,String name) throws IOException {
        String savePath;
        Calendar time = Calendar.getInstance();
        if (!path.contains(".txt")){
            savePath=System.getProperty("user.home") + "/Desktop/SV-"+name+".txt";
        }
        else {
            savePath=path;
        }
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
            System.out.println("file not found - trying to create one");
            if (createFile(savePath))
                saveToFile(text,path,name);
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
                e.printStackTrace();
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

