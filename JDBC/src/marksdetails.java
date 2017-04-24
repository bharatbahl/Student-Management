import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class marksdetails {
    Connection con;
    Statement st;
    ResultSet rs;
    JFrame f=new JFrame("Marks");
        JLabel l1=new JLabel("Marks of Subject 1 ");
        JTextField t1=new JTextField(25);
        JLabel l2=new JLabel("Marks of Subject 2 : ");
        JTextField t2=new JTextField(25);
        JLabel l3=new JLabel("Marks of Subject 3 : ");
        JTextField t3=new JTextField(25);
        JLabel l4=new JLabel("Marks of Subject 4 : ");
        JTextField t4=new JTextField(25);
        JLabel l5=new JLabel("Marks of Subject 5 : ");
        JTextField t5=new JTextField(25);
     
    public marksdetails()
    {
        connect();
        frame();
    }
    
    public void frame()
    {
        
            f.setSize(400, 400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
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
            f.add(p);
        }
        public void connect()
        {
            try
		{
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from marks_details where username='"+firstpage.t.getText()+"';");
		 while(rs.next())
			{
			 //stu1.setText(rs.getString("subject1")+"  "+rs.getString("subject2")+"  "+rs.getString("subject3")+"  "+rs.getString("subject4")+"  "+rs.getString("subject5"));
				t1.setText(rs.getString("m1"));
				t2.setText(rs.getString("m2"));
				t3.setText(rs.getString("m3"));
				t4.setText(rs.getString("m4"));
				t5.setText(rs.getString("m5"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        }
    }

