import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class academicdetails {
    Connection con;
	Statement st;
        ResultSet rs,rs1;
        JFrame f=new JFrame("Academic History");
        JLabel stu=new JLabel();
        JLabel stu1=new JLabel();
        
        JTextField course1=new JTextField(20);
        JTextField grade1=new JTextField();
        JTextField course2=new JTextField(20);
        JTextField grade2=new JTextField();
        JTextField course3=new JTextField(20);
        JTextField grade3=new JTextField();
        JTextField course4=new JTextField(20);
        JTextField grade4=new JTextField();
        JTextField course5=new JTextField(20);
        JTextField grade5=new JTextField();
        JTextField course6=new JTextField(20);
        JTextField grade6=new JTextField();
        JTextField course7=new JTextField(20);
        JTextField grade7=new JTextField();
        JTextField course8=new JTextField(20);
        JTextField grade8=new JTextField();
        JTextField course9=new JTextField(20);
        JTextField grade9=new JTextField();
        JTextField course10=new JTextField(20);
        JTextField grade10=new JTextField();
        public academicdetails()
        {
                connect();
                frame();
}
                 
        public void frame()
        {
            f.setSize(600,400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    
	    JPanel p=new JPanel();
	    p.add(stu);
	    p.add(stu1);
            p.add(course1);
            p.add(grade1);
            p.add(course2);
            p.add(grade2);
            p.add(course3);
            p.add(grade3);
            p.add(course4);
            p.add(grade4);
            p.add(course5);
            p.add(grade5);
            p.add(course6);
            p.add(grade6);
            p.add(course7);
            p.add(grade7);
            p.add(course8);
            p.add(grade8);
            p.add(course9);
            p.add(grade9);
            p.add(course10);
            p.add(grade10);
            p.setBackground(new Color(230, 204, 255));
            f.add(p);
            
        }
        public void connect()
        {
            try
		{
            	stu.setText(firstpage.t.getText()+" your academic history is as follows : ");
            	stu1.setText("                                                  ");
            	
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from acadhist where username='"+firstpage.t.getText()+"';");
		 
		 while(rs.next())
			{
			 course1.setText(rs.getString("c1"));
							course2.setText(rs.getString("c2"));
				
				course3.setText(rs.getString("c3"));
				
				course4.setText(rs.getString("c4"));
				
				course5.setText(rs.getString("c5"));
				
				course6.setText(rs.getString("c6"));
				
				course7.setText(rs.getString("c7"));
				
				course8.setText(rs.getString("c8"));
				
				course9.setText(rs.getString("c9"));
				
				course10.setText(rs.getString("c10"));
				
			}
		 rs1=st.executeQuery("select * from gradehist where username='"+firstpage.t.getText()+"';");
		 while(rs1.next())
			{
			
				grade1.setText(rs1.getString("g1"));
				
				grade2.setText(rs1.getString("g2"));
				
				grade3.setText(rs1.getString("g3"));
				
				grade4.setText(rs1.getString("g4"));
				
				grade5.setText(rs1.getString("g5"));
				
				grade6.setText(rs1.getString("g6"));
				
				grade7.setText(rs1.getString("g7"));
				
				grade8.setText(rs1.getString("g8"));
				
				grade9.setText(rs1.getString("g9"));
				
				grade10.setText(rs1.getString("g10"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        }
        
        
}
