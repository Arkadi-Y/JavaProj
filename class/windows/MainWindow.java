package windows;

import Server.myDATA;
import Server.myJDBC;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class MainWindow {
    private JFrame frame;
    private JPanel ButtonPanal;
    private JPanel lablePanal;
    private JButton login;
    private JButton newTicket;
    private JButton uploadCV;
    private menuBar menuBar;
    private myDATA data;

    public MainWindow(myDATA data) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException, URISyntaxException {
        //look for connection errors at startup
        this.data=data;
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        ButtonPanal = new JPanel();
        menuBar = new menuBar(0,data);
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
            } catch (URISyntaxException ex) {
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
        setLablePanal();
        frame.setBounds(400,200,800,390);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        ButtonPanal.setLayout(new GridLayout(3,1,10,5));
        frame.setJMenuBar(menuBar.getMenu());
        ButtonPanal.add(newTicket);
        ButtonPanal.add(uploadCV);
        ButtonPanal.add(login);
        frame.add(lablePanal,BorderLayout.EAST);
        frame.add(ButtonPanal,BorderLayout.WEST);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void loginAction(){
        frame.dispose();
        new LoginWindow(data);
    }
    public void newTicketAction() throws IOException, SQLException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, URISyntaxException {
        frame.dispose();
        new TicketWindow(0,data);
    }
    public void setLablePanal() throws IOException, URISyntaxException {
        lablePanal = new JPanel();
        lablePanal.setBounds(400,200,200,400);
        BufferedImage myPicture = ImageIO.read(new File(this.getClass().getResource("../matnasim320X640.jpg").toURI()));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setBounds(400,200,200,400);
        lablePanal.add(picLabel);
    }

}
