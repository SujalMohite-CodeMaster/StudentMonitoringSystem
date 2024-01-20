package sms;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewMarks extends JFrame implements ActionListener {
    JTabbedPane tabs;
    JScrollPane sp1, sp2;
    JTable sem1, sem2;
    Font f1 = new Font("Tahoma", Font.BOLD, 12);
    JButton addmarks , back;

    viewMarks() {
        setSize(1000, 700);
        tabs = new JTabbedPane();
        tabs.setBounds(400, 100, 550, 400);
        tabs.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(tabs);
        sem1 = new JTable();
        sem1.setFont(f1);
        sem1.setRowHeight(22);
        sem2 = new JTable();
        sem2.setFont(f1);
        sem2.setRowHeight(22);
        sp1 = new JScrollPane();
        sp1.setViewportView(sem1);
        sp2 = new JScrollPane();
        sp2.setViewportView(sem2);
        getdetails();
        tabs.addTab("SEM 1", sp1);
        tabs.addTab("SEM 2", sp2);
        addmarks = new JButton("Add/Update");
        addmarks.setBounds(120, 100, 200, 50);
        addmarks.setFont(new Font("Tahoma", Font.BOLD, 25));
        addmarks.setBackground(Color.black);
        addmarks.setForeground(Color.white);
        addmarks.addActionListener(this);
        add(addmarks);

        JTableHeader th1 = sem1.getTableHeader();
        th1.setFont(new Font("Tahoma", Font.BOLD, 16));
        th1.setBackground(Color.orange);
        JTableHeader th2 = sem2.getTableHeader();
        th2.setFont(new Font("Tahoma", Font.BOLD, 16));
        th2.setBackground(Color.orange);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/b2.jpg"));
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

    void getdetails() {
        conn c = new conn();
        // sem 1 marks fetching code .
        String query1 = "select gr,name,english,maths,science from stud_details;";
        try {
            ResultSet rs1 = c.s.executeQuery(query1);
            sem1.setModel(DbUtils.resultSetToTableModel(rs1));
        } catch (Exception e) {
            System.out.println(e);
        }
        // sem 2 marks fetching code .
        String query2 = "select gr,name,marathi,history,geography from stud_details; ";
        try {
            ResultSet rs2 = c.s.executeQuery(query2);
            sem2.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==addmarks) {
            new addMarks();
            this.setVisible(false);
        }

        if(ae.getSource()==back){
            new options();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new viewMarks();
    }


}

