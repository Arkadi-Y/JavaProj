package windows;

import Server.myDATA;
import Server.myJDBC;
import javax.swing.*;

public class LoginWindow{
    private JFrame frame;
    private JPanel panel;
    private JLabel userNameLable;
    private JLabel passwordLable;
    private JTextField userNameText;
    private JPasswordField passwordText;
    private JButton loginBTN;
    private myDATA data;

    public LoginWindow(myDATA data) {
        this.data=data;
        setUP();
    }

    public void setUP() {
        frame = new JFrame();
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        userNameLable = new JLabel("User  name");
        userNameLable.setBounds(10, 20, 80, 25);

        passwordLable = new JLabel("Password   ");
        passwordLable.setBounds(10, 50, 80, 25);

        userNameText = new JTextField(45);
        userNameText.setBounds(100, 20, 165, 25);

        passwordText = new JPasswordField(45);
        passwordText.setBounds(100, 50, 165, 25);

        loginBTN = new JButton("Login");
        loginBTN.setBounds(10, 80, 80, 25);

        panel.add(userNameLable);
        panel.add(userNameText);
        panel.add(passwordLable);
        panel.add(passwordText);
        panel.add(loginBTN);
        frame.add(panel);

        addActions();
        //makes frame go center
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void addActions() {
        loginBTN.addActionListener(e -> loginAction());
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    frame.dispose();
                    new MainWindow(data);
            }
        });
    }

    public void validate(String user, String password){
          myJDBC db = new myJDBC();
          if (db.validateLogin(user, password)) {
              frame.dispose();
              new EmployeeWindow(data);
          } else new ErrorWindow(false);
    }
//button action
    public void loginAction() {
        String userName = userNameText.getText();
        char[] passwordArray = passwordText.getPassword();
        String password = new String(passwordArray);
        validate(userName, password);
    }

}
