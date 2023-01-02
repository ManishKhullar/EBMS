//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.io.*;



public class Login extends JFrame implements ActionListener {
	JLabel label1, label2, label3;
	JTextField textfield1;
	JPasswordField passwordfield;
	JButton login;
	JComboBox combobox;
	Connection connection1;
	PreparedStatement pstatement;

	public Login(String title) {
		super(title);
		Container content = getContentPane();
		content.setBackground(Color.cyan);
	
		setLayout(null);
		JLabel banner = new JLabel("USER LOGIN");
		banner.setFont(new Font("Corbel", Font.BOLD + Font.ITALIC, 34));
		banner.setForeground(Color.blue);
		
		JPanel panel1, panel2, panel3, panel4, panel5;

		panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setLayout(new FlowLayout());
		label1 = new JLabel("User Category   ");
		String[] cmb = { "ASSISTANT ENGINEER" , "SENIOR MANAGER", "CASHIER" ,"ADMINISTRATOR"};
		combobox = new JComboBox(cmb);
		panel1.add(label1);
		panel1.add(combobox);

		panel2 = new JPanel();
		panel2.setBackground(Color.white);
		panel2.setLayout(new FlowLayout());
		label2 = new JLabel("User Name       ");
		textfield1 = new JTextField(15);
		panel2.add(label2);
		panel2.add(textfield1);

		panel3 = new JPanel();
		panel3.setBackground(Color.white);
		panel3.setLayout(new FlowLayout());
		label3 = new JLabel("Password         ");
		passwordfield = new JPasswordField(15);
		panel3.add(label3);
		panel3.add(passwordfield);

		panel4 = new JPanel();
		panel4.setBackground(Color.cyan);
		panel4.setLayout(new FlowLayout());
		login = new JButton("	LOGIN	", new ImageIcon("C:\\EBMS\\images\\login.png"));
		panel4.add(login);

		panel5 = new JPanel();
		panel5.setBackground(Color.cyan);
		panel5.setLayout(new GridLayout(3, 1));
		panel5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		panel5.add(panel1);
		panel5.add(panel2);
		panel5.add(panel3);

		banner.setBounds(160, 30, 200, 70);
		panel5.setBounds(80, 125, 320, 130);
		panel4.setBounds(150, 270, 170, 60);
		add(panel5);
		add(panel4);
		add(banner);
		login.addActionListener(this);
		textfield1.requestFocus();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity", "root", "");

		} catch (Exception connectivity) {
			 connectivity.printStackTrace();
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent query) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == login)

		{
			try {
				pstatement = connection1.prepareStatement("select password from login where username=? and password=? and mode=?");
				pstatement.setString(1, textfield1.getText().trim());
				pstatement.setString(2, passwordfield.getText().trim());
				pstatement.setString(3, combobox.getSelectedItem().toString().trim());
				ResultSet rs = pstatement.executeQuery();
				if (rs.next()) {
					String p = rs.getString(1);
					if (p.equals(passwordfield.getText().trim())) {
						int selected = combobox.getSelectedIndex();
						switch (selected) {
						case 0:
							System.out.println("Inside Senior assistant");
							String s0="you are logged successfully";
							JOptionPane.showMessageDialog(null,s0);
							SeniorManagr ss0 = new SeniorManagr("SENIOR MANAGER");
							ss0.setSize(1300,750);
							ss0.setBackground(Color.cyan);
							ss0.setVisible(true);
							this.setVisible(false);
							break;

						case 1:
							System.out.println("Inside Assistant Engineer");
							String s1="you are logged successfully";
							JOptionPane.showMessageDialog(null,s1);
							SeniorManagr_2 ss1 = new SeniorManagr_2("ASSISTANT ENGINEER");
							ss1.setSize(1300,750);
							ss1.setBackground(Color.cyan);
							ss1.setVisible(true);
							this.setVisible(false);
							break;

						case 2:
							System.out.println("Inside Cashier");
							String s2="you are logged successfully";
							JOptionPane.showMessageDialog(null,s2);
							SeniorManagr_3 ss2 = new SeniorManagr_3("CASHIER");
							ss2.setSize(1300,750);
							ss2.setBackground(Color.cyan);
							ss2.setVisible(true);
							this.setVisible(false);
							break;

						case 3:							
							System.out.println("Inside Administrator");
							String s3="you are logged successfully";
							JOptionPane.showMessageDialog(null,s3);
							SeniorManagr_4 ss3 = new SeniorManagr_4("ADMINISTRATOR");
							ss3.setSize(1300,750);
							ss3.setBackground(Color.cyan);
							ss3.setVisible(true);
							this.setVisible(false);
							break;
						default:
								JOptionPane.showMessageDialog(this, "Invalid!", "CAUTION", JOptionPane.WARNING_MESSAGE);
						}

					} 
					else
					{
						JOptionPane.showMessageDialog(this, "Invalid Password !", "Error", JOptionPane.WARNING_MESSAGE);
						passwordfield.setText("");
						passwordfield.requestFocus();
					}
				} 
				else 
				{
					JOptionPane.showMessageDialog(this, "Invalid User !", "Error", JOptionPane.WARNING_MESSAGE);
					textfield1.setText("");
					textfield1.requestFocus();
				}
			} 
			catch (Exception query) {
				 query.printStackTrace();

			}

		}
	}

	public static void main(String arg[]) {
		Login login = new Login("User Logon");

		login.setSize(500, 400);
		login.setLocation(300, 180);
		login.setVisible(true);
	}
}