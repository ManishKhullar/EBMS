//package updated1;

import java.io.*;
import java.sql.*;
import java.util.*;
class QueryData
{
	Connection con;
	PreparedStatement stat;
	public QueryData()
	{	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity","root","");
		}catch(Exception ex){
					//System.out.println("Error in QueryData" + ex);
					ex.printStackTrace();
				}
	}
	
	public Connection getConnect()
	{
		return con;
	}
	
	public Vector getConsumer()throws Exception
	{	
		stat = con.prepareStatement("select conno from consumer",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stat.executeQuery();
		Vector v = new Vector();
		while(rs.next())
		{
			v.addElement(rs.getString(1));
		}
		return v;
		
		
	}
	public Vector getConsumerDetails(String id)throws Exception
	{
		stat = con.prepareStatement("select * from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,id);
		ResultSet rs = stat.executeQuery();
		Vector v = new Vector();
		if(rs.next())
		{
			v.addElement(rs.getString(2));
			v.addElement(rs.getString(3));
			v.addElement(rs.getString(4));
			v.addElement(rs.getString(5));
			v.addElement(rs.getString(6));
			v.addElement(rs.getString(7));
			v.addElement(rs.getString(8));
			v.addElement(rs.getString(9));
			v.addElement(rs.getString(10));
		}
		return v;
	}

	public Vector getMeterDetails(String id)throws Exception
	{
		stat = con.prepareStatement("select  * from meterdetails where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,id);
		ResultSet rs = stat.executeQuery();
		Vector v2 = new Vector();
		if(rs.next())
		{
			v2.addElement(rs.getString(2));
			v2.addElement(rs.getString(3));
			v2.addElement(rs.getString(4));
			
		}
		return v2;
	}

	public Vector getDepositDetails(String id)throws Exception
	{
		stat = con.prepareStatement("select  * from depositdetails where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,id);
		ResultSet rs = stat.executeQuery();
		Vector v3 = new Vector();
		if(rs.next())
		{
			v3.addElement(rs.getString(2));
			v3.addElement(rs.getString(3));
			v3.addElement(rs.getString(4));
			v3.addElement(rs.getString(5));
			v3.addElement(rs.getString(6));
			v3.addElement(rs.getString(7));
			v3.addElement(rs.getString(8));
			v3.addElement(rs.getString(9));
			v3.addElement(rs.getString(10));
			v3.addElement(rs.getString(11));
			v3.addElement(rs.getString(12));
			v3.addElement(rs.getString(13));
			
			
		}
		return v3;
	}

	public Vector getMgDetails(String id)throws Exception
	{

		stat = con.prepareStatement("select  * from mg where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,id);
		ResultSet rs = stat.executeQuery();
		Vector v4 = new Vector();
		if(rs.next())
		{
			v4.addElement(rs.getString(2));
			v4.addElement(rs.getString(3));
			v4.addElement(rs.getString(4));
			v4.addElement(rs.getString(5));
			v4.addElement(rs.getString(6));
			v4.addElement(rs.getString(7));
			v4.addElement(rs.getString(8));
			
			
		}
		return v4;			
	}

	public Vector getAreaCode(String id)throws Exception
	{

		stat = con.prepareStatement("select  areacode,mrcode from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v5 = new Vector();
		if(rs.next())
		{
			v5.addElement(rs.getString(1));
			v5.addElement(rs.getString(2));
			System.out.println(v5);
			
			
		}
		return v5;
	}

	public Vector getCons(String acode,String mcode)throws Exception
	{
		stat = con.prepareStatement("select  conno from consumer where areacode=? and mrcode=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,acode);
		stat.setString(2,mcode);
		System.out.println("Aracode   " + acode);
		System.out.println("Meter Code " + mcode);
		ResultSet rs = stat.executeQuery();
		Vector v6 = new Vector();
		while(rs.next())
		{
			v6.addElement(rs.getString(1));
			
		}
		return v6;
	}

	public Vector getBillDetails(String id)throws Exception
	{
		stat = con.prepareStatement("select  areacode,mrcode from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,id);
		ResultSet rs = stat.executeQuery();
		Vector v7 = new Vector();
		if(rs.next())
		{
			
			v7.addElement(rs.getString(1));
			v7.addElement(rs.getString(2));
			
		}
		return v7;
	}

	public String getCdDetails(String id)throws Exception
	{
		String s=null;
		stat = con.prepareStatement("select adldeposit from depositdetails where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		stat.setString(1,id);
		ResultSet rs = stat.executeQuery();
		if(rs.next())
		  s=rs.getString(1);
		return s;
	}

	public String getCldetails(String id) throws Exception
	{
	String s=null;
	stat=con.prepareStatement("select connectedload from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stat.setString(1,id);
	ResultSet rs = stat.executeQuery();
	if(rs.next())
		  s=rs.getString(1);
		return s;
}
public String getInitialReading(String id) throws Exception
{
	String s=null;
	stat=con.prepareStatement("select initialreading from meterdetails where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stat.setString(1,id);
	ResultSet rs = stat.executeQuery();
	if(rs.next())
		  s=rs.getString(1);
		return s;
}

public String getTariff(String id) throws Exception
{
	String s=null;
	stat=con.prepareStatement("select tariff from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stat.setString(1,id);
	ResultSet rs = stat.executeQuery();
	if(rs.next())
		  s=rs.getString(1);
		return s;
}


		public Vector getDmdwithdraw(String id)throws Exception
	{

		stat = con.prepareStatement("select  demandid,unitconsumed,netamt from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v8 = new Vector();
		if(rs.next())
		 {
		 v8.addElement(rs.getString(1));
		 v8.addElement(rs.getString(2));
		 v8.addElement(rs.getString(3));
		 
		 
		 System.out.println(v8);	
		 }
		return v8;
}
		
	public Vector getCd(String id)throws Exception
	{

		stat = con.prepareStatement("select  deposit from depositdetails where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v9 = new Vector();
		if(rs.next())
		 {
		 v9.addElement(rs.getString(1));
		 
		 
		 System.out.println(v9);	
		 }
		 
		 
		return v9;
		}
		public Vector getCdadjt(String id)throws Exception
		{

		stat = con.prepareStatement("select  netamt from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v10 = new Vector();
		if(rs.next())
		 {
		 v10.addElement(rs.getString(1));
		 
		 
		 System.out.println(v10);	
		 }
		 
		 
		return v10;
		}
		
				public Vector getDmdwiew(String id)throws Exception
	{

	stat = con.prepareStatement("select areacode,mrcode,previousreading,presentreading,unitconsumed,demandid,fixedcharge,energycharge,duty,mtrrent,reconfee,demand,subsidy,advancepaid,previousarrears,total,intrestoncd,netamt,bd,dd,disd from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	//stat = con.prepareStatement("select  * from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v11 = new Vector();
		if(rs.next())
		 {
		 v11.addElement(rs.getString(1));
		 v11.addElement(rs.getString(2));
		 v11.addElement(rs.getString(3));
		 v11.addElement(rs.getString(4));
		 v11.addElement(rs.getString(5));
		 v11.addElement(rs.getString(6));
		 v11.addElement(rs.getString(7));
		 v11.addElement(rs.getString(8));
		 v11.addElement(rs.getString(9));
		 v11.addElement(rs.getString(10));
		 v11.addElement(rs.getString(11));
		 v11.addElement(rs.getString(12));
		 v11.addElement(rs.getString(13));
		 v11.addElement(rs.getString(14));
		 v11.addElement(rs.getString(15));
		 v11.addElement(rs.getString(16));
		 v11.addElement(rs.getString(17));
		 v11.addElement(rs.getString(18));
		 v11.addElement(rs.getString(19));
		 v11.addElement(rs.getString(20));
		 v11.addElement(rs.getString(21));
		 
		 
		 System.out.println(v11);	
		 }
		return v11;
	}
		
	public Vector getTid(String id)throws Exception
	{

	stat = con.prepareStatement("select tariffid from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	//stat = con.prepareStatement("select  * from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v12 = new Vector();
		if(rs.next())
		 {
		 v12.addElement(rs.getString(1));
		 
		  System.out.println(v12);	
		 }
		return v12;
	}
	
	
				public Vector getOyecdues(String id)throws Exception
	{

	stat = con.prepareStatement("select balnceinstalments  from depositdetails where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	//stat = con.prepareStatement("select  * from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v13 = new Vector();
		if(rs.next())
		 {
		 v13.addElement(rs.getString(1));
		 
		 
		 System.out.println(v13);	
		 }
		return v13;
	}
		
	
				public Vector getNetdem(String id)throws Exception
	{
	
		stat = con.prepareStatement("select netamt  from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	//stat = con.prepareStatement("select  * from demand where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	
		stat.setString(1,id);
		
		ResultSet rs = stat.executeQuery();
		
		Vector v14 = new Vector();
		if(rs.next())
		 {
		 v14.addElement(rs.getString(1));
		 
		 
		 System.out.println(v14);	
		 }
		return v14;
	}


public String getPhase(String id) throws Exception
{
	String s=null;
	stat=con.prepareStatement("select phase from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stat.setString(1,id);
	ResultSet rs = stat.executeQuery();
	if(rs.next())
		  s=rs.getString(1);
		return s;
}

public String getCl(String id) throws Exception
{
	String s=null;
	stat=con.prepareStatement("select connectedload from consumer where conno=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	stat.setString(1,id);
	ResultSet rs = stat.executeQuery();
	if(rs.next())
		  s=rs.getString(1);
		return s;
}

					
	/*	{
			v8.addElement(rs.getString(2));
			v8.addElement(rs.getString(3));
			v8.addElement(rs.getString(4));
			v8.addElement(rs.getString(5));
			v8.addElement(rs.getString(6));
			v8.addElement(rs.getString(7));
			v8.addElement(rs.getString(8));
			
			
		}
		return v8;			
	}*/
	
}