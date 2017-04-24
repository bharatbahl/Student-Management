import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
public class attendancedetails extends JPanel {
    Connection con;
    Statement st;
    ResultSet rs;
    Graphics g;
    private static final int NUM_OF_ITEMS = 20;
    private static final int DIM_W = 400;
    private static final int DIM_H = 400;
    private static final int HORIZON = 350;
    private static final int VERT_INC = 15;
    private static final int HOR_INC = DIM_W / NUM_OF_ITEMS;

    int a[]=new int[5];
    JFrame f=new JFrame("Attendance");
        JLabel l1=new JLabel("Attendance of Subject 1 ");
        JTextField t1=new JTextField(25);
        JLabel l2=new JLabel("Attendance of Subject 2 : ");
        JTextField t2=new JTextField(25);
        JLabel l3=new JLabel("Attendance of Subject 3 : ");
        JTextField t3=new JTextField(25);
        JLabel l4=new JLabel("Attendance of Subject 4 : ");
        JTextField t4=new JTextField(25);
        JLabel l5=new JLabel("Attendance of Subject 5 : ");
        JTextField t5=new JTextField(25);
     
    public attendancedetails()
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
            p.setBackground(new Color(184, 184, 148));
            f.add(p);
            p.repaint();
        }
        public void connect()
        {
            try
		{
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","password");
		 st =con.createStatement();
		 rs=st.executeQuery("select * from attendance where username='"+firstpage.t.getText()+"';");
		 while(rs.next())
			{
			 //stu1.setText(rs.getString("subject1")+"  "+rs.getString("subject2")+"  "+rs.getString("subject3")+"  "+rs.getString("subject4")+"  "+rs.getString("subject5"));
				t1.setText(rs.getString("m1"));
				a[0]=Integer.parseInt(rs.getString("m1"));
				t2.setText(rs.getString("m2"));
				a[1]=Integer.parseInt(rs.getString("m2"));
				t3.setText(rs.getString("m3"));
				a[2]=Integer.parseInt(rs.getString("m3"));
				t4.setText(rs.getString("m4"));
				a[3]=Integer.parseInt(rs.getString("m4"));
				t5.setText(rs.getString("m5"));
				a[4]=Integer.parseInt(rs.getString("m5"));
			}
		 
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        }
        
        }
    

