/*program to demonstrate JDBC with MYSQL*/
import java.sql.*;
public class MDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	try
	{	
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","cbkpc","cbkpc");
	    		
		st=con.createStatement();
		String s="insert into emp values(6,'siddu',800)";
		st.executeUpdate(s);
		rs=st.executeQuery("select * from emp");
			
		while(rs.next())
		{
		    System.out.print(rs.getInt(1));
		    System.out.print("\t"+rs.getString(2));
		    System.out.print("\t"+rs.getInt(3));
		    System.out.print("\n");
		    }
	}
		catch(Exception e)
		{
			System.out.println("Exception"+e);	
		}
		finally
		{
			try
	           {
				rs.close();
				st.close();
				con.close();
	           }
			catch(Exception e)
			{
				System.out.println("Exception"+e);	
			}
		}
	}
}

