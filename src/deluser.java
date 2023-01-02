//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class deluser extends JInternalFrame implements ActionListener {
	JLabel userame, pswd1, pswd2, Mode;
	// (add code for mode dropdown)

	JTextField username, password, password1;
	JButton ok, cancel;
	Connection con;

	public deluser(String title) {

		super("Delete User");
		setLayout(null);
		userame = new JLabel("User Name");
		username = new JTextField(10);
		// con_no.setPreferredSize(new Dimension(100,20));
		pswd1 = new JLabel("Password");
		password = new JTextField(10);
		pswd2 = new JLabel("Confirm Password");
		ok = new JButton("OK");
		cancel = new JButton("Cancel");

		JPanel p1, p2;
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 2, 7, 3));
		p1.add(userame);
		p1.add(username);
		p1.add(pswd1);
		p1.add(password);
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1, 2, 15, 5));
		p2.add(ok);
		p2.add(cancel);

		p1.setBounds(60, 30, 250, 90);
		add(p1);

		p2.setBounds(100, 170, 200, 30);

		add(p2);
		setLocation(250, 150);
		cancel.addActionListener(this);
		ok.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			if (e.getSource() == cancel) 
			{
				this.dispose();
			} 
			else 
			{
				try 
				{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root", "");
	            String nm=username.getText();
                Statement stmt;
				String SQL ="delete from login where username='"+nm+"'";
				stmt=con.prepareStatement(SQL);
//              stmt.setString(1,nm);
//				stmt.setString(2,password.getText());
      			int i=stmt.executeUpdate(SQL);
                if(i!=0)
                	JOptionPane.showInternalMessageDialog(this, "User Deleted  !", "Confirm deletion ",	1);
                else
                	JOptionPane.showInternalMessageDialog(this, "User Not Deleted  !", " ",	1);
                                    
				}
				catch (SQLException e1) { System.out.println(e1);}
			}
		}
		catch (Exception ex) {
			 ex.printStackTrace();
		}
	}			
	/*public static void main(String arg[]) 
	{
		
		  deluser dl= new deluser("delete USER"); dl.setSize(400,250);
		  dl.setVisible(true);
	}*/
}