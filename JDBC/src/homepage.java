import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class homepage {
	Connection con;
	Statement st;
	ResultSet rs;
	JFrame f=new JFrame("welcome!");
	JButton b0=new JButton("Display details");
	JButton b=new JButton("Subjects");
	JButton b1=new JButton("Marks");
	JButton b3=new JButton("CGPA");
	JButton b2=new JButton("Academic History");
	JButton b4=new JButton("Attendance");
	JButton b5=new JButton("Proctor");
	public static void main(String[] args) {
	new firstpage();
	}
	public homepage()
	{
		connect();
		frame();
		
	}
	private void connect() {
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
		
public void frame()
	{
		f.setSize(400,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p=new JPanel();
		p.add(b0);
		p.add(b);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.setBackground(new Color(0, 179, 179));
		f.add(p);
		f.setVisible(true);
		b0.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new studentdetails();
						}
					});
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new subjectdetails();
				
			}
			
		});
		b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new marksdetails();
				
			}
			
		});
		b2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new academicdetails();
				
			}
			
		});
		b3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new cgpadetails();
				
			}
			
		});
		b4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new attendancedetails();
			}
	});
		b5.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new proctor();
			}
			
		});
}
}


