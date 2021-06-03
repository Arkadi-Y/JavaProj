package windows;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ErrorWindow {
    private int response;
    //mostly wrong data type exception
    public ErrorWindow(IOException e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, e.getMessage(), "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (response == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
    //any sql Exception
    public ErrorWindow(SQLException e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, "Seems we cannot find the server, \nplease check your internet connection and try again\nif all fails contact the devs for info\n error:"+ e.getMessage(), "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (response == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
    //random Exceptions
    public ErrorWindow(Exception e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, ""+ e.getMessage(), "Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        if (response == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
    //file Exceptions
    public ErrorWindow(FileNotFoundException e){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, e.getMessage(),"Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }
    //login Exception, wrong username or password
    public ErrorWindow(boolean validated){
        Object[] options = { "OK", "CANCEL" };
        response = JOptionPane.showOptionDialog(null, "wrong user name or password ,\nmichal should use ->\nuser name = admin\npassword = 123456","Warning",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }
}
