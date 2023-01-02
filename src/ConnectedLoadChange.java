//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class ConnectedLoadChange extends JInternalFrame implements ActionListener
 { 
	JLabel consumernumber,areacode,cl,presentconnectload,connectedloadchangeto;
	JComboBox combobox;
	JTextField present_connect_load,connected_load_change_to,area_code;
	JButton update,edit,cancel;
	
	public ConnectedLoadChange(String title)
  	{


		super("ConnectedLoadChange");
		setLayout(null);
		consumernumber=new JLabel("CONSUMER NUMBER");
		try{
			QueryData qd = new QueryData();
			Vector v = qd.getConsumer(); 
			combobox=new JComboBox(v);
			}
			catch(Exception ex)
			{System.out.println("Error in DataEnt " + ex);}
		
	
		combobox.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("AREACODE");
		
		String area[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
		
		area_code=new JTextField(5);
		area_code.setEditable(false);
		presentconnectload=new JLabel("Present Connected Load");
		present_connect_load=new JTextField(10);
		present_connect_load.setEditable(false);
		connectedloadchangeto=new JLabel("Connected Load Changed to");
		connected_load_change_to=new JTextField(10);
		update=new JButton("UPDATE");
		edit=new JButton("EDIT");
		cancel=new JButton("CANCEL");
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p5,p6;

		p1=new JPanel();
	
		p2=new JPanel();
		
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();

		p1.setLayout(layout);
		p2.setLayout(new GridLayout(2,2,10,10));
	
		p1. add(consumernumber);
		p1.add(combobox);
		p1.add(areacode);
		p1.add(area_code);
		p1.add(new JLabel("Choose an Area Code and Consumer Number"));
		p1.setPreferredSize(new Dimension(380,70));
		p2.add(presentconnectload);
		p2.add(present_connect_load);
		p2.add(connectedloadchangeto);
		p2.add(connected_load_change_to);

		/*p3.add(new JLabel("Note  :"));
		p3.add(note);*/

		p4.add(update);
		//p4.add(edit);
		p4.add(cancel);
		
		p5.add(p1);
		p5.add(p2);

		p5.setBounds(80,100,400,160);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		p5.setBorder(BorderFactory.createEtchedBorder());
		p3.setBounds(80,270,400,100);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		p4.setBounds(120,300,300,35);

		add(p5);
		//add(p3);
		add(p4);
		
		setSize(550,550);
		setLocation(150,80);
		setVisible(true);
		
		cancel.addActionListener(this);
		combobox.addActionListener(this);
		update.addActionListener(this);
		}	
		
		public void actionPerformed(ActionEvent e)
		{
			try{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
		
		                   else if(e.getSource()==combobox)
			{
				System.out.println("Selected consumer NO");
				

					
					QueryData qd = new QueryData();
					String id=(String)combobox.getSelectedItem();
					Vector v8 = qd.getConsumerDetails(id.trim()); 
					//Vector v9=qd.get
					System.out.println("Consumer Details  " + v8);
					System.out.println(id + "Tc " + v8 );
					Enumeration em=v8.elements();
					area_code.setText((String)em.nextElement());	
					String cl=qd.getCldetails(id);
					if(cl!=null)
						present_connect_load.setText(cl);
					
			
			}
			else if(e.getSource()==update)
			{
				
				
				System.out.println("OK");
                                                                             QueryData qd = new QueryData();
				Connection con = qd.getConnect();
					//update consumer set connectedload ='1922' where consumernumber='10'
				PreparedStatement st =con.prepareStatement("update consumer set connectedload=?  where consumer.consumernumber=?");
				//st.setString(1,"500");
				//st.setString(2,"10");
				st.setString(1,(String)connected_load_change_to.getText());
				st.setString(2,(String)combobox.getSelectedItem());
				
				int i=st.executeUpdate();
				if(i>0)
				System.out.println("Updated  ");
				JOptionPane.showInternalMessageDialog(this,"Connected Load Changed","CONNECTED LOAD ",1);
				
				
			}
		}catch(Exception ex){System.out.println("Error in Tc" + ex);}
	}
	
		
}