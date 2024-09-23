package com.sist.temp;
import java.util.*;
import java.sql.*;
public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public GoodsDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insert(StoreVO svo,InputVO ivo) {
		try {
			getConnection();
			conn.setAutoCommit(false);
			String sql="INSERT INTO input VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ivo.getNo());
			ps.setInt(2, ivo.getGno());
			ps.setInt(3, ivo.getPrice());
			ps.executeUpdate();
			
			sql="INSERT INTO store VALUES(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, svo.getNo());
			ps.setInt(2, svo.getGno());
			ps.setInt(3, svo.getPrice());
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			// TODO: handle exception
		}finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			disConnection();
		}
	}
}
