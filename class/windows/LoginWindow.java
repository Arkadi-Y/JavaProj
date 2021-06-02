package windows;

import Server.myDATA;
import Server.myJDBC;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class LoginWindow implements ActionListener {
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        frame.setVisible(true);

    }

    public void addActions() {
        loginBTN.addActionListener(this::actionPerformed);
    }

    public void validate(String user, String password) throws IOException, SQLException {

          myJDBC db = new myJDBC();
          if (db.validateLogin(user, password)) {
              frame.dispose();
              new EmployeeWindow(data);
          } else System.out.println("Bad");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = userNameText.getText();
        char[] passwordArray = passwordText.getPassword();
        String password = new String(passwordArray);
        try {
            validate(userName, password);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
