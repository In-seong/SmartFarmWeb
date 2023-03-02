package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;



public class JDBCConnect {
	public Connection con;		//데이터 베이스 연경
	public Statement stmt;		// 파라미터 없는 정적 쿼리문
	public PreparedStatement psmt;	// 파라미터 있는 동적 쿼리문
	public ResultSet rs;
	
	public String userName;
	public String userfile;
	public String check_Id;
	public String check_Pw;
	
	public JDBCConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://3.38.21.49:3306/test?useSSL=false";
			String id = "master_user";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("DB 연결 성공(기본생성자)");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결실패");
		}
		
		
	}
	public int checkId(String Id, String Pw) {
		
		int result =0;
		String sql = "select * from member";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				check_Id = rs.getString(1);
				check_Pw = rs.getString(2);
				if(Id.equals(check_Id)&&Pw.equals(check_Pw)) {
					result =1;
					userName = rs.getString(3);
					userfile = rs.getString(4);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public int checkId2(String Id) { //기존 회원 확인
		
		int result =0;
		String sql = "select * from member";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				check_Id = rs.getString(1);
				if(Id.equals(check_Id)) {
					result =1;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("기존 아이디 확인 실패");
		}
		return result;
	}
	
	public void makeId(String Id, String Pw,String name, String filename) {
		String sql = "insert into member values(?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Pw);
			psmt.setString(3, name);
			psmt.setString(4, filename);
			psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("아이디 만들기 실패");
		}
		close();
	}

	public void deleteId(String Id, String Pw) {
		String sql = "delete from member where id=? and pass=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Pw);
			psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		
	}
	public int editMember(String Id, String Pw, String name) {
		int result =0;
		String sql = "update member set pass = ? , name = ? where id= ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Pw);
			psmt.setString(2, name);
			psmt.setString(3, Id);
			result =psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return result;
		
	}
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	
	
