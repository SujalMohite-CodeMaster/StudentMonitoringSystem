package sms;
import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class viewDetails extends JFrame implements ActionListener {
    JScrollPane sp1;
    JTable details ;
    JButton back ;
    viewDetails(){
        setSize(1000,700);
        sp1 = new JScrollPane();
        sp1.setBounds(60,80,900,400);
        add(sp1);
        details = new JTable();
        details.setFont(new Font("Tahoma",Font.PLAIN,18));
        details.setRowHeight(26);
        sp1.setViewportView(details);
        getdeatils();
        JTableHeader tb1 = details.getTableHeader();
        tb1.setFont(new Font("Tahoma",Font.BOLD,22));
        tb1.setBackground(Color.orange);
        details.getColumnModel().getColumn(1).setMinWidth(150);
        details.getColumnModel().getColumn(0).setMaxWidth(50);
        details.getColumnModel().getColumn(3).setMinWidth(110);
        details.getColumnModel().getColumn(4).setMinWidth(100);
        details.getColumnModel().getColumn(5).setMinWidth(80);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/b20.jpg"));
        Image editedimg1 = i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        i1 = new ImageIcon(editedimg1);
        JLabel lb1 = new JLabel(i1);
        lb1.setBounds(0,0,1000,700);
        add(lb1);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Images/back.png"));
        Image img1 = i2.getImage().getScaledInstance(75,50,Image.SCALE_DEFAULT);
        i2 = new ImageIcon(img1);
        back = new JButton(i2);
        back.setBounds(0,0 , 50,50);
        back.addActionListener(this);
        add(back);


        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void getdeatils(){
        // data fetching code
        conn  c = new conn();
        String query = "select gr,name,address,aadhar,phone,gender,bldgrp,dob from stud_details;";
        try{
            ResultSet rs = c.s.executeQuery(query);
            details.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new viewDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            new options();
            this.setVisible(false);
        }
    }
}