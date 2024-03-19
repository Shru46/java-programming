import java.sql.*;
import java.util.*;
class JDBC_1{
public static void main(String args[]) throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","pat","pat");
	Statement stmt=con.createStatement();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter first Name");
	String fname=sc.next();
	System.out.println("Enter Last Name");
	String lname=sc.next();
	System.out.println("Enter email:");
	String email=sc.next();
	System.out.println("Enter Password:");
	String pass=sc.next();
	System.out.println("Enter Moblie");
	long mobile=sc.nextLong();
	sc.nextLine();
	System.out.println("Enter Address");
	String address=sc.next();
	int regid=0;
	ResultSet rs=stmt.executeQuery("select max(regid) from register");
	if(rs.next()){
		regid=rs.getInt(1);
	}
	regid++;
	PreparedStatement pstmt=con.prepareStatement("Insert into register values(?,?,?,?,?,?,?)");
	pstmt.setInt(1,regid);
	pstmt.setString(2,fname);
	pstmt.setString(3,lname);
	pstmt.setString(4,email);
	pstmt.setString(5,pass);
	pstmt.setLong(6,mobile);
	pstmt.setString(7,address);
	int i=pstmt.executeUpdate();
	if(i==1)
		System.out.println("Record inserted");
	pstmt.close(); rs.close(); stmt.close();con.close();
}
}

	