package Front_End;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    public JFrame fr;
    public JDesktopPane dp;
    public JInternalFrame jf;
    public JPanel p;
    public JLabel name, name2;
    public JTextField txt, txt2;
    public JButton b1;

    public Login() {
    fr = new JFrame("Home");
    fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
    fr.setLayout(new BorderLayout());

    //Create JDesktopPane JPanel and JLabel
    dp = new JDesktopPane();
    p = new JPanel(new BorderLayout());
    name = new JLabel();
    name2 = new JLabel();
    txt = new JTextField(20);
    txt2 = new JTextField(20);
    b1 = new JButton("Enter");
    jf = new JInternalFrame("Login", true, true, true, true);

    //Create JInternalFrame
    jf.getContentPane().add(new JLabel("Maintain....."));
    jf.setLayout(new FlowLayout());
    jf.pack();
    jf.setVisible(true);

    jf.add(txt);
    jf.add(txt2);
    jf.add(b1);
    //DesktopPane Setting
    dp.add(jf);
    //Add DesktopPane to JFrame
    fr.add(dp, BorderLayout.CENTER);

    jf.setLocation(100,100);
    jf.setSize(300,300);
    fr.setSize(1000, 600);
    fr.setVisible(true);

    }
    public static void main(String[] args) {
        new Login();
    }
}
