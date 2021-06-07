package windows;



import Server.myDATA;

import javax.swing.*;

public class menuBar extends JMenuBar{
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem loginItem,logoutItem,quit,updateAll;
    private int loged;
    private myDATA data;

    //gets log value (1/0).
    public menuBar(int loged, myDATA data){
        this.data=data;
        this.loged=loged;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        loginItem = new JMenuItem("Login");
        logoutItem = new JMenuItem("Logout");

        //inactive
        updateAll = new JMenuItem("Save all");
        quit = new JMenuItem("Quit");
        addActions();
        //addShortCuts(menuBar);
        if (loged>0)
            loginItem.setEnabled(false);
        else
            logoutItem.setEnabled(false);
        menu.add(loginItem);menu.add(logoutItem);menu.add(quit);
        menuBar.add(menu);
    }
    public JMenuBar getMenu(){return menuBar;}
    public void addActions(){
        loginItem.addActionListener(e->{
            new LoginWindow(data);
        });
        logoutItem.addActionListener(e -> {
            SwingUtilities.getWindowAncestor(menuBar).dispose();
            new MainWindow(data);
        });
        quit.addActionListener(e->{
            int response = JOptionPane.showConfirmDialog(null, "Would You Like to exit?", "Warning",JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

    }
    /*
    public void addShortCuts(JComponent component){
        component.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        component.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE , 0), "exit");
        component.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "login");
        component.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "logout");
        component.getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    SwingUtilities.getWindowAncestor(menuBar).dispose();
                    new TicketWindow(0,data);
            }
        });
        component.getActionMap().put("exit", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Would You Like to exit?", "Warning",JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        component.getActionMap().put("login", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginWindow(data);
            }
        });
        component.getActionMap().put("logout", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(menuBar).dispose();
                new MainWindow(data);
            }
        });
    }*/


}
