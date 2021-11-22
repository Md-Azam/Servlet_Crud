package test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmployeDAO {
public static Connection getConnection() {
		Connection con= null;	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe" ,"system" ,"Sadaf12");
		}catch(Exception e ) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
public static int Save(Employe1 ep) {
int status =0;
		try {
			Connection con =EmployeDAO.getConnection();
			PreparedStatement pst =con.prepareStatement(
					"insert into employe486(id,name,password,email,country) values (?,?,?,?,?)");
			pst.setInt(1, ep.getId());
			pst.setString(2,ep.getName());
			pst.setString(3, ep.getPassword());
			pst.setString(4,ep.getEmail());
			pst.setString(5, ep.getCountry());
			
			status = pst.executeUpdate();
			con.close();
			
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return status;
	}
	
public static int update(Employe1 ep) {
int status =0;
	try {
		Connection con =EmployeDAO.getConnection();
		PreparedStatement pst =con.prepareStatement(
				" update Employe486 set name=? ,password= ?,email =?,country=? where id=?");
		pst.setString(1,ep.getName());
		pst.setString(2, ep.getPassword());
		pst.setString(3,ep.getEmail());
		pst.setString(4, ep.getCountry());
		pst.setInt(5,ep.getId());
		status =pst.executeUpdate();
		con.close();
		
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}
	return status;
	}

public static int delete(int id) {
	int status =0;
	try {
		
		Connection con =EmployeDAO.getConnection();
		PreparedStatement pst =con.prepareStatement("delete from employe486 where id=?");
		pst.setInt(1, id);
		
		status =pst.executeUpdate();
		con.close();
	}catch(Exception ex) {
	ex.printStackTrace();
	}
	return status;
}

public static Employe1 getEmployeById(int id) {
	
	Employe1 ep =new Employe1();
	
	try {
		Connection con =EmployeDAO.getConnection();
		PreparedStatement pst =con.prepareStatement("select from employe486 where id=?");
		pst.setInt(1, id);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			ep.setId(rs.getInt(1));
			ep.setName(rs.getString(2));
			ep.setPassword(rs.getString(3));
			ep.setEmail(rs.getString(4));
			ep.setCountry(rs.getString(5));
		}
		
		con.close();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return ep;
}


public static List<Employe1> getAllEmployees(){
	List<Employe1> list = new ArrayList<Employe1>();
	try {
		Connection con =EmployeDAO.getConnection();
		PreparedStatement pst =con.prepareStatement("select * from employe486");
		
		ResultSet rs =pst.executeQuery();
		while(rs.next()) {
			Employe1 ep = new Employe1();
			
			ep.setId(rs.getInt(1));
			ep.setName(rs.getString(2));
			ep.setPassword(rs.getString(3));
			ep.setEmail(rs.getString(4));
			ep.setCountry(rs.getString(5));
			
			list.add(ep);
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return list;
}


}

/*desc employe486;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
ID                                        NOT NULL VARCHAR2(12)
NAME                                               VARCHAR2(16)
PASSWORD                                           VARCHAR2(18)
EMAIL                                              VARCHAR2(20)
COUNTRY                                            VARCHAR2(16) -----*/








