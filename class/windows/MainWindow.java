package windows;

import Server.myDATA;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import static javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW;

public class MainWindow {
    private JFrame frame;
    private JPanel ButtonPanal;
    private JPanel lablePanal;
    private JButton login;
    private JButton newTicket;
    private JButton uploadCV;
    private menuBar menuBar;
    private myDATA data;

    public MainWindow(myDATA data){
        this.data=data;
        frame = new JFrame();
        setUP();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void setUP(){
        frame.setLayout(new BorderLayout());
        ButtonPanal = new JPanel();
        menuBar = new menuBar(0,data);
        login = new JButton("login");
        newTicket = new JButton("Enter help request");
        uploadCV = new JButton("upload CV");

        addActionsToButtons();
        //JButton button = (JButton) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
        System.out.println(login.getAction());
        try {
            setLablePanal();
        } catch (IOException e) {
             new ErrorWindow(e);
        } catch (URISyntaxException e) {
             new ErrorWindow(e);
        }
        frame.setBounds(400,200,800,390);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        ButtonPanal.setLayout(new GridLayout(3,1,10,5));
        frame.setJMenuBar(menuBar.getMenu());
        ButtonPanal.add(newTicket);
        ButtonPanal.add(uploadCV);
        ButtonPanal.add(login);
        frame.add(lablePanal,BorderLayout.EAST);
        frame.add(ButtonPanal,BorderLayout.WEST);
    }
    public void addActionsToButtons(){
        login.addActionListener(e -> loginAction());
        newTicket.addActionListener(e -> newTicketAction());
        uploadCV.addActionListener(e -> { try {
                new getFileWindow();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


    }
    public void loginAction(){
        new LoginWindow(data);
    }
    public void newTicketAction(){
        frame.dispose();
        new TicketWindow(0,data);
    }
    public void setLablePanal() throws URISyntaxException, IOException {
        lablePanal = new JPanel();
        lablePanal.setBounds(400,200,200,400);
        BufferedImage myPicture = ImageIO.read(new File(this.getClass().getResource("../matnasim320X640.jpg").toURI()));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(400,200,200,400);
        lablePanal.add(picLabel);
    }

}
