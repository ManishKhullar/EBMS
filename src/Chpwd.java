//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

	public class Chpwd extends JInternalFrame implements ActionListener
 { 
	JLabel userame,pswd1,pswd2,pswd3 ;
	
	JTextField username, pwd1,pwd2,pwd3;
	JButton ok,cancel;
	Connection conection;
	
	public Chpwd(String title)
  	{


		super("Change Password");
		setLayout(null);
		userame=new JLabel("User Name");
		username=new JTextField(10);
		//con_no.setPreferredSize(new Dimension(100,20));
		pswd1=new JLabel("Enter your password ");
		pwd1=new JTextField(10);
		pswd2=new JLabel("Enter new  password ");
		pwd2=new JTextField(10);
		pswd3=new JLabel("Confirm   password  ");
		pwd3=new JTextField(10);
		ok=new JButton("OK");
		cancel=new JButton("Cancel");
		
			JPanel p1,p2;
			p1=new JPanel();
		p1.setLayout(new GridLayout(4,2,0,5));
		p1.add(userame);
		p1.add(username);
		p1.add(pswd1);
		p1.add(pwd1);		
		p1.add(pswd2);
		p1.add(pwd2);
		p1.add(pswd3);
		p1.add(pwd3);
		
			p2=new JPanel();
		p2.setLayout(new GridLayout(1,2,5,5));
		p2.add(ok);
		p2.add(cancel);
		
		p1.setBounds(60,30,250,120);
		add(p1);
		
		p2.setBounds(100,155,200,30);
		add(p2);
		setLocation(200,150);
			cancel.addActionListener(this);
			ok.addActionListener(this);
			}
		
             public void actionPerformed(ActionEvent e)
		    {
			try{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
			else
			{
			Class.forName("com.mysql.jdbc.Driver");
			conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity","root","");
			PreparedStatement stmt = conection.prepareStatement("select count(*) from login where username=?");
			stmt.setString(1,username.getText().trim());
			ResultSet rs =stmt.executeQuery();				
			if(rs.next())
			{
				int i= rs.getInt(1);
				if(i>0)
				{
					stmt = conection.prepareStatement("update login set password =? where username=?");
					stmt.setString(1,pwd2.getText().trim());
					stmt.setString(2,username.getText().trim());
					int j=stmt.executeUpdate();
					if(j>0)
						System.out.println("Password Changed");
					JOptionPane.showMessageDialog(this,"Password Changed Sucessfully");
				}else
			                 {
				System.out.println("inside");
				JOptionPane.showMessageDialog(this,"User Not Exists  !","Invalid User ",1);   
			                 }
			}
			
		            }
		        }
			catch(Exception ex){System.out.println("ERRor : "+ex);}    
	}
		
		
	

		public static void main(String arg[])
		{
		Chpwd chp= new Chpwd("CHANGE PASSWORD");
			chp.setSize(420,270);
			chp.setVisible(true);
	    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package electricity;

/**
 *
 * @author ASUS
 */
//public class Chpwd { }