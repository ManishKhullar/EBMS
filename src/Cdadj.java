//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;

public class Cdadj extends JInternalFrame implements ActionListener
 { 
	JLabel conno,areacode,daycode,mtrcode,cdavailable,cdrefund,dmd;
	JComboBox combobox;
	JTextField cd_available,cd_refund,demand,area_code,day_code,mtr_code;
	JTextArea note;
	JButton ok,edit,cancel;
	
	public Cdadj (String title)
  	{
		
		
		
		

		super("C D ADJUSTMENT");
		setLayout(null);
		conno=new JLabel("Consumer Number");
		
			try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		combobox=new JComboBox(v);
			}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
		
		//combobox=new JComboBox();
		combobox.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
		area_code=new JTextField(5);
		daycode=new JLabel("Day code");
		day_code=new JTextField(5);
		mtrcode=new JLabel("Meter Reader Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		mtr_code=new JTextField(5);
		cdavailable=new JLabel("CD amount available");
		cd_available=new JTextField();
		dmd=new JLabel("Demand to be adjusted");
		demand=new JTextField(10); //read from the database
		cdrefund=new JLabel("CD refundable");
		cd_refund=new JTextField(10);
		
		ok=new JButton("Adjust");
		cancel=new JButton("Cancel");
		edit=new JButton("Edit");
		
		FlowLayout layout=new FlowLayout();
		
note=new JTextArea(5,30);
		JPanel p1,p2,p3,p4,p5,p6;

		p1=new JPanel();

		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1. add(conno);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(combobox);		
		p1.add(Box.createRigidArea(new Dimension(30,0)));
		p1.add(areacode);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(area_code);

		p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.X_AXIS));
		p2. add(mtrcode);
		p2.add(Box.createRigidArea(new Dimension(10,0)));
		p2.add(mtr_code);	
		
		p3=new JPanel();
		p3.setLayout(new GridLayout(3,2,10,10));
		p3.add(cdavailable);
		p3.add(cd_available);     
		p3.add(dmd);
		p3.add(demand);        
		p3.add(cdrefund);
		p3.add(cd_refund); 
		
		area_code.setEditable(false);       ;
		mtr_code.setEditable(false);
		cd_available.setEditable(false);
		demand.setEditable(false);
		//cd_refund.setEditable(false);
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		//p4.add(edit);
		p4.add(cancel);
		
		p1.setBounds(80,100,450,30);
		add(p1);
		p2.setBounds(320,138,212,30);
		add(p2);
		p3.setBounds(80,180,320,80);
		add(p3);
		p4.setBounds(100,400,270,30);
		add(p4);
		
		
		JLabel c=new JLabel("C D ADJUSTMENT");
		c.setFont(new Font("Times New Roman",Font.BOLD,20));
		c.setForeground(new Color(200,0,20)); 
		
		
		p6=new JPanel();
				p6.setLayout(new FlowLayout());
     			p6.setBounds(100,30,350,50);
     			p6.add(c);
     			add(p6);     
		
//__________________________________________________________________


/*p5.setBounds(80,100,400,190);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		p5.setBorder(BorderFactory.createEtchedBorder());
		p3.setBounds(80,300,400,75);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		p4.setBounds(140,400,300,30);*/

p5=new JPanel();
p5.add(new JLabel("Note  :"));
p5.setBorder(BorderFactory.createEtchedBorder());
p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(1,1,1,1)));		
p5.setBounds(80,270,400,100);
p5.add(note);
			
add(p5);

	setLocation(150,70);
		cancel.addActionListener(this);
		combobox.addActionListener(this);
		//cd_available.addFocusListener(this);
		
	//cd_refund.addFocusListener(this);

		}
	/*	public void focusGained(FocusEvent e)
		{
			if(e.getSource()==cd_refund)
			{
				long pre=Integer.parseInt(cd_available.getText().trim());
				long prev=Integer.parseInt(demand.getText().trim());
				long v=pre-prev;
				cd_refund.setText(""+v);
			}
			 }*/
     		     public void actionPerformed(ActionEvent e)
     		     {
     		     	if(e.getSource()==cancel)
     		     	{
     		     		this.dispose();
     		     	}
     		     	
     		     	if(e.getSource()==combobox)
			{
				//System.out.println("Selecte d ocnsumer NO");
				try{
					QueryData qd = new QueryData();

					String id=(String)combobox.getSelectedItem();
					Vector v = qd.getConsumerDetails(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em=v.elements();
					area_code.setText((String)em.nextElement());
					//System.out.println((String)em.nextElement());
					mtr_code.setText((String)em.nextElement());
					
					
					Vector v9 = qd.getCd(id.trim()); 
					//System.out.println("Consumer Details  " + v);
					Enumeration em1=v9.elements();
					
					System.out.println("Cd available  " + v9);
					cd_available.setText((String)em1.nextElement());
					
					Vector v10 = qd.getCdadjt(id.trim()); 
					Enumeration em2=v10.elements();
					System.out.println("netpayable  " + v10);
					demand.setText((String)em2.nextElement());
					
					
				/*	ta_riff.setText((String)em.nextElement());
					cphase.setText((String)em.nextElement());
					post_no.setText((String)em.nextElement());
					c_load.setText((String)em.nextElement());
					con_name.setText((String)em.nextElement());
					address.setText((String)em.nextElement());
					date1.setText((String)em.nextElement());*/			
					}catch(Exception ex){System.out.println("Error in DataEnt " + ex);}
			}
			
		
			
		
			
			
			

//___________________________________________________________________
	}
		public static void main(String arg[])
		{
		 	/*Cdadj cdad = new Cdadj("C D ADJUSTMENT");
			cdad.setSize(600,550);
			cdad.setVisible(true);*/
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
//public class Cdadj {}