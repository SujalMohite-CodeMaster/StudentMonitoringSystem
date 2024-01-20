package sms;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class addDetails extends JFrame implements ActionListener {

    Font font = new Font("Tahoma",Font.BOLD,21);
    int x = 60 , txt = 270 ,txtWidth =180,txtHeight = 40;
    JTextField name , phone , address , aadhar ;
    JDateChooser dob ;
    ButtonGroup gender ;
    JComboBox bldgrp;
    JButton adddetails , back;
    JLabel l1,l2,l3,l4,l5,l6,l7,lable;
    JRadioButton male , female ;

   addDetails(){
       setSize(600,900);

       l1 = new JLabel("NAME: ");
       l1.setFont(font);
       l1.setBounds(x,60,100,60);
       l1.setForeground(Color.black);
       add(l1);

       name = new JTextField();
       name.setBounds(txt,80,txtWidth,txtHeight);
       name.setFont(font);
       add(name);

       l2 = new JLabel("Address :");
       l2.setBounds(x,140,100,60);
       l2.setFont(font);
       l2.setForeground(Color.black);
       add(l2);

       address = new JTextField();
       address.setBounds(txt,160,txtWidth,txtHeight);
       address.setFont(font);
       add(address);

       l3 = new JLabel("D.O.B :");
       l3.setBounds(x,220,100,60);
       l3.setFont(font);
       l3.setForeground(Color.black);
       add(l3);

       dob = new JDateChooser();
       dob.setBounds(txt,220,txtWidth,txtHeight);
       add(dob);

       l4 = new JLabel("Aadhar :");
       l4.setBounds(x,300,100,60);
       l4.setForeground(Color.black);
       l4.setFont(font);
       add(l4);

       aadhar = new JTextField();
       aadhar.setBounds(txt,320,txtWidth,txtHeight);
       aadhar.setFont(font);
       add(aadhar);

       l5 = new JLabel("Gender :");
       l5.setBounds(x,380,100,60);
       l5.setFont(font);
       l5.setForeground(Color.black);
       add(l5);

       gender = new ButtonGroup();

       male = new JRadioButton("Male");
       male.setBounds(txt,380,txtWidth/2,txtHeight);
       male.setFont(font);
       gender.add(male);
       add(male);

       female = new JRadioButton("Female");
       female.setBounds(txt+110,380,92,txtHeight);
       female.setFont(new Font("Tahoma",Font.BOLD,18));
       gender.add(female);
       add(female);

       l6 = new JLabel("Phone No :");
       l6.setBounds(x,460,150,60);
       l6.setFont(font);
       l6.setForeground(Color.black);
       add(l6);

       phone = new JTextField();
       phone.setBounds(txt,480,txtWidth,txtHeight);
       phone.setFont(font);
       add(phone);

       String [] arr = {"A+","AB+","O+","O-","AB-","B+","B-","A-"};
       bldgrp = new JComboBox(arr);
       bldgrp.setBounds(txt,540,txtWidth,txtHeight);
       bldgrp.setSelectedIndex(-1);
       add(bldgrp);

       l7 = new JLabel("Blood Grp :");
       l7.setBounds(x,540,150,60);
       l7.setFont(font);
       l7.setForeground(Color.black);
       add(l7);

       adddetails = new JButton("Add Details ");
       adddetails.setBounds(230,630,200,60);
       adddetails.setFont(font);
       adddetails.setBackground(Color.black);
       adddetails.setForeground(Color.white);
       adddetails.addActionListener(this);
       add(adddetails);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/b9.jpg"));
       Image edit = i1.getImage().getScaledInstance(600,900,Image.SCALE_DEFAULT);
       i1 = new ImageIcon(edit);
       JLabel lb1 = new JLabel(i1);
       lb1.setBounds(0,0,600,900);
       add(lb1);

       ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Images/back.png"));
       Image img1 = i2.getImage().getScaledInstance(75,50,Image.SCALE_DEFAULT);
       i2 = new ImageIcon(img1);
       back = new JButton(i2);
       back.setBounds(0,0 , 50,50);
       back.addActionListener(this);
       add(back);


       setTitle("Add Details Window");
       setLayout(null);
       setVisible(true);
       setLocationRelativeTo(null);



   }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==adddetails){
            String name = this.name.getText();
            String aadhar = this.aadhar.getText();
            String address = this.address.getText();
            String phone = this.phone.getText();
            String bldgrp = (String) this.bldgrp.getSelectedItem();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            String dob = df.format(this.dob.getDate());
            conn c = new conn();
            String query = "insert into stud_details(name,address,dob,aadhar,gender,phone,bldgrp) values ('"+name+"','"+address+"','"+dob+"','"+aadhar+"','"+gender+"','"+phone+"','"+bldgrp +"');";
            try {
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Added Successfully !");
            }catch (Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Some Error Occured !");
            }
        }
        if(ae.getSource()==back){
            new options();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new addDetails();
    }
}

































