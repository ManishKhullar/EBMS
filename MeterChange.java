//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.border.*;

public class MeterChange extends JInternalFrame implements ActionListener
 { 
	JLabel consumernumber,areacode,meter_reader_code,present_meter_no,new_meter_no,maker,maker_new,day,day1,month,month1,year,year1,finalreading,initialreading;
	JComboBox mtr_dgts_combobox,mtr_dgts_new_combobox,consumer_no_combobox,area_code_combobox,meter_reader_combobox;
	JTextField present_meter_code,new_meter_number,final_reading,intial_reading;
	 JTextArea note;
	JButton ok,edit,cancel;
	
	public MeterChange(String title)
  	{


		super("Meter Change");
		setLayout(null);
		consumernumber=new JLabel("CONSUMER NUMBER");
		consumer_no_combobox=new JComboBox();
		consumer_no_combobox.setPreferredSize(new Dimension(100,20));
		Vector v2=null;
		try{
		QueryData qd = new QueryData();
		v2= qd.getConsumer(); 
		consumer_no_combobox=new JComboBox(v2);
		}catch(Exception ex)
		{//System.out.println("Error in DataEnt " + ex);
			ex.printStackTrace();
		}
		areacode=new JLabel("AREACODE");
		String area[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
		area_code_combobox=new JComboBox(area);
		meter_reader_code=new JLabel("Meter Reader Code");
		meter_reader_combobox=new JComboBox();
		present_meter_no=new JLabel("Present Meter No:");
		present_meter_code=new JTextField(10);
		JLabel fr=new JLabel("Final Reading");
		final_reading=new JTextField(10);
		
		new_meter_no=new JLabel("New Meter Number");
		new_meter_number=new JTextField(10);
		JLabel ir=new JLabel("Initial Reading");
		intial_reading=new JTextField(10);
		
		note=new JTextArea(10,5);
		ok=new JButton("UPDATE");
		edit=new JButton("EDIT");
		cancel=new JButton("CANCEL");
		FlowLayout layout=new FlowLayout();
		

		JPanel p1,p2,p3,p4,p5,p6;

		p1=new JPanel();
	
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();


		p1.setLayout(layout);
		p2.setLayout(new GridLayout(4,2,10,10));
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p4.setLayout(new GridLayout(1,3,10,10));
		p5.setLayout(layout);
		p6.setLayout(new GridLayout(3,1));

		p1. add(consumernumber);
		p1.add(consumer_no_combobox);
		p1.add(areacode);
		p1.add(area_code_combobox);
		p1.add(new JLabel("Choose an Area Code and Consumer Number"));
		p1.setPreferredSize(new Dimension(380,70));
		p2.add(present_meter_no);
		p2.add(present_meter_code);
		p2.add(fr);
		p2.add(final_reading);
		
		p2.add(new_meter_no);
		p2.add(new_meter_number);
		p2.add(ir);
		p2.add(intial_reading);

		p3.add(new JLabel("Note  :"));
		p3.add(note);

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		
		p5.add(p1);
		p5.add(p2);

		p5.setBounds(80,100,400,200);
		//p5.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(),BorderFactory.createEmptyBorder(20,20,20,20)));
		p5.setBorder(BorderFactory.createEtchedBorder());
		p3.setBounds(80,300,400,100);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));
		p4.setBounds(120,450,330,30);

		add(p5);
		add(p3);
		add(p4);
		
		setSize(550,550);
		setLocation(150,80);
		setVisible(true);
			cancel.addActionListener(this);
			
					}
		
                               public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
			else if(e.getSource()==ok)
			{
				
			}
			else if(e.getSource()==edit)
			{
				
			}
		
	}
		public static void main(String arg[])
		{
		MeterChange mch = new MeterChange("Meter Change");
			mch.setSize(550,550);
			mch.setVisible(true);
	}

}
