package project.Front_End;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import project.libs.*;

public class Login implements ActionListener {
    public JFrame fr;
    public JDesktopPane dp;
    public JInternalFrame jf;
    public JPanel p;
    public JLabel name, name2;
    public JTextField txt, txt2;
    public JButton b1, b2, b3;

    public Login() {
        fr = new JFrame("Home");
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);

        //Create JDesktopPane JPanel and JLabel
        dp = new JDesktopPane();
        p = new JPanel(new BorderLayout());
        name = new JLabel();
        name2 = new JLabel();
        txt = new JTextField(20);
        txt2 = new JTextField(20);
        b1 = new JButton("Enter");
        b2 = new JButton("Cancel");
        b3 = new JButton("Forgot");
        jf = new JInternalFrame("Login", false, true, false, false);

        //Create JInternalFrame
        jf.getContentPane().add(new JLabel("Maintain....."));
        jf.setLayout(new FlowLayout());
        jf.pack();
        jf.setVisible(true);

        jf.add(txt);
        txt.addActionListener(this);
        jf.add(txt2);
        txt2.addActionListener(this);
        jf.add(b3);
        b3.addActionListener(this);
        jf.add(b2);
        b2.addActionListener(this);
        jf.add(b1);
        b1.addActionListener(this);
        //DesktopPane Setting
        dp.add(jf);
        //Add DesktopPane to JFrame
        fr.add(dp, BorderLayout.CENTER);

        jf.setLocation(100,100);
        jf.setSize(300,150);
        fr.setSize(1000, 600);
        fr.setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(b1)) {
            String username = txt.getText();
            String password = txt2.getText();
            System.out.println("User input: Username: " + username + " Password: " + password);
            System.out.println("User status: " + ArmQueryDB.findUser(username, password) + "\n");
        }
    }
}
