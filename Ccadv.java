//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;

public class Ccadv extends JInternalFrame implements ActionListener,FocusListener
 { 
	JLabel conno,areacode,daycode,mtrcode,cdavailable,cdrefund,dmd;
	JComboBox combobox,periodcombobox;
	JTextField cd_available,cd_refund,demand,rbt,amt,m_rent,tot,area_code,day_code,mtr_code;
	JTextArea note;
	JButton ok,edit,cancel;
	
	
	public Ccadv (String title)
  	{


		super("ADVANCE PAYMENT");
		setLayout(null);
		conno=new JLabel("Consumer Number");

			try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		combobox=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		combobox.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		area_code=new JTextField(10);
		area_code.setEditable(false);
		mtrcode=new JLabel("Meter Reader Code");
		mtr_code=new JTextField (10);
		mtr_code.setEditable(false);
		cdavailable=new JLabel("CD amount available");
		cd_available=new JTextField();
		dmd=new JLabel("Demand to be adjusted");
		demand=new JTextField(10); //read from the database
		cdrefund=new JLabel("CD refundable");
		cd_refund=new JTextField(10);
		
		ok=new JButton("OK");
		cancel=new JButton("Cancel");
		edit=new JButton("Edit");
		
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p5;
		p1=new JPanel();
		p1.setLayout(new GridLayout(3,2,0,0));
		p1. add(conno);
	    	p1.add(combobox);
		p1.add(areacode);
		p1.add(area_code);
		p1. add(mtrcode);
		p1.add(mtr_code);
				
		p1.setBounds(80,100,250,60);
		add(p1);
		
		p3=new JPanel();
		String p[]={"6","12"};
		p3.setLayout(new GridLayout(5,2,0,5));
		JLabel period=new JLabel("Period in months");
		periodcombobox=new JComboBox(p);
		p3.add(period);     
		p3.add(periodcombobox);
		
		JLabel amount=new JLabel("Expected C C");
		amt=new JTextField(10);
		p3.add(amount);     
		p3.add(amt);
		
		
		JLabel mrent=new JLabel("Expected M R");
		m_rent=new JTextField(10);
		p3.add(mrent);     
		p3.add(m_rent);
		
		
		JLabel rebate=new JLabel("Rebate");
		rbt=new JTextField();
		p3.add(rebate);        
		p3.add(rbt);
		
		JLabel total=new JLabel("TOTAL");
		tot=new JTextField();
		p3.add(total);        
		p3.add(tot);
		
		
		p3.setBounds(50,180,280,120);
		add(p3);
		      
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
		
	
		
		p4.setBounds(100,400,200,30);
		add(p4);
		
		
		JLabel advpay=new JLabel("Make advance payment");
		p5=new JPanel();
			p5.setLayout(new GridLayout(1,2,10,0));

		p5.add(advpay);
		p5.add(ok);
		
		p5.setBounds(50,340,290,30);
		add(p5);
		
		
			JLabel cd=new JLabel("ADVANCE PAYMENT");
			
		cd.setFont(new Font("Times New Roman",Font.BOLD,20));
		cd.setForeground(new Color(50,150,20));
		
		JPanel p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(20,15,350,30);
     			p6.add(cd);
     		     add(p6);
     		     
     		     	setLocation(250,70);
     		     
     		     cancel.addActionListener(this);
				 combobox.addActionListener(this);
				 ok.addActionListener(this);
				m_rent.addFocusListener(this);
     		     }
		      public void focusLost(FocusEvent e)
		     {
				 if(e.getSource()==m_rent)    
				     
				{
				                   System.out.println("Lost Focused from MR");
					String period= (String)periodcombobox.getSelectedItem();
					if(period.equals("6"))
					{
						//long d = Long.parseLong((periodcombobox.getText()).trim());
						long fc = Long.parseLong((amt.getText()).trim());
						long mr = Long.parseLong((m_rent.getText()).trim());
				
						long f=(fc+mr)*2/100;
						rbt.setText(""+f);
						tot.setText(""+(fc+mr-f));
						System.out.println(rbt.getText());
					
					}
							
					else
					{
						//long d = Long.parseLong((periodcombobox.getText()).trim());
						long fc = Long.parseLong((amt.getText()).trim());
						long mr = Long.parseLong((m_rent.getText()).trim());
				
						long f=(fc+mr)*4/100;
						rbt.setText(""+f);
						tot.setText(""+(fc+mr+f));
						System.out.println(rbt.getText());
					
					}

				}

					
		    }
		    public void focusGained(FocusEvent e)
		    {}
     		     public void actionPerformed(ActionEvent e)
     		     {
     		     	if(e.getSource()==cancel)
     		     	{
     		     		this.dispose();
     		     	}
     		     

				else if(e.getSource()==combobox)
				{
					System.out.println("Entered   CON_NO");
					
			
						try{

				QueryData qd = new QueryData();
				System.out.println((String)combobox.getSelectedItem());
				String id=(String)combobox.getSelectedItem();
				 
				Vector v = qd.getAreaCode(id);
				Enumeration em = v.elements();
				area_code.setText((String)em.nextElement());
				mtr_code.setText((String)em.nextElement()); 
				
							}
				catch(Exception ex)
					{
					System.out.println("Error in CC ADV: " + ex);
					}		
				}
				
			 if(e.getSource()==ok)
				{
  
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst2 = qd.getConnect().prepareStatement("insert into advancepayment values(?,?,?,?,?,?,?,?)");
					pst2.setString(1,(String)combobox.getSelectedItem());
					pst2.setString(2,(area_code.getText()).trim());
					
					pst2.setString(3,(mtr_code.getText()).trim());
					
					pst2.setInt(4,Integer.parseInt((String)periodcombobox.getSelectedItem()));
					//pst2.setString(4,"");
					pst2.setInt(5,Integer.parseInt(amt.getText()));
					pst2.setInt(6,Integer.parseInt(m_rent.getText()));
					pst2.setInt(7,Integer.parseInt(rbt.getText()));
					pst2.setInt(8,Integer.parseInt(tot.getText()));
												
					int i=pst2.executeUpdate();
					System.out.println("Inserted " + i);
					if(i>0)
					{
						JOptionPane.showInternalMessageDialog(this,"Demand Generated","ADVANCE ",1);
					
					}
					}

							catch(Exception ex){System.out.println("Inside OK   :" +ex);}

					}		
		
}		
	
		public static void main(String arg[])
		{
		/*	Ccadv ccad = new Ccadv("ADVANCE PAYMENT");
			ccad.setSize(400,550);
			ccad.setVisible(true);*/
	}

}