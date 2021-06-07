package windows;

import Server.myDATA;
import Server.myJDBC;
import Classes.Employee;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ApplyForJobWindow {
    private String[] matnasArray ={"haifa","karmiel","shmona","jerusalem","tel-aviv","beer-sheva","eilat"};
    private JFrame frame;
    private JComboBox matnasText;
    private String[] matnasOptions = matnasArray;
    private JTextField idText;
    private JTextField addressText;
    private JTextField roleText;
    private JTextField UserNameText;
    private JTextField UserPhoneText;
    private JTextField UserMailText;
    private JLabel matnasLbl=new JLabel("choose a Matnas :");
    private JLabel idLbl=new JLabel("Your ID : ");
    private JLabel addressLbl=new JLabel("address :");
    private JLabel UserNameLbl=new JLabel("Name  ");
    private JLabel UserPhoneLbl=new JLabel("Phone ");
    private JLabel UserMailLbl=new JLabel("Mail ");
    private JLabel RoleLbl=new JLabel("Roll ");
    private JButton SubmitBtn = new JButton("Submit");
    private JButton UploadBtn = new JButton("Send CV");
    private myDATA data;


    public ApplyForJobWindow(myDATA data){
        this.data=data;
        frame = new JFrame();
        initTextFields();
        setUP();
        SubmitBtn.setEnabled(false);
        UploadBtn.setEnabled(false);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
    public void setUP(){
        frame.setBounds(400,200,700,600);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(9,2,10,5));
        addFields();
        addListenersAndActions();
        //add listener on window close to enter main window
         //makes frame go center

    }
    public void addListenersAndActions(){
        frame.addWindowListener(new WindowAdapter()
        {@Override
        public void windowClosing(WindowEvent e){
            new MainWindow(data);
        }});
        SubmitBtn.addActionListener(e->{SubbmitAction();});
        UploadBtn.addActionListener(e->{
            try {
                new getFileWindow(UserNameText.getText());
                SubmitBtn.setEnabled(true);
            } catch (IOException ex) {
                new ErrorWindow(ex);
            }
        });
        //make sure there is a name to upload a cv
        UserNameText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                UploadBtn.setEnabled(true);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                if (UserNameText.getText().length()<=0)
                    UploadBtn.setEnabled(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (UserNameText.getText().length()<=0)
                    UploadBtn.setEnabled(false);
            }
        });
    }
    public void addFields(){
        frame.add(matnasLbl);
        frame.add(matnasText);
        frame.add(idLbl);
        frame.add(idText);
        frame.add(UserNameLbl);
        frame.add(UserNameText);
        frame.add(UserPhoneLbl);
        frame.add(UserPhoneText);
        frame.add(UserMailLbl);
        frame.add(UserMailText);
        frame.add(addressLbl);
        frame.add(addressText);
        frame.add(RoleLbl);
        frame.add(roleText);
        frame.add(SubmitBtn);
        frame.add(UploadBtn);
    }
    public void initTextFields(){
        matnasText=new JComboBox(matnasOptions);
        matnasText.setSelectedIndex(0);
        idText=new JTextField();
        addressText=new JTextField();
        UserNameText=new JTextField();
        UserPhoneText=new JTextField();
        UserMailText=new JTextField();
        roleText=new JTextField();
    }
    public boolean validateInput(String matnas,String id,String name,String phone,String mail,String address ) {
        boolean flag = true;
        if (matnas.equals("") || matnas == null) {
            flag = false;
            this.matnasText.setBorder(new LineBorder(Color.RED, 2));
        }
        if (id.equals("") || id == null|| !isNumeric(id)){
            flag = false;
            this.idText.setBorder(new LineBorder(Color.RED, 2));}
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
        if (address.equals("") || address == null){
            flag = false;
            this.addressText.setBorder(new LineBorder(Color.RED, 2));
        }
        return flag;
    }
    public static boolean isNumeric(String str) {
        return str.matches("^\\d+$");  //match a number.
    }

    public void SubbmitAction(){
        //get text fields
        String id = idText.getText();
        String address = addressText.getText();
        String name = UserNameText.getText();
        String phone = UserPhoneText.getText();
        String mail = UserMailText.getText();
        String role = roleText.getText();
        String matnasTXT=matnasText.getSelectedItem().toString();
        int matnas = matnasText.getSelectedIndex()+1;//0 is region
        //first validate all fields
        if (validateInput(matnasTXT,id,name,phone,mail,address)) {
            //looks for employee by id (List class method) in existing list
            Employee employee = data.employeeList.findByID(Integer.valueOf(id));
            //returns null if no employee found
            if (employee==null){
                //creates new
                employee = new Employee(Integer.valueOf(id),name,phone,mail,address,role,matnas);
                myJDBC jdbc = new myJDBC();
                jdbc.newEmployee(employee.getId(),employee.getName(),employee.getPhone(),employee.getMail(),employee.getAddress(),employee.getRole(),employee.getMatnasID());
                data.refreshDATA();
                JOptionPane.showConfirmDialog(null,"Request submitted, wait for a call","YAY",JOptionPane.DEFAULT_OPTION);
                frame.dispose();
                new MainWindow(data);
            }else{
                //error window
                EmployeeExists(employee);
            }

        }
    }
    public void EmployeeExists(Employee employee){
        Object[] options = { "OK", "CANCEL" };
        int response;
        //special case -> regional worker
        if (employee.getMatnasID()==0){
            response = JOptionPane.showOptionDialog(null,"You seem to be employed by us already as one of the region managment\nTo request a transfer please inform you'r supervisor", "Warning",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }else {
            response = JOptionPane.showOptionDialog(null, "You seem to be employed by us already at " + matnasArray[employee.getMatnasID()] + "\nTo request a transfer please inform you'r supervisor", "Warning",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }
        if (response == JOptionPane.OK_OPTION) {
            frame.dispose();
            new MainWindow(data);
        }
    }
}
