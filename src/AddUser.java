//package updated1;
		import java.awt.*;
		import javax.swing.*;
		import java.awt.event.*;
		import java.sql.*;
		import javax.swing.border.*;

		public class AddUser extends JInternalFrame implements ActionListener
		 { 
			JLabel userame,pswd1,pswd2,mode ;
			
			JTextField username,password,password1;
			JButton ok,cancel;
			JComboBox mode1;
			Connection conection;
			public AddUser(String title)
		  	{


				super("USER ADMINISTRATION");
				setLayout(null);
				userame=new JLabel("User Name");
				username=new JTextField(10);
				pswd1=new JLabel("Password            ");
				password=new JTextField(10);
				pswd2=new JLabel("Confirm Password    ");
				password1=new JTextField(10);
				ok=new JButton("OK");
				mode = new JLabel("Mode");
				
				String[] cmb = {"ASSISTANT ENGINEER" , "SENIOR ASSISTANT", "CASHIER" ,"ADMINISTRATOR"};
				mode1 = new JComboBox(cmb);
				cancel=new JButton("Cancel");
				
					JPanel p1,p2;
					p1=new JPanel();
				p1.setLayout(new GridLayout(4,5,7,3));
				p1.add(userame);
				p1.add(username);
				p1.add(pswd1);
				p1.add(password);		
				p1.add(pswd2);
				p1.add(password1);
				p1.add(mode);
				p1.add(mode1);
				p2=new JPanel();
				p2.setLayout(new GridLayout(1,2,15,5));
				p2.add(ok);
				p2.add(cancel);
				p1.setBounds(60,30,300,90);
				add(p1);
				p2.setBounds(100,130,200,30);
				add(p2);
				setLocation(250,150);
					cancel.addActionListener(this);
					ok.addActionListener(this);
					}
				
		        public void actionPerformed(ActionEvent e)
			    {    
				 try
				 {
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
							int i = rs.getInt(1);
							if(i>0)
								JOptionPane.showInternalMessageDialog(this,"User Alread Exists  !","Invalid User ",1);
							else if(password.getText().equals(password1.getText()))
								{
									stmt = conection.prepareStatement("insert into login values(?,?,?)");
	                                if(username.getText().equals("") || password.getText().equals(""))
	                                {
	       								JOptionPane.showInternalMessageDialog(this, "Could not be blank", "NULL PARAMETER ", 1);
										JOptionPane.showInternalMessageDialog(this, "User add Failed  !", " TRY AGAIN !!!", 1);
									}
	                                else
					               {
							            stmt.setString(1,username.getText().trim());
										stmt.setString(2,password.getText().trim());
										stmt.setString(3,mode1.getSelectedItem().toString().trim());
										JOptionPane.showInternalMessageDialog(this, "User added Succesfully  !", "Confirm Password ", 1);
										int j = stmt.executeUpdate();
										if(j>0)
											System.out.println("Added USer");
									}
								}	
						}
					}
				 }	
		catch(Exception ex)
		{
					 System.out.println(ex);
		 }			
	}
	public static void main (String args[])
	{
			/*AddUser au = new AddUser("ADD USER");
			au.setSize(400,250);
	        au.setVisible(true);*/		
	}
}