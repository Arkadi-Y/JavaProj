package windows;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar{
    private JMenuBar menuBar;
    private JMenu menu, submenu;
    private JMenuItem loginItem,logoutItem,quit,updateAll;
    private int loged;

    //gets log value (1/0).
    public menuBar(int loged){
        this.loged=loged;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        loginItem = new JMenuItem("Login");
        //log in btn opens login window
        loginItem.addActionListener(e->{
            SwingUtilities.getWindowAncestor(menuBar).dispose();
            new LoginWindow();
        });
        logoutItem = new JMenuItem("Logout");
        //logout btn goes back to main window
        logoutItem.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(menuBar).dispose();
            new MainWindow();
        });
        //inactive
        updateAll = new JMenuItem("Save all");
//        updateAll.addActionListener((ActionListener) this);
        quit = new JMenuItem("Quit");
        //close all
        quit.addActionListener(e->{
            int response = JOptionPane.showConfirmDialog(null, "Would You Like to exit?", "Warning",JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        if (loged>0)
            loginItem.setEnabled(false);
        else
            logoutItem.setEnabled(false);
        menu.add(loginItem);menu.add(logoutItem);menu.add(quit);
        menuBar.add(menu);
    }
    public JMenuBar getMenu(){return menuBar;}

}
