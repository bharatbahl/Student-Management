import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class studentdetails {
    Connection con;
	Statement st;
        ResultSet rs;
        JFrame f=new JFrame("Student Details");
        JLabel l1=new JLabel("Full name : ");
        JTextField t1=new JTextField(50);
        JLabel l2=new JLabel("Date of Birth : ");
        JTextField t2=new JTextField(50);
        JLabel l3=new JLabel("VIT Gmail id : ");
        JTextField t3=new JTextField(50);
        JLabel l4=new JLabel("Program details : ");
        JTextField t4=new JTextField(50);
        JLabel l5=new JLabel("Registration Number : ");
        JTextField t5=new JTextField(50);
        public studentdetails()
        {
                connect();
                frame();
}
                 
        public void frame()
        {
            f.setSize(600,400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    l1.setForeground(new Color(179, 0, 0));
	    l2.setForeground(new Color(179, 0, 0));
	    l3.setForeground(new Color(179, 0, 0));
	    l4.setForeground(new Color(179, 0, 0));
	    l5.setForeground(new Color(179, 0, 0));
	    JPanel p=new JPanel();
            p.add(l1);
            p.add(t1);
            p.add(l2);
            p.add(t2);
            p.add(l3);
            p.add(t3);
            p.add(l4);
            p.add(t4);
            p.add(l5);
            p.add(t5);
            p.setBackground(new Color(255, 204, 204));
            f.add(p);
            
        }
        public void connect()
        {
            try
		{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from student_details where username='"+firstpage.t.getText()+"';");
		 while(rs.next())
			{
			 	t1.setText(rs.getString("name"));
				t2.setText(rs.getString("dob"));
				t3.setText(rs.getString("vitgmail"));
				t4.setText(rs.getString("prog"));
				t5.setText(rs.getString("regno"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        }
        
        
}
