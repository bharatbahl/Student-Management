import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class subjectdetails {
	Connection con;
	Statement st;
	ResultSet rs;
	JFrame f=new JFrame("Your Subjects this sem : ");
	JLabel stu=new JLabel();
	JTextField jt1=new JTextField(20);
	JTextField jt2=new JTextField(20);
	JTextField jt3=new JTextField(20);
	JTextField jt4=new JTextField(20);
	JTextField jt5=new JTextField(20);
	
	JLabel stu1=new JLabel();
	public static void main(String[] args) {
	new firstpage();
	}
	public subjectdetails()
	{
		connect();
		frame();
		
	}
	private void connect() {
		try
		{
			stu.setText(firstpage.t.getText()+" your subjects are as follows : ");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from subject_details where username='"+firstpage.t.getText()+"';");
		 while(rs.next())
			{
			 //stu1.setText(rs.getString("subject1")+"  "+rs.getString("subject2")+"  "+rs.getString("subject3")+"  "+rs.getString("subject4")+"  "+rs.getString("subject5"));
				jt1.setText(rs.getString("subject1"));
				jt2.setText(rs.getString("subject2"));
				jt3.setText(rs.getString("subject3"));
				jt4.setText(rs.getString("subject4"));
				jt5.setText(rs.getString("subject5"));
			}
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
public void frame()
	{
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p=new JPanel();
		p.add(stu);
		p.add(stu1);
		p.add(jt1);
		p.add(jt2);
		p.add(jt3);
		p.add(jt4);
		p.add(jt5);
		p.setBackground(new Color(255, 255, 153));
		f.setVisible(true);
		f.add(p);
	}
}


