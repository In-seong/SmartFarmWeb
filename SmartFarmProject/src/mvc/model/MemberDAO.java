package mvc.model;

import common.JDBCConnect;

public class MemberDAO extends JDBCConnect {

	public int loginCheck(String Id) { // 기존 회원 확인

		int result = 0;
		String sql = "select * from user";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				check_Id = rs.getString(1);
				if (Id.equals(check_Id)) {
					result = 1;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("기존 아이디 확인 실패");
		}
		return result;
	}
	
	// 회원 가입
	public void makeMember(String Id, String Pw, String name, String email, String tell) {
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Pw);
			psmt.setString(3, name);
			psmt.setString(4, email);
			psmt.setString(5, tell);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이디 만들기 실패");
		}
		close();
	}
	
	// 회원 탈퇴
	public void deleteId(String Id, String Pw) {
		String sql = "delete from member where id=? and pass=?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Id);
			psmt.setString(2, Pw);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("아이디 삭제 실패");
		}
		close();
	}
	
	// 회원 정보 수정
	public int editMember(String Id, String Pw, String name, String tell) {
		int result =0;
		String sql = "update member set pass = ? , name = ? , tell = ? where id= ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, Pw);
			psmt.setString(2, name);
			psmt.setString(3, tell);
			psmt.setString(4, Id);
			result =psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("회원 정보 수정 실패");
		}
		close();
		return result;
	}
}
