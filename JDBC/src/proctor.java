import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class proctor {
    Connection con;
    Statement st;
    ResultSet rs;
    JFrame f=new JFrame("Proctor");
    JLabel l1=new JLabel();
    JLabel l2=new JLabel();
    JLabel l3=new JLabel();
    JLabel l4=new JLabel();
    JLabel l5=new JLabel("Write a message to proctor : ");
    JTextArea a1=new JTextArea(20,20);
    JButton b1=new JButton("Send : ");
public proctor()
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
	    	l1.setForeground(new Color(38, 77, 0));
            p.add(l1);
            l2.setForeground(new Color(38, 77, 0));
            p.add(l2);
            l3.setForeground(new Color(38, 77, 0));
            p.add(l3);
            l4.setForeground(new Color(38, 77, 0));
            p.add(l4);
            l5.setForeground(new Color(38, 77, 0));
            p.add(l5);
            p.add(a1);
            p.add(b1);
            p.setBackground(new Color(204, 255, 153));
            f.add(p);
        }
        public void connect()
        {
            try
		{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from proctor where username='"+firstpage.t.getText()+"';");
		 while(rs.next())
			{
			 //stu1.setText(rs.getString("subject1")+"  "+rs.getString("subject2")+"  "+rs.getString("subject3")+"  "+rs.getString("subject4")+"  "+rs.getString("subject5"));
				l1.setText("Name of Proctor : "+rs.getString("name")+"  | ");
				l2.setText("Cabin Number : "+rs.getString("cabin")+"  | ");
				l3.setText("Email id : "+rs.getString("email")+"  | ");
				l4.setText("Phone Number : "+ rs.getString("phone"));
				
			}
		 b1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String sql="insert into messages"+" values ('"+firstpage.t.getText()+"','"+a1.getText()+"');";
				try {
					st.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Data Inserted");
				
			}
			 
		 });
		 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        }
    }    


