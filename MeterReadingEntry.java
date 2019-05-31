package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;

public class MeterReadingEntry extends JFrame //implements ActionListener
 { 
	JLabel consumernumber,areacode,previous_reading,presentreading,meter_reader_code,units_consumed ;
	JComboBox cosnumer_name_combobx,area_code_combobx,day_code_combobx,meter_reader_code_combobx,d1,d2,d3,m1,m2,m3,y1,y2,y3;
	JTextField previousreading,present_reading,ints,unit_consumed;
	
	JButton ok,edit,cancel,sd;
	String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
	String dw[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"Month","JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String yw[]={"Year","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	public MeterReadingEntry(String title)
  	{


		super("MeterReadingEntry");
		setLayout(null);
		consumernumber=new JLabel("Consumer Number");
		cosnumer_name_combobx=new JComboBox();
		cosnumer_name_combobx.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("Area code");
		area_code_combobx=new JComboBox(ac);
	
		meter_reader_code=new JLabel("Meter Reader Code");
		String mtrcd[]={"1","2","3","4","5","6","7","8"};
		meter_reader_code_combobx=new JComboBox(mtrcd);
		previous_reading=new JLabel("Previous Reading");
		previousreading=new JTextField(10); //read from the database
		presentreading=new JLabel("Present Reading");
		present_reading=new JTextField(10);
		units_consumed=new JLabel("Units consumed");
		unit_consumed=new JTextField(10);
		ok=new JButton("Update");
		cancel=new JButton("Cancel");
		edit=new JButton("edit");
		FlowLayout layout=new FlowLayout();
		sd=new JButton("Show Demand");

		JPanel p1,p2,p3,p4,p5,p6,p8,p9,p10,p11,p12,p13;

		
		p1=new JPanel();

		
		p1.setLayout(new GridLayout(2,2,0,0));
		p1. add(areacode);
		
		p1.add(area_code_combobx);		
	
		p1.add(meter_reader_code);
	
		p1.add(meter_reader_code_combobx);


		
		p3=new JPanel();
		p3.setLayout(new GridLayout(4,2,10,10));
		p3.add(consumernumber);
		p3.add(cosnumer_name_combobx);     
		p3.add(previous_reading);
		p3.add(previousreading); 
		p3. add(presentreading);
		;
		p3.add(present_reading);
		p3.add(units_consumed);
		p3.add(unit_consumed);	       
		
		p4=new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));

		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		p5=new JPanel();
		p5.setLayout(new GridLayout(1,1,10,10));

		
		p5.add(sd);
		
		p1.setBounds(10,100,260,45);
		add(p1);
		
		p3.setBounds(80,200,250,140);
		add(p3);
		p4.setBounds(100,370,300,30);
		add(p4);
		
		p5.setBounds(160,420,180,30);
		add(p5);

		JLabel bdate=new JLabel("Bill Date");
		d1=new JComboBox(dw);
		m1=new JComboBox(mw);
		y1=new JComboBox(yw);;
		JLabel ddate=new JLabel("Due Date");
		d2=new JComboBox(dw);
		m2=new JComboBox(mw);
		y2=new JComboBox(yw);
		JLabel disdate=new JLabel("Disconnnection date");
		d3=new JComboBox(dw);
		m3=new JComboBox(mw);
		y3=new JComboBox(yw);
		
		p8=new JPanel();
		p8.setLayout(new GridLayout(1,1,10,10));
		p8.add(bdate);
		p8.setBounds(350,100,120,20);
		add(p8);
		
		p9=new JPanel();
		p9.setLayout(new GridLayout(1,1,10,10));
		p9.add(d1);
		p9.add(m1);
	    p9.add(y1);
		p9.setBounds(350,120,250,20);
		add(p9);
	
		
		p10=new JPanel();
		p10.setLayout(new GridLayout(1,1,10,10));
		p10.add(ddate);
		p10.setBounds(350,140,120,20);
		add(p10);
		
		p11=new JPanel();
		p11.setLayout(new GridLayout(1,1,10,10));
		p11.add(d2);
		p11.add(m2);
	    p11.add(y2);
		p11.setBounds(350,160,250,20);
		add(p11);
		
		p12=new JPanel();
		p12.setLayout(new GridLayout(1,1,10,10));
		p12.add(disdate);
		p12.setBounds(350,180,120,20);
		add(p12);
		
		p13=new JPanel();
		p13.setLayout(new GridLayout(1,1,10,10));
		p13.add(d3);
		p13.add(m3);
	    p13.add(y3);
		p13.setBounds(350,200,250,20);
		add(p13);
	
		
	
		
	}

		public static void main(String arg[])
		{
			MeterReadingEntry mre = new MeterReadingEntry("METER READING ENTRY");
			mre.setSize(650,550);
			mre.setVisible(true);
	}

}