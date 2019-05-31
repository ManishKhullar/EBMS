//package updated1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
public class TariffChange extends JInternalFrame implements ActionListener
 { 
	JLabel consumernumber,prestariff,areacode,traiff_change_to,daycode,date,month,year;
	JComboBox consumer_no_combobox,change_traiff_to_combobox,dat,day_code,dd,mm,yy;
	 JTextArea note;
	JTextField finalreading,area_code,present_tariff,tariff_id;
	JButton ok,edit,cancel;
	Connection con;
	public TariffChange(String title)
  	{

		super("Tariff Change");
		setLayout(null);
		JPanel p2,p3,p4,p1,p5;
		consumernumber=new JLabel("CONSUMER NUMBER");
		try{
			QueryData qd = new QueryData();
			Vector v = qd.getConsumer(); 
			consumer_no_combobox=new JComboBox(v);
			}
			catch(Exception ex)
			{System.out.println("Error in DataEnt " + ex);}
		
		consumer_no_combobox.setPreferredSize(new Dimension(100,20));
		areacode=new JLabel("AREACODE");
		
		area_code=new JTextField();
		p1=new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS)); 
		p1. add(consumernumber);
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(consumer_no_combobox);
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(areacode);
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(area_code);
		p1.setPreferredSize(new Dimension(380,70));
		String tariff[]={"IA","IB","IC","II","III","IV","VA","VB","VC","VI","VII","VIII"};
	
		present_tariff = new JTextField();
		traiff_change_to=new JLabel("Tariff changed to");
		change_traiff_to_combobox=new JComboBox(tariff);
		JLabel tariffid=new JLabel("TARIFF ID");
		tariff_id = new JTextField(10);	
	
		p2=new JPanel(new GridLayout(4,2,5,5));
		p2.add(tariffid);
		p2.add(tariff_id);
		p2.add(new JLabel("Present Tariff"));
		p2.add(present_tariff);
		p2.add(traiff_change_to);
		p2.add(change_traiff_to_combobox);
		p2.add(new JLabel("Final Reading"));
		finalreading = new JTextField(10);		
		
		p2.add(finalreading);
		
		
		p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p3.add(new JLabel("Note  :"));
		note = new JTextArea(10,5);
		p3.add(note);
		p3.setBounds(80,350,400,100);
		p3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),BorderFactory.createEmptyBorder(5,5,5,5)));

		ok=new JButton("UPDATE");
		edit=new JButton("EDIT");
		cancel=new JButton("CANCEL");
		p4 = new JPanel();
		p4.setLayout(new GridLayout(1,3,10,10));
		p4.add(ok);
		p4.add(edit);
		p4.add(cancel);
		p4.setBounds(120,460,300,30);



		date=new JLabel("Day");
		Integer days[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		dd=new JComboBox(days);
		month=new JLabel("Month");
		String month1[] = {"January","February","March","April","May","June","July","August","September","Octorber","November","December"};
		mm=new JComboBox(month1);
		year=new JLabel("Year");
		Integer year1[]={2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023,2024,2025};
		yy=new JComboBox(year1);
		
		p5=new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.X_AXIS));
		p5.add(new JLabel("Date of Change"));
		p5.add(Box.createRigidArea(new Dimension(30,0)));
		p5.add(dd);
		p5.add(Box.createRigidArea(new Dimension(5,0)));
		p5.add(mm);
		p5.add(Box.createRigidArea(new Dimension(5,0)));
		p5.add(yy);

		JLabel head = new JLabel("Change Of Tariff");
		head.setFont(new Font("Times New Roman",Font.BOLD,35));
		head.setForeground(new Color(100,150,100));
		
		head.setBounds(180,50,350,50);
		p1.setBounds(80,125,500,25);
		p2.setBounds(80,185,450,100);
		p5.setBounds(177,295,350,30);

		add(head);
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
			setLocation(150,70);
		cancel.addActionListener(this);
		consumer_no_combobox.addActionListener(this);	
		ok.addActionListener(this);	

					}
		
                               public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
		
	
			if(e.getSource()==consumer_no_combobox)
			{
				System.out.println("Selected ocnsumer NO");
				try{

					
					QueryData qd = new QueryData();
					String id=(String)consumer_no_combobox.getSelectedItem();
					Vector v8 = qd.getConsumerDetails(id.trim()); 
					System.out.println("Consumer Details  " + v8);
					System.out.println(id + "Tc " + v8 );
					Enumeration em=v8.elements();
					area_code.setText((String)em.nextElement());
					present_tariff.setText((String)em.nextElement());
					present_tariff.setText((String)em.nextElement());
					
					Vector v12 = qd.getTid(id.trim()); 
					
						Enumeration em1=v12.elements();
					
					
					tariff_id.setText((String)em1.nextElement());
					//System.out.println((String)em.nextElement());
					//mtr_code.setText((String)em.nextElement());
							
					}catch(Exception ex){System.out.println("Error in Tc" + ex);}
			}


				else if(e.getSource()==ok)
				{
					System.out.println("Entered Update");
				try{
		
					//,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

				
				QueryData qd = new QueryData();
				PreparedStatement pst = qd.getConnect().prepareStatement("insert into changetariff values(?,?,?,?,?,?,?,?)");
			
			//	pst.setString(1,(String)consumer_no_combobox.getSelectedItem());
				pst.setString(1,((String)consumer_no_combobox.getSelectedItem()).trim());
					System.out.println(consumernumber);
				pst.setString(2,area_code.getText().trim());
				pst.setString(3,tariff_id.getText().trim());			
				pst.setString(4,present_tariff.getText().trim());
				pst.setString(5,((String)change_traiff_to_combobox.getSelectedItem()).trim());
				pst.setString(6,finalreading.getText().trim());
				String d,y,m,date;
				d=(String)dd.getSelectedItem();
				m=(String)mm.getSelectedItem();
				y=(String)yy.getSelectedItem();
				date=d+"/"+m+"/"+y;
				pst.setString(7,date);
				
				pst.setString(8,note.getText());
				int i=pst.executeUpdate();
				if(i>0)
				{
					//System.out.println("Consumer Added");
						JOptionPane.showInternalMessageDialog(this,"Tariff Changed","TARIFF CHANGE ",1);
				}
				
				

		                }catch(Exception ex){System.out.println("Inside Save   :" +ex);}		
	
	}
}
		public static void main(String arg[])
		{
		/*	TariffChange w = new TariffChange("Tariff Change");
			w.setSize(625,550);
			w.setVisible(true);*/
	                  }

}