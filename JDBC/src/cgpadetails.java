import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class cgpadetails extends JPanel {
    Connection con;
    Statement st;
    ResultSet rs;
        JFrame f=new JFrame("CGPA");
        JLabel l1=new JLabel("GPA in semester 1 : ");
        JTextField t1=new JTextField(5);
        JLabel l2=new JLabel("GPA in semester 2 : ");
        JTextField t2=new JTextField(5);
        JLabel l3=new JLabel("GPA in semester 3 : ");
        JTextField t3=new JTextField(5);
        JLabel l4=new JLabel("GPA in semester 4 : ");
        JTextField t4=new JTextField(5);
        JLabel l5=new JLabel("GPA in semester 5 : ");
        JTextField t5=new JTextField(5);
        JLabel l6=new JLabel("GPA in semester 6 : ");
        JTextField t6=new JTextField(5);
        JLabel l7=new JLabel("GPA in semester 7 : ");
        JTextField t7=new JTextField(5);
        JLabel l8=new JLabel("GPA in semester 8 : ");
        JTextField t8=new JTextField(5);
    
        public cgpadetails()
        {
            connect();
            frame();
        }
        
        public void frame()
        {
            f.setSize(300,400);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // f.setLayout(null);
	    f.setVisible(true);
	   l1.setForeground(new Color(0, 53, 102));
	   l2.setForeground(new Color(0, 53, 102));
	   l3.setForeground(new Color(0, 53, 102));
	   l4.setForeground(new Color(0, 53, 102));
	   l5.setForeground(new Color(0, 53, 102));
	  l6.setForeground(new Color(0, 53, 102));
	   l7.setForeground(new Color(0, 53, 102));
	  l8.setForeground(new Color(0, 53, 102));
	    //t1.setBounds(0, 0, 10, 10);
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
            p.add(l6);
            p.add(t6);
            p.add(l7);
            p.add(t7);
            p.add(l8);
            p.add(t8);
           p.setBackground(new Color(179, 218, 255));
            f.add(p);
        }
        public void connect()
        {
            try
		{
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from cgpahist where username='"+firstpage.t.getText()+"';");
		 
		 while(rs.next())
			{
			 t1.setText(rs.getString("sem1"));
			 t2.setText(rs.getString("sem2"));
			 t3.setText(rs.getString("sem3"));
			 t4.setText(rs.getString("sem4"));
			 t5.setText(rs.getString("sem5"));
			 t6.setText(rs.getString("sem6"));
			 t7.setText(rs.getString("sem7"));
			 t8.setText(rs.getString("sem8"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        }
}
