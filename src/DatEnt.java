//package updated1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
public class DatEnt extends JInternalFrame implements ActionListener
{
	JLabel areacode,meterreadercode,consumernumber,consumername,addressla,meternumber,initialraeading,cr,noofdigit,tariff,phase,postnumber,connectedload,dateofconnection,dd1,mm1,yy1;
	JTextArea address;
	JTextField tid,con_no,con_name,post_no,c_load,mtr_no,i_r1,i_r2,c_r,no_digit,area_code4,mr_code4;
	JButton add_cd,add_dd,add_mg,add_md,edit1,cancel,list,listall,Enter,mch;
	JComboBox ta_riffcombobox,cphase_combobox,dateofconnectio,monthofconnection,yearofconnection,m2,y2,d3,m3,y3,d4,m4,y4,d5,m5,y5,d6,m6,y6,d7,m7,y7,m55,y55,con_no1,con_no2,con_no3,con_no4,area_code,mr_code;
	JComboBox m77,m8,m9,y77,y8,y9;
	static String acode,mcode;
JTextField ac_d,receiptno1,cash_deposit,receiptno2,totno_inst,oyec_amt,inst_amt,paid_inst,bal_inst,ending_month,finalreading,area_code1,mr_code1;
JTextField lemgamt,scmgamt,lramt,ilemg,iscmg,ilr,noofinst_lemg,noofinst_semg,noofinst_lr,pnoofinst_lemg,pnoofinst_semg,pnoofinst_lr;

	String dw[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mw[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	String ac[]={"Ahemednagar","Akola","Amravati","Aurangabad","Beed","Bhandara","Buldhana","Chandrapur","Dhule","Gondia","Hingoli","Jalgaon","Jalna","Kolhapur","Latur","Mumbai Suburban","Mumbai city","Nagpur","Nanded","Nashik","Osmanabad","Palghar","Parbhani","Pune","Raigad","Ratnagiri","Sangli","Satara","Sindhudurg","Solapur","Thane","Wardha","Washim","Yavatmal","OTHER STATE","	"};
	String mc[]={"1","2","3","4","5","6","7","8"};
	String yw[]={"2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	String t[]={"IA","IB","IC","II","III","IV","VA","VB","VC","VI","VII","VIII"};
	String p[]={"Single Phase","Three Phase"};
	
	Connection con;
	
	JTabbedPane tb;
	
	public DatEnt(String title)
	{
		super("Data Entry");
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		JLabel cd=new JLabel("CONSUMER DETAILS");
		cd.setFont(new Font("Times New Roman",Font.BOLD,20));
		cd.setForeground(new Color(150,0,200));
		JPanel p65=new JPanel();
		p65.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
     	p65.setBounds(150,0,350,30);
     	p65.add(cd);
     	panel1.add(p65);
			
//************************************NEW CONSUMER********************************
        consumernumber=new JLabel("Consumer Number");
		con_no=new JTextField(10);
		areacode=new JLabel("Area Code");
		area_code=new JComboBox(ac);
		meterreadercode=new JLabel("Meter Reader Code");
		mr_code=new JComboBox(mc);
		tariff=new JLabel("tariff");
		ta_riffcombobox=new JComboBox(t);
		phase=new JLabel("phase");
		cphase_combobox=new JComboBox(p);	
		postnumber=new JLabel("Postnumber");
		post_no=new JTextField(20);	
		connectedload=new JLabel("Connected Load");
		c_load=new JTextField(20);
		JLabel t=new JLabel("Tariff ID");
		tid=new JTextField(10);
		dateofconnection=new JLabel("Date of connection");
		dateofconnectio=new JComboBox(dw);
		monthofconnection=new JComboBox(mw);
		yearofconnection=new JComboBox(yw);
		
		JPanel p1= new JPanel();
		
		
		p1.setLayout(new BoxLayout(p1,BoxLayout.X_AXIS));
		p1.setLayout(new GridLayout(9,2,0,0));
	
		p1.add(consumernumber);
		p1.add(con_no);
		p1.add(areacode);
    	p1.add(area_code);
    	p1.add(meterreadercode);
    	p1.add(mr_code);
		p1.add(tariff);
		p1.add(ta_riffcombobox);
		p1.add(phase);
		p1.add(cphase_combobox);
		p1.add(postnumber);
		p1.add(post_no);
		p1.add(connectedload);
		p1.add(c_load);
		
		p1.add(t);
		p1.add(tid);
		

		
		
		
        consumername=new JLabel("Consumer name");
        con_name=new JTextField(60);
    	addressla = new JLabel("Address");
		address= new JTextArea(15,10);
		JScrollPane scroll = new JScrollPane(address);
		JPanel p2 = new JPanel();
		
		
		p2.setLayout(new GridLayout(1,1,0,0));
		p2.add(consumername);
		JPanel p3 = new JPanel();
		
		p3.setLayout(new GridLayout(1,1,0,0));
		p3.add(con_name);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,1,0,0));
		p4.add(addressla);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.X_AXIS));
		p5.setLayout(new GridLayout(1,1,0,0));
		p5.add(Box.createRigidArea(new Dimension(80,0)));
		p5.add(scroll);

		JPanel p6 = new JPanel();
		p6.setLayout(new GridLayout(1,1,0,0));
		p6.add(dateofconnection);
		JPanel p7 = new JPanel();
		p7.setLayout(new GridLayout(1,3,0,0));
		p7.add(dateofconnectio);
		p7.add(monthofconnection);
		p7.add(yearofconnection);
		
		
		add_cd=new JButton("Enter");
     		//edit=new JButton("edit");
		
		JPanel p8=new JPanel();
		p8.setLayout(new FlowLayout());
     	p8.setBounds(270,230,200,40);
     	p8.add(add_cd);
     //	p8.add(edit);
		
		
		p1.setBounds(20,30,230,200);
		p2.setBounds(300,30,100,20);
		p3.setBounds(402,30,225,20);
		p4.setBounds(300,90,75,20);
     		p5.setBounds(168,60,462,100);
		p6.setBounds(300,190,120,20);
		p7.setBounds(425,190,200,20);
		
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		panel1.add(p5);
		panel1.add(p6);		
		panel1.add(p7);		
	
		panel1.add(p8);
	
	//************************METER DETAILS********************************

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		
		JLabel md=new JLabel("METER DETAILS");
			
		md.setFont(new Font("Times New Roman",Font.BOLD,20));
		md.setForeground(new Color(180,0,0));
		
				JPanel p55=new JPanel();
				p55.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
     			p55.setBounds(30,50,220,30);
     			p55.setBackground(new Color(200,200,200));
     			p55.add(md);
     			
     			panel2.add(p55);
			panel2.setBackground(new Color(200,200,200));
		
		JPanel p9 = new JPanel();
		p9.setLayout(new GridLayout(4,2,5,5));
		JLabel conno1=new JLabel("Consumer Number");
		try{
		QueryData qd = new QueryData();
		Vector v = qd.getConsumer(); 
		con_no1=new JComboBox(v);
		}catch(Exception ex)
		{
			//System.out.println("Error in DataEnt " + ex);
			ex.printStackTrace();
		}
		meternumber=new JLabel("Metre Number");
		mtr_no=new JTextField(10);
		noofdigit=new JLabel("No of Digits");
		no_digit=new JTextField(10);
		initialraeading=new JLabel("Initial Reading");
		i_r1=new JTextField(20);
		 add_md=new JButton("Enter");
		 edit1=new JButton("edit");
		
		p9.add(conno1);
		p9.add(con_no1);
		p9.add(meternumber);
		p9.add(mtr_no);
		p9.add(noofdigit);
		p9.add(no_digit);
		p9.add(initialraeading);
		p9.add(i_r1);
		p9.setBounds(20,100,250,100);
		p9.setBackground(new Color(200,200,200));
		JPanel p10 = new JPanel();
		p10.setLayout(new GridLayout(1,2,5,5));
		
		p10.add(add_md);
		p10.add(edit1);
		p10.setBounds(50,335,170,30);
		p10.setBackground(new Color(200,200,200));
		panel2.add(p9);
		panel2.add(p10);
		
	
//______________________________________________________________________		
	/*	JPanel panel5 = new JPanel();
		panel5.setLayout(null);*/
		
				JLabel mcc=new JLabel("METER CHANGE");
			
		mcc.setFont(new Font("Times New Roman",Font.BOLD,20));
		mcc.setForeground(new Color(180,0,230));
		
		JPanel p505=new JPanel();
				p505.setLayout(new FlowLayout());
     			p505.setBounds(380,50,220,30);
     			p505.setBackground(new Color(200,200,200));
     			p505.add(mcc);
     			
     			panel2.add(p505);
   		JPanel p90 = new JPanel();
		p90.setLayout(new GridLayout(6,2,5,5));
		 conno1=new JLabel("Consumer Number");
		con_no2=new JComboBox();
		JLabel pmtrno=new JLabel("Present Metre Number");
		JTextField pmtr_no=new JTextField(10);
		JLabel fr=new JLabel("Final Reading");
		finalreading=new JTextField(20);
		JLabel nmtrno=new JLabel("New Metre Number");
		JTextField nmtr_no=new JTextField(10);
		JLabel nodigit1=new JLabel("No of Digits");
		JTextField no_digit1=new JTextField(10);
		initialraeading=new JLabel("Initial Reading");
		i_r2=new JTextField(20);
		JButton save2=new JButton("save");
		JButton edit2=new JButton("edit");
			mch=new JButton("change");
		JLabel doch=new JLabel("Date of Change:");
		d7=new JComboBox(dw);
		m7=new JComboBox(mw);
		y7=new JComboBox(yw);
		
		
			p90.add(conno1);
		p90.add(con_no2);
		p90.add(pmtrno);
		p90.add(pmtr_no);	
		p90.add(fr);
		p90.add(finalreading);
		p90.add(nmtrno);
		p90.add(nmtr_no);
		p90.add(nodigit1);
		p90.add(no_digit1);
		p90.add(initialraeading);
		p90.add(i_r2);
		p90.setBounds(350,100,300,130);
		p90.setBackground(new Color(200,200,200));
		JPanel p91=new JPanel();
		p91.setBounds(350,233,100,30);
		p91.setBackground(new Color(200,200,200));
		p91.add(doch);
		JPanel p92=new JPanel();
		p92.setLayout(new GridLayout(1,3,2,2));
		p92.setBounds(455,233,200,30);
		p92.setBackground(new Color(200,200,200));
		p92.add(d7);
		p92.add(m7);
		p92.add(y7);
		JPanel p80 = new JPanel();
		p80.setLayout(new GridLayout(1,3,5,5));

		p80.add(mch);
		p80.add(save2);
		p80.add(edit2);
		p80.setBounds(420,335,250,30);
		p80.setBackground(new Color(200,200,200));
		panel2.add(p90);
		panel2.add(p91);
		panel2.add(p92);
		panel2.add(p80);
		
	
			
//**************************************************************************************
//DEPOSIT DETAILS
	JLabel acd,rtno1,cashdeposit,rtno2,totnoinst,oyecamt;
        
	JPanel panel3 = new JPanel();
	panel3.setLayout(null);
	JLabel dd=new JLabel("DEPOSIT DETAILS");
			
	dd.setFont(new Font("Times New Roman",Font.BOLD,25));
	dd.setForeground(new Color(180,0,0));
		
			JPanel p45=new JPanel();
			p45.setLayout(new FlowLayout());
     			p45.setBounds(200,30,350,30);
     			p45.add(dd);
     			panel3.add(p45);	    
			consumernumber=new JLabel("Consumer No:");

			try{
			QueryData qd = new QueryData();
			Vector v = qd.getConsumer(); 
			con_no3=new JComboBox(v);
			}
			catch(Exception ex)
			{
				//System.out.println("Error in DataEnt " + ex);
				ex.printStackTrace();
			}

			//areacode=new JLabel("Area Code");                   
			//area_code=new JComboBox(ac);
			//meterreadercode=new JLabel("Meter Reader Code");
		    	//mr_code=new JComboBox(mc);		
			JPanel p11=new JPanel();
			p11.setLayout(new GridLayout(1,1,0,0));	
			p11.add(consumernumber);
			p11.setBounds(10,10,80,20);

			JPanel p101=new JPanel();
	     	   	p101.setLayout(new GridLayout(1,1,0,0));
			p101.add(con_no3);
			p101.setBounds(95,10,100,20);
		
			JPanel p112=new JPanel();	
			p112.setLayout(new FlowLayout());
			p112.setBounds(0,75,400,40);
			p112.add(p11);
			p112.add(p101);
			
	    		panel3.add(p112);
		
		
		
		JPanel p12=new JPanel();
		p12.setLayout(new GridLayout(4,2,0,10));                    
		cashdeposit=new JLabel("Cash deposit");
		cash_deposit=new JTextField(10);
		acd=new JLabel("AdditnalConsumerDeposit");
		ac_d=new JTextField(10);
		oyecamt=new JLabel("OYEC Amount");
		oyec_amt=new JTextField(10);
		totnoinst=new JLabel("Total no of instalments");
		totno_inst=new JTextField(10);
		
		p12.add(cashdeposit);	
		p12.add(cash_deposit);
		p12.add(acd);	
		p12.add(ac_d);
		p12.add(oyecamt);	
		p12.add(oyec_amt);
		p12.add(totnoinst);
		p12.add(totno_inst);
		p12.setBounds(5,140,300,105);
		panel3.add(p12);

		rtno1=new JLabel("Receipt no");
		receiptno1=new JTextField(10);
		rtno2=new JLabel("Receipt no");
		receiptno2=new JTextField(10);
	
		d4=new JComboBox(dw);
		m4=new JComboBox(mw);
		y4=new JComboBox(yw);
		d5=new JComboBox(dw);
		m5=new JComboBox(mw);
		y5=new JComboBox(yw);
	
		JPanel p13,p14;
		p13=new JPanel(new FlowLayout());
		p13.add(rtno1);
		p13.add(receiptno1);
		p13.add(d4);
		p13.add(m4);
		p13.add(y4);
		p14 = new JPanel(new FlowLayout());
		p14.add(rtno2);
		p14.add(receiptno2);
		p14.add(d5);
		p14.add(m5);
		p14.add(y5);
		
		p13.setBounds(300,120,430,30);
		p14.setBounds(300,150,430,30);
		panel3.add(p13);
		panel3.add(p14);

		JLabel totinst,instamt,paidinst,balinst,endingmonth;
		JPanel p15=new JPanel();
		p15.setLayout(new GridLayout(3,2,0,10));
		instamt=new JLabel("Instalment Amt: ");
		inst_amt=new JTextField(10);
		paidinst=new JLabel("Paid Instalments ");
		paid_inst=new JTextField(10);			
		balinst=new JLabel("Balance Instalments ");
		bal_inst=new JTextField(10);
		p15.add(instamt);
		p15.add(inst_amt);
		p15.add(paidinst);
		p15.add(paid_inst);
		p15.add(balinst);
		p15.add(bal_inst);
		p15.setBounds(390,190,250,100);
		panel3.add(p15);
		
		endingmonth=new JLabel("OYCE Instalment ends on the month");
	
		m55=new JComboBox(mw);
		y55=new JComboBox(yw);
		JPanel p16=new JPanel();
		p16.setLayout(new FlowLayout());
		p16.add(endingmonth);
		p16.add(m55);
		p16.add(y55);
		p16.setBounds(0,255,360,30);
		panel3.add(p16);
		
		add_dd=new JButton("Enter");
     	//	edit=new JButton("edit");
		
		JPanel p38=new JPanel();
		p38.setLayout(new FlowLayout());
     	p38.setBounds(270,330,200,40);
     	p38.add(add_dd);
     //	p38.add(edit);
     	
     	panel3.add(p38);
		
		
		
//************************MINIMUM  GAURENTEE****************************




           JPanel panel4 = new JPanel();
			panel4.setLayout(null);

	//	JLabel mg=new JLabel("MINIMUM GAURENTEE");
		
	//	mg.setFont(new Font("Times New Roman",Font.BOLD,25));
	//	mg.setForeground(new Color(180,0,230));
		JLabel lemg=new JLabel("           LEMG         ");
		JLabel scmg=new JLabel("                       SCMG         ");
		JLabel lr=new JLabel("               Line Rent");
		//JPanel panel6 = new JPanel();
		//panel6.setLayout(null);
	
		JLabel amt=new JLabel("Amount");
		lemgamt=new JTextField(10);		
		scmgamt=new JTextField(10);
		lramt=new JTextField(10);
		
		JLabel iamt=new JLabel("Instalment Amt");
		ilemg=new JTextField(10);		
		iscmg=new JTextField(10);
		ilr=new JTextField(10);
		
	    	consumernumber=new JLabel("Consumer No:");

					try{
				QueryData qd = new QueryData();
				Vector v = qd.getConsumer(); 
				con_no4=new JComboBox(v);
					}
				catch(Exception ex)
					{
					System.out.println("Error in DataEnt " + ex);
					ex.printStackTrace();
					}
    		//area_code4=new JTextField(10);	
		//mr_code4=new JTextField(10);
		JPanel p17=new JPanel();
		p17.setLayout(new GridLayout(1,1,0,10));
		p17.setBounds(50,70,85,20);
		p17.add(consumernumber);

		JPanel p18=new JPanel();
		p18.setLayout(new GridLayout(1,1,0,10));
		p18.setBounds(135,70,100,20);
     		p18.add(con_no4);
		
		JPanel p19=new JPanel();
		p19.setLayout(new GridLayout(1,1,0,10));
		p19.setBounds(240,70,65,20);
		
		//p19.add(areacode);
			
		JPanel p20=new JPanel();
		p20.setLayout(new GridLayout(1,1,0,10));
		p20.setBounds(308,70,70,20);
		//p20.add(area_code4);
		
		JPanel p21=new JPanel();
		p21.setLayout(new GridLayout(1,1,0,10));
		p21.setBounds(384,70,116,20);
		//p21.add(meterreadercode);
		
		JPanel p22=new JPanel();
		p22.setLayout(new GridLayout(1,1,0,10));
		p22.setBounds(500,70,60,20);
		//p22.add(mr_code4);
		

    	JLabel p23=new JLabel("No of Instalments");			
		noofinst_lemg=new JTextField(10);				
		noofinst_semg=new JTextField(10);	
		noofinst_lr=new JTextField(10);	

		
		JPanel p24=new JPanel();
		p24.setLayout(new GridLayout(2,4,0,10));
		p24.add(amt);
		p24.add(lemgamt);
		p24.add(scmgamt);
		p24.add(lramt);
		p24.add(iamt);
		p24.add(ilemg);
		p24.add(iscmg);
		p24.add(ilr);
		p24.setBounds(50,150,500,60);
		
		
		//JPanel p25=new JPanel();
		//p25.setLayout(new FlowLayout());
     	//p25.setBounds(200,30,350,30);
     	//p25.add(mg);
     	
   		JPanel p26=new JPanel();
		p26.setLayout(new FlowLayout());
     	p26.setBounds(170,130,350,30);
     	p26.add(lemg);
     	p26.add(scmg);
   		p26.add(lr);
   		
   		JLabel lim=new JLabel("MG ends as on");//ending month of minimum gaurentee
   		JLabel mm7=new JLabel("Month & Year");
	
		m77=new JComboBox(mw);
		y77=new JComboBox(yw);
		
		
			JPanel p27=new JPanel();
		p27.setLayout(new FlowLayout());
     	p27.setBounds(50,230,250,30);
     	p27.add(lim);
     	p27.add(m77);
     	p27.add(y77);
     	
     	add_mg=new JButton("Enter");
     	//edit=new JButton("edit");
     	  		
   			JPanel p28=new JPanel();
		p28.setLayout(new FlowLayout());
     	p28.setBounds(270,230,200,40);
     	p28.add(add_mg);
     	//p28.add(edit);
     	
		
		panel4.add(p17);
		panel4.add(p18);
		panel4.add(p19);
		panel4.add(p20);
		panel4.add(p21);
		panel4.add(p22);
		panel4.add(p23);
		panel4.add(p24);
	//	panel4.add(p25);
		panel4.add(p26);
		panel4.add(p27);
		panel4.add(p28);
		
			tb = new JTabbedPane();
			
			panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
			panel2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(6),BorderFactory.createEmptyBorder(10,10,10,10)));
	    		panel3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
			panel4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),BorderFactory.createEmptyBorder(10,10,10,10)));
		
		
				tb.addTab("ConsumerDetails",panel1);
	       			 tb.addTab("MeterDetails",panel2);
		  		 tb.addTab("DepositDetails",panel3);
          				 //tb.addTab("Minimum gaurentee",panel4);
		

			cancel = new JButton("Cancel");
			JPanel pp = new JPanel();
			pp.setLayout(new FlowLayout());
			pp.add(cancel);
			getContentPane().add(tb,BorderLayout.CENTER);
			getContentPane().add(pp,BorderLayout.SOUTH);
			setLocation(120,70);
			cancel.addActionListener(this);
			add_cd.addActionListener(this);		
			add_md.addActionListener(this);
			add_dd.addActionListener(this);
			add_mg.addActionListener(this);
			area_code.addActionListener(this);
			mr_code.addActionListener(this);
			area_code.setSelectedIndex(0);
			mr_code.setSelectedIndex(0);
			}
		  public void actionPerformed(ActionEvent e)		
			{
					
			if(e.getSource()==cancel)
			{
				this.dispose();
			}
			else if(e.getSource()==area_code)
			{
				
				acode = (String)area_code.getSelectedItem();
			}
			else if(e.getSource()==mr_code)
			{
				mcode = (String)mr_code.getSelectedItem();
			}
			else if(e.getSource()==add_cd)
				{
					System.out.println("Entered Data");
					/*String consumertab="Data Inserted successfully";
					JOptionPane.showMessageDialog(null,consumertab);*/
				try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/electricity","root","");
				PreparedStatement pst = con.prepareStatement("insert into consumer values(?,?,?,?,?,?,?,?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				QueryData qd = new QueryData();
				Connection con1=qd.getConnect();
				//PreparedStatement pst11 = con1.prepareStatment("select * from consumer");
				pst.setString(1,con_no.getText());
				pst.setString(2,acode);	
				System.out.println("Area Code     :" +acode);
				pst.setString(3,mcode);
				System.out.println("Area Code     :" +mcode);
				pst.setString(4,(String)ta_riffcombobox.getSelectedItem());
				pst.setString(5,(String)cphase_combobox.getSelectedItem());
				pst.setString(6,post_no.getText());
				pst.setString(7,c_load.getText());
				pst.setString(8,con_name.getText());
				pst.setString(9,address.getText());
			
				String d,y,m,date;
				d=(String)dateofconnectio.getSelectedItem();
				m=(String)monthofconnection.getSelectedItem();
				y=(String)yearofconnection.getSelectedItem();
				date=d+"/"+m+"/"+y;
				pst.setString(10,date);
					pst.setString(11,tid.getText());
				int i=pst.executeUpdate();
				if(i>0)
				{
				System.out.println("Consumer Added");
				JOptionPane.showInternalMessageDialog(this,"Consumer Added","NEW CONSUMER ",1);
				}
			}
			catch(Exception ex)
				{
				//System.out.println(ex);
				ex.printStackTrace();
				}
        }
		else if(e.getSource()==add_md)
				{
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst1 = qd.getConnect().prepareStatement("insert into meterdetails values(?,?,?,?)");
					pst1.setString(1,(String)con_no1.getSelectedItem());
					pst1.setString(2,mtr_no.getText());
					pst1.setString(3,no_digit.getText());
					pst1.setString(4,i_r1.getText());

				
					int i=pst1.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"Meter details entered","NEW CONSUMER ",1);
					}
					

					}catch(Exception ex)
				{
						System.out.println("Inside Save   :" +ex);
						ex.printStackTrace();
				}
					
			}
			else if(e.getSource()==add_dd)
				{
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst2 = qd.getConnect().prepareStatement("insert into depositdetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst2.setString(1,(String)con_no3.getSelectedItem());
					pst2.setString(2,cash_deposit.getText());
					pst2.setString(3,ac_d.getText());
					pst2.setString(4,oyec_amt.getText());
					pst2.setString(5,totno_inst.getText());

					String y,m,date;
					m=(String)m55.getSelectedItem();
					y=(String)y55.getSelectedItem();
					//date=m+"/"+y;
					pst2.setString(6,m);
					pst2.setString(7,y);
					pst2.setString(8,receiptno1.getText());
					pst2.setString(12,receiptno2.getText());

					String ds,ys,ms,dates;
					ds=(String)d4.getSelectedItem();
					ms=(String)m4.getSelectedItem();
					ys=(String)y4.getSelectedItem();
					//dates=ds+"/"+ms+"/"+ys;
					pst2.setString(9,ds);
					pst2.setString(10,ms);
					pst2.setString(11,ys);
					String ds1,ys1,ms1,dates1;
					ds1=(String)d5.getSelectedItem();
					ms1=(String)m5.getSelectedItem();
					ys1=(String)y5.getSelectedItem();
					//dates1=ds1+"/"+ms1+"/"+ys1;
					pst2.setString(13,ds1);
					pst2.setString(14,ms1);
					pst2.setString(15,ys1);
					pst2.setString(16,inst_amt.getText());
					pst2.setString(17,paid_inst.getText());
					pst2.setString(18,bal_inst.getText());

					
					int i=pst2.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"Deposit details entered","NEW CONSUMER ",1);
					}
					

					}
				catch(Exception ex)
				{
					//System.out.println("Inside Save   :" +ex);
					ex.printStackTrace();
				}
				}
	
		
				else if(e.getSource()==add_mg)
				{
				try{
					QueryData qd = new QueryData();
					PreparedStatement pst3 = qd.getConnect().prepareStatement("insert into mg values(?,?,?,?,?,?,?,?)");
					
					pst3.setString(1,((String)con_no4.getSelectedItem()).trim());
					pst3.setInt(2,Integer.parseInt(lemgamt.getText()));
					pst3.setInt(3,Integer.parseInt(scmgamt.getText()));
					pst3.setInt(4,Integer.parseInt(lramt.getText()));
					pst3.setInt(5,Integer.parseInt(ilemg.getText()));
					pst3.setInt(6,Integer.parseInt(iscmg.getText()));
					pst3.setInt(7,Integer.parseInt(ilr.getText()));
					String y,m,mdate;
					m=(String)m77.getSelectedItem();
					System.out.println((String)m77.getSelectedItem());
					y=(String)y77.getSelectedItem();
					System.out.println((String)y77.getSelectedItem());
					mdate=m+"/"+y;
					pst3.setString(8,mdate);
					int i=pst3.executeUpdate(); 
					
					if(i>0)
					{
					JOptionPane.showInternalMessageDialog(this,"MG details entered","NEW CONSUMER ",1);
					}
					

					}catch(Exception ex)
				{
						System.out.println("Inside Save   :" +ex);
						ex.printStackTrace();
				}
			}	
	/*
	 * What does OYEC mean?

Own Your Electric Connection (OYEC) is a scheme in the Kerala Electricity Board in which service connections are provided by collecting charges from those who require connections over-riding the normal priority. 
	 * */		

}
}