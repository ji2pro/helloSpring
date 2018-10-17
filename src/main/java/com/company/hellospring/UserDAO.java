package com.company.hellospring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	//싱글톤 필요없음
	
	//등록
	public int insertUser(UserDTO dto) {
		int r = 0;
		try {
			//1단계 : connect
			conn = DBConnection.getConnection();
			//2단계 : statement
			String sql = "INSERT INTO USERS(ID, PASSWORD, NAME, ROLE) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//3단계 : 실행
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getRole());
			r = pstmt.executeUpdate();  //처리건수
			//4단계 : 결과 처리
			System.out.println(r + " 건이 처리됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5단계 : 연결 해제
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r;
	}
	
	//단건 조회
	public UserDTO getUser(UserDTO dto) {
		UserDTO userDTO = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM USERS WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userDTO = new UserDTO();
				userDTO.setId(rs.getString("id"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setName(rs.getString("name"));
				userDTO.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5단계 : 연결 해제
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userDTO;
	}
	//전체 조회
	public List<UserDTO> getUsers() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		UserDTO userDTO = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM USERS ORDER BY ID";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userDTO = new UserDTO();
				userDTO.setId(rs.getString("id"));
				userDTO.setPassword(rs.getString("password"));
				userDTO.setName(rs.getString("name"));
				userDTO.setRole(rs.getString("role"));
				list.add(userDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5단계 : 연결 해제
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//수정
	
	//삭제
	
	/*private Connection conn = null;*/
	   
	/*private void connect() {
		try {
			String user = "spring"; 
			String pw = "spring";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
	            
			Class.forName("oracle.jdbc.driver.OracleDriver");        
			conn = DriverManager.getConnection(url, user, pw);
	            
			System.out.println("Database에 연결되었습니다.\n");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
		} catch (SQLException sqle) {
			System.out.println("DB 접속 실패 : "+sqle.toString());
        } catch (Exception e) {
        	System.out.println("Unkonwn error");
        	e.printStackTrace();
        }
	}*/
	   
	/*public void insertUser() {
		PreparedStatement pstmt = null;
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO (ID, PASSWORD, NAME, ROLE ) ");
		sql.append("VALUES(?,?,?,?)");
		int check = 0;
		try {
			connect();         
			pstmt = conn.prepareStatement(sql.toString());
			check = pstmt.executeUpdate();
			if(check > 0) System.out.println("success");
			else System.out.println("fail");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}      
	}*/
	   
	
	public int getPassword(String id) {
		int r = 0;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT PASSWORD FROM USERS WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			r = pstmt.executeUpdate();
			System.out.println(r + " 건이 처리됨");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5단계 : 연결 해제
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return r;
	}
	   
	/*public List<UserDTO> getUsers(){
		List<UserDTO> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO dto = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ID, PASSWORD, NAME, ROLE ");
		sql.append("FROM users ");
	      
		try {
			connect();
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<UserDTO>();
	         
			while(rs.next()) {
	            dto = new UserDTO();
	            dto.setId(rs.getString("id"));
	            dto.setName(rs.getString("name"));
	            dto.setPassword(rs.getString("password"));
	            dto.setRole(rs.getString("role"));
	            list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
	            if(pstmt != null) pstmt.close();
	            if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}*/
}
