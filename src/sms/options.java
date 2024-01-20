package sms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class options extends JFrame implements ActionListener {

    JButton attendance , marks , profile, adddetails;

    Font font = new Font("Tahoma",Font.BOLD,20);
    JMenu menu ;
    JMenuItem logout;
    JFrame f;
    JMenuBar mb;
    options(){
        setSize(1000,700);


        profile = new JButton("Profile");
        profile.setBounds(750,80,200, 80);
        profile.addActionListener(this);
        profile.setFont(font);
        add(profile);

        attendance = new JButton("Attendance");
        attendance.setBounds(750,200,200,80);
        attendance.addActionListener(this);
        attendance.setFont(font);
        add(attendance);

        marks = new JButton("Marks");
        marks.setBounds(750,320,200,80);
        marks.addActionListener(this);
        marks.setFont(font);
        add(marks);

        adddetails = new JButton("Add Details");
        adddetails.setBounds(750,440,200,80);
        adddetails.addActionListener(this);
        adddetails.setFont(font);
        add(adddetails);

        mb = new JMenuBar();
        menu = new JMenu("MENU");
        logout = new JMenuItem("LogOut");
        menu.add(logout);
        logout.addActionListener(this);
        mb.add(menu);
        setJMenuBar(mb);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/b18.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,700,700);
        add(lb1);

        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==attendance){
            new viewAttendance();
            this.setVisible(false);
        }
        if(ae.getSource()==marks){
            new viewMarks();
            this.setVisible(false);
        }
        if(ae.getSource()==profile){
            new viewDetails();
            this.setVisible(false);
        }
        if(ae.getSource()==adddetails){

            new addDetails();
            this.setVisible(false);
        }
        if (ae.getSource().equals(logout)){
            System.exit(15);
        }

    }

    public static void main(String[] args) {
        new options();
    }
}