package windows;

import Server.myJDBC;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainWindow {
    private JFrame frame;
    private JPanel panel;
    private JButton login;
    private JButton newTicket;
    private JButton uploadCV;
    private menuBar menuBar;

    public MainWindow() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        //look for connection errors at startup
        try {
            myJDBC sql = new myJDBC();
        } catch (IOException e) {
            new ErrorWindow(e);
        } catch (SQLException e) {
            new ErrorWindow(e);
        }
        frame = new JFrame();
        panel = new JPanel();
        menuBar = new menuBar(0);
        login = new JButton("login");
        login.addActionListener(e -> loginAction());
        newTicket = new JButton("Enter help request");
        newTicket.addActionListener(e -> {
            try {
                newTicketAction();
            } catch (IOException ex) {
                new ErrorWindow(ex);
            } catch (SQLException ex) {
                new ErrorWindow(ex);
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        uploadCV = new JButton("upload CV");
        uploadCV.addActionListener(e -> {
            try {
                new getFileWindow();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        frame.setBounds(400,200,500,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,1,10,5));
        frame.setJMenuBar(menuBar.getMenu());
        panel.add(newTicket);
        panel.add(uploadCV);
        panel.add(login);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void loginAction(){
        frame.dispose();
        new LoginWindow();
    }
    public void newTicketAction() throws IOException, SQLException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        frame.dispose();
        new TicketWindow(0);
    }

}
