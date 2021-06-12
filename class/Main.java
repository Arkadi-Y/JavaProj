import Server.myDATA;
import windows.MainWindow;

import javax.swing.*;


public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException e) {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        myDATA data=new myDATA();
        new MainWindow(data);
    }
}
