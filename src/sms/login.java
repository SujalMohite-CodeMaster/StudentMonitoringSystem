package sms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
    JButton sign , cancle ;
    JLabel l1 ,l2;
    JTextField username;
    JPasswordField password ;
    Font font = new Font("Tahoma",Font.BOLD,14);

    login(){
        setSize(480,480);
        l1 = new JLabel("USERNAME :");
        l1.setBounds(80,50,120,80);
        l1.setFont(font);
        add(l1);

        username = new JTextField();
        username.setBounds(220,70,200,40);
        username.setFont(font);
        add(username);

        l2 = new JLabel("PASSWORD :");
        l2.setBounds(80,150,120,80);
        l2.setFont(font);
        add(l2);

        password = new JPasswordField();
        password.setBounds(220,170,200,40);
        password.setFont(font);
        add(password);

        sign = new JButton("SIGN IN ->");
        sign.setBounds(330,330,100,50);
        setFont(font);
        sign.setBackground(Color.black);
        sign.setForeground(Color.white);
        sign.addActionListener(this);
        add(sign);

        cancle = new JButton("CANCLE ");
        cancle.setBounds(50,330,100,50);
        cancle.setFont(font);
        cancle.setBackground(Color.black);
        cancle.setForeground(Color.white);
        cancle.addActionListener(this);
        add(cancle);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/password_image.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,480,480);
        add(lb1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==sign){
            String username = this.username.getText();
            String Password = String.valueOf(password.getPassword());

            conn d = new conn();
            String query = "select username,password from login where username = '"+username+"'and password = '"+Password+"'";
            try{
                ResultSet rs = d.s.executeQuery(query);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Login Successfully !");
                    new options();
                    this.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Credentials !");
                }
            }catch(Exception ae){
                System.out.println(ae);
            }

        }
        if (e.getSource()==cancle){
            new starter();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new login();
    }

}
