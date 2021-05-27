package windows;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private JFrame frame;
    private JPanel panel;
    private JButton login;
    private JButton newTicket;
    private menuBar menuBar;

    public MainWindow(){
        frame = new JFrame();
        panel = new JPanel();
        menuBar = new menuBar(0);
        login = new JButton("login");
        login.addActionListener(e -> loginAction());
        newTicket = new JButton("Enter help request");
        newTicket.addActionListener(e -> newTicketAction());
        frame.setBounds(400,200,500,400);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2,1,10,5));
        frame.setJMenuBar(menuBar.getMenu());
        panel.add(newTicket);
        panel.add(login);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void loginAction(){
        frame.dispose();
        new LoginWindow();
    }
    public void newTicketAction(){
        frame.dispose();
        new TicketWindow(0);
    }

}
