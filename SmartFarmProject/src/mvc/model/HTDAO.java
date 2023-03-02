package mvc.model;

import java.util.List;
import java.util.Vector;

import common.JDBCConnect;

public class HTDAO extends JDBCConnect {

public HTDTO selectHT() {
	new JDBCConnect();
	HTDTO dto = new HTDTO();
	String sql = "select * from HTtest";
	try {
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			dto.setHum(rs.getFloat(1));
			dto.setTemp(rs.getFloat(2));
		}
	} catch (Exception e) {
		System.out.println("온습도가져오기 오류");
		e.printStackTrace();
	}
	return dto;
}

public void close() {
	try {
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(psmt!=null) psmt.close();
		if(con!=null) con.close();
		System.out.println("데이터베이스 해제 성공");
	} catch(Exception e) {
		System.out.println("데이터베이스 해제 실패");
		e.printStackTrace();
	}
}
}
