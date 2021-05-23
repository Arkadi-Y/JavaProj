package windows;

import Server.myJDBC;
import ongoing.List;
import ongoing.Person;
import ongoing.Ticket;
import windows.EmployeeWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

//ticket window will show ticket content or lets you create a new one
public class TicketWindow {
    private JFrame frame;
    private JTextField StatusText;
    private JTextField DescriptionText;
    private JTextField ticketNumText;
    private JTextField UserNameText;
    private JTextField UserPhoneText;
    private JTextField UserMailText;
    private JLabel StatusLbl=new JLabel("Status ");
    private JLabel DescriptionLbl=new JLabel("Description ");
    private JLabel ticketNumLbl=new JLabel("Ticket number ");
    private JLabel UserNameLbl=new JLabel("Name  ");
    private JLabel UserPhoneLbl=new JLabel("Phone ");
    private JLabel UserMailLbl=new JLabel("Mail ");
    private JButton SubmitBtn = new JButton("Submit");
    private JButton UpdateBtn = new JButton("Update");

// constructor for new ticket
    public TicketWindow(){
        frame = new JFrame();
        initTextFields();
        setUP();
        ticketNumText.setEditable(false);
        UpdateBtn.setEnabled(false);
        SubmitBtn.addActionListener(e -> {
           addTicket();
        });
    }
    //constructor for existing ticket
    public TicketWindow(Ticket ticket){
        frame = new JFrame();
        initTicket(ticket);
        setUP();
        SubmitBtn.setEnabled(false);
        UpdateBtn.addActionListener(e -> {
            updateTicket(ticket);
        });
    }
    //main setup for frame
    public void setUP(){
        frame.setBounds(400,200,700,600);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(7,2,10,5));
        addFields();
        //add listener on window close to enter employee window
        frame.addWindowListener(new WindowAdapter()
        {@Override
            public void windowClosing(WindowEvent e){
            try {
                EmployeeWindow window =new EmployeeWindow();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }});
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    //add labels and text fields
    public void addFields(){
        frame.add(StatusLbl);
        frame.add(StatusText);
        frame.add(DescriptionLbl);
        frame.add(DescriptionText);
        frame.add(ticketNumLbl);
        frame.add(ticketNumText);
        frame.add(UserNameLbl);
        frame.add(UserNameText);
        frame.add(UserPhoneLbl);
        frame.add(UserPhoneText);
        frame.add(UserMailLbl);
        frame.add(UserMailText);
        frame.add(SubmitBtn);
        frame.add(UpdateBtn);
    }
    //empty text for new ticket
    public void initTextFields(){
        StatusText=new JTextField();
        DescriptionText=new JTextField();
        ticketNumText=new JTextField();
        UserNameText=new JTextField();
        UserPhoneText=new JTextField();
        UserMailText=new JTextField();
    }
    //fill existing ticket
    public void initTicket(Ticket T){
        StatusText=new JTextField(T.getStatus());
        DescriptionText=new JTextField(T.getDescription());
        DescriptionText.setEditable(false);
        ticketNumText=new JTextField(T.getTicketNum());
        ticketNumText.setEditable(false);
        UserNameText=new JTextField(T.getName());
        UserNameText.setEditable(false);
        UserPhoneText=new JTextField(T.getPhone());
        UserPhoneText.setEditable(false);
        UserMailText=new JTextField(T.getMail());
        UserMailText.setEditable(false);
    }
    public void addTicket(){
        String description = DescriptionText.getText();
        String status = StatusText.getText();
        String name = UserNameText.getText();
        String phone = UserPhoneText.getText();
        String mail = UserMailText.getText();
        Person p = new Person(name,phone,mail);
        Ticket t = new Ticket(status,description,p);
        try {
            myJDBC sql = new myJDBC();
            sql.newPerson(p);
            sql.insertTicket(t);
            frame.dispose();
            new EmployeeWindow();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateTicket(Ticket ticket){
        try {
            myJDBC sql = new myJDBC();
            sql.updateTicketStatus(StatusText.getText(),ticket.getTicketNum());
            frame.dispose();
            EmployeeWindow window =new EmployeeWindow();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


}
