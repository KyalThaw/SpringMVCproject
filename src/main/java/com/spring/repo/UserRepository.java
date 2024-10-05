package com.spring.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spring.model.BookBean;
import com.spring.model.LoginBean;
import com.spring.model.UserBean;

public class UserRepository {
	
	public int insertUser(UserBean bean) {
		int i = 0;
		
		Connection con = UserConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into users(name,email,password) value (?,?,?)");
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert error : " + e.getMessage());
		}
		
		return i;
		
	} 
	public boolean checkEmail(String email) {
		  boolean check=false;
		  Connection con = UserConnection.getConnection();
		  String sql ="select * from users where email = ?";
		   try {
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1,email);
		   ResultSet rs = ps.executeQuery();
		   
		   while(rs.next()) {
		    check=true;
		   }
		   
		  } catch (SQLException e) {
		   System.out.println("Check email:"+e.getMessage());
		  }
		  
		  return check;
		  
		  
		 }

	public UserBean loginUser(LoginBean bean) {
		  UserBean user = null;
		  Connection con = UserConnection.getConnection();
		  String sql ="select * from users where email = ? and password = ?";
		   try {
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1, bean.getEmail());
		   ps.setString(2,bean.getPassword());
		   
		   ResultSet rs = ps.executeQuery();
		   
		   while(rs.next()) {
		    user = new UserBean();
		   
		    user.setId(rs.getInt("id"));
		    user.setEmail(rs.getString("email"));
//		    user.setPassword(rs.getString("password"));
		    user.setName(rs.getString("name"));
		    user.setRole(rs.getString("role"));
		   }
		   
		  } catch (SQLException e) {
		   System.out.println("Login user "+e.getMessage());
		   
		  }
		  
		  return user;		  
		 
	}
	
	public int updateBook(BookBean bean) {
		int i = 0;
		
		Connection con = UserConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(null);
			ps.setString(1, bean.getTitle());
			ps.setString(1, bean.getAuthor());
			ps.setDouble(3, bean.getPrice());
			ps.setInt(4, bean.getId());
			
			i = ps.executeUpdate(); 
			
		} catch (SQLException e) {
			System.out.println("Update Book : "+ e.getMessage());
			
		}
		
		return i;
		
		
	}
	}

