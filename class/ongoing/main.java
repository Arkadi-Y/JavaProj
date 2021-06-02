package ongoing;

import Server.myDATA;
import windows.MainWindow;
import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, URISyntaxException, SQLException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException e) {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        myDATA data = new myDATA();
        new MainWindow(data);
    }
}
