package windows;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class ErrorWindow {
    private int response;

    public ErrorWindow(IOException e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, e.getMessage(), "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (response == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
    public ErrorWindow(SQLException e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, "Seems we cannot find the server, \nplease check your internet connection and try again\nif all fails contact the devs for info\n error:"+ e.getMessage(), "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
       // JOptionPane.showConfirmDialog(null,"Seems we cannot find the server, \nplease check your internet connection and try again\nif all fails contact the devs for info\n error:"+ e.getMessage(), "Warning",JOptionPane.OK_OPTION);
        if (response == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
    public ErrorWindow(Exception e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, ""+ e.getMessage(), "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        // JOptionPane.showConfirmDialog(null,"Seems we cannot find the server, \nplease check your internet connection and try again\nif all fails contact the devs for info\n error:"+ e.getMessage(), "Warning",JOptionPane.OK_OPTION);
        if (response == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
}
