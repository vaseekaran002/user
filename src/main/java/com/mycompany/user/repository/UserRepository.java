package com.mycompany.user.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mycompany.user.pojo.User;
import com.mycompany.user.util.DBUtil;

@Repository
public class UserRepository {

	
	public void closeConnection(Connection connection,PreparedStatement st) {
		try {
			if(st != null)
			st.close();
			if(connection != null)
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Value("${userinsert}")
	private String insert;
	@Value("${userupdate}")
	private String update;
	@Value("${userdelete}")
	private String delete;
	@Value("${userselect}")
	private String select;
	public void createUser(User user) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			 connection = DBUtil.getDBConnection();
		     st = connection.prepareStatement(insert);
		     st.setInt(1, user.getId());
		     st.setString(2, user.getName());
		     st.setString(3, user.getPhone());
		     int rs = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection,st);	
		}
	}
	
	public void deleteUser(User user) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			 connection = DBUtil.getDBConnection();
		     st = connection.prepareStatement(delete);
		     st.setInt(1, user.getId());
		     int rs = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection,st);
		}
		
	}
	
	public void updateUser(User user) {
		Connection connection = null;
		PreparedStatement st = null;
		try {
			 connection = DBUtil.getDBConnection();
		     st = connection.prepareStatement(update);
		     st.setInt(2, user.getId());
		     st.setString(1, user.getName());
		     int rs = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection(connection,st);			
		}
	}
	
	public void display() {
		Statement st = null;
		ResultSet rs = null;
		Connection connection = null;
		try {
			 connection = DBUtil.getDBConnection();
		     st= connection.createStatement();
		     rs = st.executeQuery(select);
		     while(rs.next()){
	            System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(st != null)
				st.close();
				if(connection != null)
				connection.close();
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
