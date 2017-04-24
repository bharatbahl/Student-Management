import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class login {
	Connection con;
	Statement st;
	
	JFrame f=new JFrame("Login System");
	JLabel l=new JLabel("username");
	JLabel l1=new JLabel("password");
	JTextField t= new JTextField(10);
	JTextField t1=new JTextField(10);
	JButton b=new JButton("Login");
	
	public static void main(String[] args) {
	new login();
	}
	public login()
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
		p.add(l);
		p.add(t);
		p.add(l1);
		p.add(t1);
		p.add(b);
		f.add(p);
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				String user=t.getText().trim();
				String password=t1.getText().trim();
				String sql="insert into userlogin values('"+user+"','"+password+"');";
				st.executeUpdate(sql);
				System.out.println("Data inserted");
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
		
	}
	public void connect()
	{
		try
		{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
