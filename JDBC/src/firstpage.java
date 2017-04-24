import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class firstpage {
	Connection con;
	Statement st;
	ResultSet rs;
	JFrame f=new JFrame("Login System");
	JLabel l=new JLabel("Username");
	JLabel l1=new JLabel("Password");
	static JTextField t= new JTextField(10);
	static JPasswordField t1=new JPasswordField(10);
	JButton b=new JButton("Login");
	String databaseusername;
	String databasepassword;
	Scrollbar sbh,sbv;
	public static void main(String[] args) {
	new firstpage();
	}
	public firstpage()
	{
		connect();
		frame();
		
	}
	public void frame()
	{
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*JPanel q=new JPanel();
		JLabel l2=new JLabel("Student Portal");
		q.setSize(100,100);
		q.setVisible(true);
		q.add(l2);*/
		
		JPanel p=new JPanel();
		l.setFont(new Font("Ariel",Font.ITALIC,20));
		p.add(l);
		p.add(t);
		l1.setFont(new Font("Ariel",Font.ITALIC,20));
		p.add(l1);
		p.add(t1);
		p.add(b);
		p.setBackground(new Color(64, 128, 191));
	
		f.add(p);
		//sbv=new Scrollbar(Scrollbar.VERTICAL,0,1,0,50);
		//sbh=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,50);
		//f.add(sbv);
		//f.add(sbh);
		//JLabel i=new JLabel(new ImageIcon("C:\\Users\\This Pc\\Desktop\\vit1.png"));
		//i.setMinimumSize(i.getMinimumSize());
		//f.add(i);
		f.setVisible(true);
		l.setForeground(new Color(96, 64, 32));
		l1.setForeground(new Color(96, 64, 32));
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				String user=t.getText().trim();
				String password=t1.getText().trim();
				String SQL = "SELECT * FROM userlogin WHERE username='" + user + "' && password='" + password+ "'";

			    ResultSet rs = st.executeQuery(SQL);

			            
			    while (rs.next()) {
			        databaseusername = rs.getString("username");
			        databasepassword = rs.getString("password");
			    }

			    if (user.equals(databaseusername) && password.equals(databasepassword)) {
			    	new homepage();
			        f.setVisible(false);
			   //System.out.println("Successful Login!\n----");
			    } else {
			    	JOptionPane.showMessageDialog(null, "Enter correct details");
			        System.out.println("Incorrect Password\n----");
			    }
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

