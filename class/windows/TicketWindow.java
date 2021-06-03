package windows;

import Server.myDATA;
import Server.myJDBC;
import ongoing.Person;
import ongoing.Ticket;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

//ticket window will show ticket content or lets you create a new one
public class TicketWindow {
    private int logedIn;
    private JFrame frame;
    private JComboBox StatusText;
    private String[] statusOptions = {"New","Waiting","Complete"};
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
    private myDATA data;

// constructor for new ticket
    public TicketWindow(int logedIn, myDATA data){
        this.data=data;
        frame = new JFrame();
        initTextFields();
        setUP();
        ticketNumText.setEditable(false);
        UpdateBtn.setEnabled(false);
        SubmitBtn.addActionListener(e -> {
           addTicket();
        });
        if (this.data.ticketList.size>=30) {
            SubmitBtn.setEnabled(false);
            JOptionPane.showMessageDialog(null, "There are too many active tickets, please wait", "alert", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
            if (logedIn>0)
                new EmployeeWindow(data);
            else
                new MainWindow(data);
        }
        this.logedIn = logedIn;
    }
    //constructor for existing ticket
    public TicketWindow(Ticket ticket,myDATA data){
        this.data=data;
        frame = new JFrame();
        initTicket(ticket);
        setUP();
        SubmitBtn.setEnabled(false);
        UpdateBtn.addActionListener(e -> {
            updateTicket(ticket);
        });
        this.logedIn=1;
    }
    //main setup for frame
    public void setUP(){
        frame.setBounds(400,200,700,600);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(7,2,10,5));
        addFields();
        //add listener on window close to enter employee window or main window
        frame.addWindowListener(new WindowAdapter()
        {@Override
            public void windowClosing(WindowEvent e){
            //if logged in enter employee window
            if (logedIn==1)
                new EmployeeWindow(data);
            //else -> main window
            else
                new MainWindow(data);
        }});
        //makes frame go center
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
        StatusText=new JComboBox(statusOptions);
        StatusText.setSelectedIndex(0);
        StatusText.setEditable(false);
        StatusText.setEnabled(false);
        DescriptionText=new JTextField();
        ticketNumText=new JTextField();
        UserNameText=new JTextField();
        UserPhoneText=new JTextField();
        UserMailText=new JTextField();
    }
    //fill existing ticket
    public void initTicket(Ticket T){
        int index =0;
        StatusText= new JComboBox(statusOptions);
        for (int i =0;i<statusOptions.length;i++){
            if(statusOptions[i].equals(T.getStatus()))
                index = i;
        }
        StatusText.setSelectedIndex(index);
        DescriptionText=new JTextField(T.getDescription());
        DescriptionText.setEditable(false);
        ticketNumText=new JTextField((Integer.toString(T.getTicketNum())));
        ticketNumText.setEditable(false);
        UserNameText=new JTextField(T.getName());
        UserNameText.setEditable(false);
        UserPhoneText=new JTextField(T.getPhone());
        UserPhoneText.setEditable(false);
        UserMailText=new JTextField(T.getMail());
        UserMailText.setEditable(false);
    }
    public void addTicket() {
        String description = DescriptionText.getText();
        String status = StatusText.getSelectedItem().toString();
        String name = UserNameText.getText();
        String phone = UserPhoneText.getText();
        String mail = UserMailText.getText();
        if (validateInput(description,status,name,phone,mail)) {
            Person p = new Person(name, phone, mail);
            Ticket t = new Ticket(status, description, p);
                myJDBC jdbc = new myJDBC();
                jdbc.newPerson(p);
                jdbc.insertTicket(t);
                data.refreshDATA();
                if (logedIn > 0)
                    new EmployeeWindow(data);
                else
                    new MainWindow(data);
                frame.dispose();
        }
    }
    public void updateTicket(Ticket ticket){
        myJDBC jdbc = new myJDBC();
        try {
            if (StatusText.getSelectedItem().toString().equals("Complete")) {
                ticket.setStatus("Complete");
                jdbc.insertCompletedTicket(ticket);
            }
            jdbc.updateTicketStatus(StatusText.getSelectedItem().toString(),ticket.getTicketNum());
            frame.dispose();
            data.refreshDATA();
            new EmployeeWindow(data);
        } catch (SQLException ex) {
            new ErrorWindow(ex);
        }
    }
    public boolean validateInput( String description,String status,String name,String phone,String mail ) {
        boolean flag = true;
        if (description.equals("") || description == null) {
            flag = false;
            this.DescriptionText.setBorder(new LineBorder(Color.RED, 2));
        }
        if (status.equals("") || status == null){
            flag = false;
        this.StatusText.setBorder(new LineBorder(Color.RED, 2));}
        if (name.equals("") || name == null){
            flag = false;
        this.UserNameText.setBorder(new LineBorder(Color.RED, 2));}
        if (phone.equals("") || phone == null){
            flag = false;
        this.UserPhoneText.setBorder(new LineBorder(Color.RED, 2));}
        if (mail.equals("") || mail == null){
            flag = false;
        this.UserMailText.setBorder(new LineBorder(Color.RED, 2));
    }
            return flag;
    }


}
