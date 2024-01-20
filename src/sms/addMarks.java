package sms;
import net.proteanit.sql.DbUtils;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class addMarks extends JFrame implements ActionListener {
    int dist_x= 30,height = 40,width = 100;// for lables
    int x= 190 ;// for textfields
    JTextField gr ,english,maths,history,marathi,science,geography;
    JLabel l1,eng,mara,math,geo,sci,hist;
    JButton display,update1,update2;
    JTabbedPane tabs;
    JPanel p1 ,p2 ;
    //p1 panel conntains screollplane where the data will fetch and marks that we enterd for sem 1 tab.
            // p2 panel conntains scrollplane where the data will fetch and marks that we enterd for sem 2 tab.
            JScrollPane sp1 ,sp2;
    JTable sem1 , sem2;
    JButton back;
    Font f1 = new Font("Tahoma",Font.PLAIN,25);
    Font f2 = new Font("Tahoma",Font.BOLD,20);
    addMarks(){
        setSize(650,650);
        l1 = new JLabel("ENTER GR ");
        l1.setBounds(120,50,150,50);
        l1.setFont(f1);
        l1.setForeground(Color.black);
        add(l1);
        gr = new JTextField();
        gr.setBounds(250,60,80,40);
        gr.setFont(f1);
        add(gr);
        display = new JButton("Display");
        display.setBounds(400,50,150,50);
        display.setFont(f1);
        display.setForeground(Color.BLACK);
        display.setBackground(Color.ORANGE);
        display.addActionListener(this);
        add(display);
        tabs = new JTabbedPane();
        tabs.setBounds(40,140,550,450);
        tabs.setFont(f2);
        add(tabs);
        sem1 = new JTable();
        sem2 = new JTable();
        p1 = new JPanel();// intialize p1 panel
        p1.setLayout(null);//setlayout null kiya quiki automatic flow index me chala jaata hai isiliye setlayout null karna padta hai.
        p2 = new JPanel();//initialize p2 panel
        p2.setLayout(null);
        tabs.addTab("SEM 1",p1);//p1 container fitted inside the  sem1 tab.
        tabs.addTab("SEM 2",p2);//p2 container fitted inside the sem2 tab.
        sp1 = new JScrollPane();//initialize sp1 scrollpane
        p1.add(sp1);//panel p1 ke upper sp1 ye scrollpane add kiya
        sp1.setBounds(30,40,490,80);
        sp1.add(sem1);
        sp2 = new JScrollPane();//iniitialize sp2 scrollpane
        p2.add(sp2);//panel p2 ke upper sp2 ye scrollpane add kiya
        sp2.setBounds(30,40,490,80);
        sp1.setViewportView(sem1);
        sp2.setViewportView(sem2);
        sem1 = new JTable();
        sem1.setRowHeight(35);
        sem1.setFont(new Font("Tahoma",Font.BOLD,14));
        sp1.setViewportView(sem1);
        sem2 = new JTable();
        sem2.setFont(f2);
        sem2.setRowHeight(35);
        sp2.setViewportView(sem2);
        JTableHeader th1 = sem1.getTableHeader();
        th1.setFont(new Font("Tahoma",Font.BOLD,14));
        th1.setBackground(Color.orange);
        JTableHeader th2= sem2.getTableHeader();
        th2.setFont(f2);
        th2.setBackground(Color.orange);
        // code for lables
        eng = new JLabel("ENGLISH");
        eng.setBounds(dist_x,150,width,height);
        eng.setFont(f2);
        p1.add(eng);
        sci = new JLabel("SCIENCE");
        sci.setBounds(dist_x,220,width,height);
        sci.setFont(f2);
        p1.add(sci);
        math = new JLabel("MATHS");
        math.setBounds(dist_x,290,width,height);
        math.setFont(f2);
        p1.add(math);
        // code for textfields
        english = new JTextField();
        english.setBounds( x,150,width,height);
        english.setFont(f1);
        p1.add(english);
        maths = new JTextField();
        maths.setBounds(x,220,width,height);
        maths.setFont(f1);
        p1.add(maths);
        science = new JTextField();
        science.setBounds(x,290,width,height);
        science.setFont(f1);
        p1.add(science);
        update1 = new JButton("Update");
        update1.setBounds(350,220,150,50);
        update1.setFont(f1);
        update1.setForeground(Color.black);
        update1.setBackground(Color.lightGray);
        update1.addActionListener(this);
        p1.add(update1);
        mara = new JLabel("MARATHI");
        mara.setBounds(dist_x,150,width,height);
        mara.setFont(f2);
        p2.add(mara);
        hist = new JLabel("HISTORY");
        hist.setBounds(dist_x,220,width,height);
        hist.setFont(f2);
        p2.add(hist);
        geo = new JLabel("GEOGRAPHY");
        geo.setFont(f2);
        geo.setBounds(dist_x,290,width+50,height);
        p2.add(geo);
        marathi = new JTextField();
        marathi.setFont(f2);
        marathi.setBounds(x,150,width,height);
        p2.add(marathi);
        history = new JTextField();
        history.setBounds(x,220,width,height);
        history.setFont(f2);
        p2.add(history);
        geography = new JTextField();
        geography.setFont(f2);
        geography.setBounds(x,290,width,height);
        p2.add(geography);
        update2 = new JButton("Update");
        update2.setFont(f1);
        update2.setBounds(350,220,150,50);
        update2.setBackground(Color.lightGray);
        update2.setForeground(Color.black);
        update2.addActionListener(this);
        p2.add(update2);


        ImageIcon passwordimage = new
                ImageIcon(ClassLoader.getSystemResource("Images/b12.jpg"));
        JLabel label = new JLabel(passwordimage);
        Image editedpasswordimage =
                passwordimage.getImage().getScaledInstance(480,480,Image.SCALE_DEFAULT);
        passwordimage = new ImageIcon(editedpasswordimage);
        label.setBounds(0,0,650,650);
        add(label);

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
    public static void main(String[] args) {
        new addMarks();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==display){
            String gr = this.gr.getText();
            conn c = new conn();
            //  query to fetch sem1 marks
            String query1 ="select name ,english,maths,science from stud_details where gr = '"+gr+"';";
            try{
                ResultSet rs1 = c.s.executeQuery(query1);
                sem1.setModel(DbUtils.resultSetToTableModel(rs1));
            }catch (Exception ae){
                System.out.println(ae);
            }
            // query to fetch sem2 marks
            String query2 = "select name,marathi,history,geography from stud_details where gr = '"+gr+"';";
            try{
                ResultSet rs2 =  c.s.executeQuery(query2);
                sem2.setModel(DbUtils.resultSetToTableModel(rs2));
            }catch(Exception be){
                System.out.println(be);
            }
        }
        if (e.getSource()==update1){
            String english = this.english.getText();
            String maths = this.maths.getText();
            String science = this.science.getText();
            String gr = this.gr.getText();
            conn c = new conn();
            String query = "update stud_details set english = '"+english+"', maths = '"+maths+"', science = '"+science+"' where gr = '"+gr+"';";
            try{
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null," Data Updated Successfully !");
            }catch (Exception ce){
                System.out.println(ce);
                JOptionPane.showMessageDialog(null,"some error occured !");
            }
        }
        if (e.getSource()==update2){
            String marathi = this.marathi.getText();
            String history = this.history.getText();
            String geography = this.geography.getText();
            String gr = this.gr.getText();
            try {
                conn c = new conn();
                String query = "update stud_details set marathi = '" + marathi + "', history = '" + history + "', geography = '" + geography + "' where gr = '"+gr+"';";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data Updated Successfully !");
            }catch (Exception de){
                System.out.println(de);
                JOptionPane.showMessageDialog(null,"some error occured !");
            }
        }
        if (e.getSource()==back){
            new viewMarks();
            this.setVisible(false);
        }
    }
}