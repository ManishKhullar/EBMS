//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class Collection extends JInternalFrame implements ActionListener
 { 
	JLabel consumernumber,areacode,mtrcode,a_cd ;
	
	JTextField energychargetobecollected,amountcollected,m_r,pendingoyec,tariff,ints,unit_con,acd,area_code,meterreadercode;
	JComboBox combobox;
	JButton quierry,offset,receipt,exit;
	String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	public Collection(String title)
  	{


		super("COLLECTION WINDOW");
		setLayout(null);
		consumernumber=new JLabel("Consumer Number");

		try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		combobox=new JComboBox(v);
		}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		//combobox=new JComboBox();
		combobox.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		area_code=new JTextField (10);
		mtrcode=new JLabel("Meter Reader Code");
	
		meterreadercode=new JTextField (10);
		JLabel tarif=new JLabel("Tariff");
		tariff=new JTextField(10);
		JLabel oyecinst=new JLabel("Pending OYEC");
		pendingoyec=new JTextField(10); //read from the database
		
		a_cd=new JLabel("ACD");
		acd=new JTextField(10);
		
		quierry=new JButton("Quierry");
		
		FlowLayout layout=new FlowLayout();
		offset=new JButton("Offset");
		receipt=new JButton("Receipt");
		exit=new JButton("exit");

		JPanel p1,p2,p3,p4,p5,p6,p7;
	setLocation(200,150);
	
		p1=new JPanel();
		p1.setLayout(new GridLayout(6,2,0,5));
		p1.add(consumernumber);
		p1.add(combobox);
		p1.add(areacode);
		p1.add(area_code);		
		p1.add(mtrcode);
		p1.add(meterreadercode);
		p1.add(tarif);
		p1.add(tariff);
		p1.add(oyecinst);
		p1.add(pendingoyec); 
		
		p1.add(a_cd);
		p1.add(acd);
		p1.setBounds(50,100,265,196);
		add(p1);

		//p2=new JPanel();
		//p2.setLayout(new FlowLayout());
		//p2.add(quierry);
		//p2.setBounds(270,95,90,40);
		//add(p2);
		
		JLabel c=new JLabel("COLLECTION");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(150,0,200));      
		
		        p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(60,50,250,30);
     			p6.add(c);
     			add(p6);
     			
		
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,3,10,10));
		p5.add(offset);
		p5.add(receipt);
		p5.add(exit);
		p5.setBounds(10,400,300,30);
		add(p5);
	
		JLabel amtc=new JLabel("Energy Charge to be collected");
		energychargetobecollected=new JTextField(10);
		JLabel amtcd=new JLabel("Amount  collected");
		amountcollected=new JTextField(10);
;
		p7=new JPanel();
		p7.setLayout(new GridLayout(3,2,0,5));
		p7.add(amtc);
		p7.add(energychargetobecollected);
		p7.add(amtcd);
		p7.add(amountcollected);

		p7.setBounds(5,320,340,80);
		add(p7);
		
		
			setLocation(200,70);
		
		exit.addActionListener(this);
		combobox.addActionListener(this);
		offset.addActionListener(this);
		
		}
			public void actionPerformed(ActionEvent e)
			{
			if(e.getSource()==exit)
				{
				this.dispose();
				}
				if(e.getSource()==combobox)
				{
					System.out.println("Entered   CON_NO");
					try{

					QueryData qd = new QueryData();

					String id=(String)combobox.getSelectedItem();
					Vector v = qd.getConsumerDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em=v.elements();
					area_code.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					meterreadercode.setText((String)em.nextElement());
					tariff.setText((String)em.nextElement());
				//___________________________________________________
						//if((tariff=em.nextElement())!=null)
						//tariff.setText(tariff);
				//-----------------------------------------------------------------------------	
					
				
					
				}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
			}



    			if(e.getSource()==combobox)
				    {
				System.out.println("Entered   CON_NO");
				try{

				QueryData qd = new QueryData();

					String id=(String)combobox.getSelectedItem();
					Vector v13 = qd.getOyecdues(id.trim()); 
					if(!(v13.isEmpty())){
					//System.out.println("Consumer Details  " + v);
					Enumeration em1=v13.elements();
					pendingoyec.setText((String)em1.nextElement());
					//System.out.println((String)em.nextElement());
					}else
						pendingoyec.setText("");
				}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
		}

		
		
		if(e.getSource()==combobox)
			{
					System.out.println("Entered   CON_NO");
					energychargetobecollected.setText("");
			try{

				QueryData qd = new QueryData();

					String id=(String)combobox.getSelectedItem();
					Vector v14 = qd.getNetdem(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					String c="";
					if(!(v14.isEmpty())){
						System.out.println("Entered loop");
						Enumeration em2=v14.elements();
						c=(String)em2.nextElement();							
						System.out.println("Value of C :" + c);
						energychargetobecollected.setText(c);
						
					}
						
					//energychargetobecollected.setText((String)em2.nextElement());
					//System.out.println((String)em.nextElement());
					
				//___________________________________________________
						
				//-----------------------------------------------------------------------------	
					
					
				
					
				}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
		}
		
		
			if(e.getSource()==offset)
			{
					System.out.println("Entered   offset");
			try{
				
				QueryData qd = new QueryData();
					PreparedStatement pst2 = 			qd.getConnect().prepareStatement("insert into sbcollection values(?,?,?,?)");
					pst2.setString(1,(String)combobox.getSelectedItem());
					pst2.setString(2,area_code.getText());
					pst2.setString(3,meterreadercode.getText());
					pst2.setString(4,amountcollected.getText());
					//pst2.setString(5,totno_inst.getText());
					
					
					int i=pst2.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"Collectin details entered","COLLECTION ",1);
					}
					
					
						}catch(Exception ex){System.out.println("Error in Collection: " + ex);}		
		}
		
	
		
		


                        }


		public static void main(String arg[])
                {
			Collection c = new Collection("COLLECTION WINDOW");
			c.setSize(450,550);
			c.setVisible(true);
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
//public class Collection {}
