package sms;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class starter extends JFrame implements ActionListener {

    JButton login;
    starter(){
        setSize(800,600);

        JLabel l1 = new JLabel("Shree Bhairavnath Vidyalay ");
        l1.setBounds(200,50,400,100);
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        add(l1);


        login = new JButton("Login");
        login.setBounds(600,470,100,50);
        login.setFont(new Font("Tahoma",Font.BOLD,22));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/first.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,800,600);
        add(lb1);


        setUndecorated(false); // use to remove upper cancle bar.
        setLayout(null);
        setLocationRelativeTo(null); // take the frame to centre .
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            new login();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new starter();
    }
}
