package com.individual.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {

	private static BoardDAO dao = new BoardDAO();

	private PreparedStatement pstmt;
	private Connection con;
	private ResultSet rs;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "scott";
	private String pwd = "tiger";

	public static BoardDAO getInstance() {
		return dao;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle connect");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("Connection Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int updateMember(UserVO uVo) {

		int result = 0;

		try {
			connDB();
			String sql = "UPDATE userlist" + " SET pwd = ?, name = ?, mobile = ?, email = ?" + " WHERE id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uVo.getPwd());
			pstmt.setString(2, uVo.getUserName());
			pstmt.setString(3, uVo.getMobile());
			pstmt.setString(4, uVo.getEmail());
			pstmt.setString(5, uVo.getUserId());

			result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.print("Update success!!");
			} else {
				System.out.print("Update fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public int addMember(UserVO uVo) {

		int result = 0;

		try {
			connDB();
			String sql = "INSERT INTO userlist(id, pwd, name, mobile, email)" + "VALUES (?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uVo.getUserId());
			pstmt.setString(2, uVo.getPwd());
			pstmt.setString(3, uVo.getUserName());
			pstmt.setString(4, uVo.getMobile());
			pstmt.setString(5, uVo.getEmail());

			result = pstmt.executeUpdate();
			
			if (result == 1) {
				System.out.print("Add success!!");
			} else {
				System.out.print("Add fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public UserVO getMember(String userid) {

		UserVO uVo = new UserVO();

		try {
			connDB();
			String sql = "SELECT * FROM userlist WHERE id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				uVo.setUserId(rs.getString("id"));
				uVo.setPwd(rs.getString("pwd"));
				uVo.setUserName(rs.getString("name"));
				uVo.setMobile(rs.getString("mobile"));
				uVo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return uVo;
	}

	public int userCheck(String userid, String pwd) {

		int result = -1;

		try {
			connDB();
			String sql = "SELECT pwd FROM userlist WHERE id = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<BoardVO> getBoardList() {

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		try {
			connDB();
			String sql = "SELECT * FROM boardlist";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setUserId(rs.getString("id"));
				bVo.setPwd(rs.getString("pwd"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContents(rs.getString("contents"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public BoardVO getBoard(int num) {

		BoardVO bVo = new BoardVO();

		try {
			connDB();
			String sql = "SELECT * FROM boardlist WHERE num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setUserId(rs.getString("id"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
				bVo.setContents(rs.getString("contents"));
				bVo.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bVo;
	}

	public int setBoard(BoardVO bVo) {

		int result = 0;

		try {
			connDB();
			String sql = "INSERT INTO boardlist(num, id, pwd, title, contents)" + " VALUES (BOARD_SEQ.nextval,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bVo.getUserId());
			pstmt.setString(2, bVo.getPwd());
			pstmt.setString(3, bVo.getTitle());
			pstmt.setString(4, bVo.getContents());

			result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.print("INSERT success!!");
			} else {
				System.out.print("INSERT fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateBoard(BoardVO bVo) {

		int result = 0;

		try {
			connDB();
			String sql = "UPDATE boardlist" + " SET pwd=?, title=?, contents=?" + " WHERE num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bVo.getPwd());
			pstmt.setString(2, bVo.getTitle());
			pstmt.setString(3, bVo.getContents());
			pstmt.setInt(4, bVo.getNum());

			result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.print("Update success!!");
			} else {
				System.out.print("Update fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public void deleteBoard(int num) {

		int result = 0;

		try {
			connDB();
			String sql = "DELETE FROM boardlist" + " WHERE num = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			System.out.println(num);

			result = pstmt.executeUpdate();

			if (result == 1) {
				System.out.print("Delete success!!");
			} else {
				System.out.print("Delete fail!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
