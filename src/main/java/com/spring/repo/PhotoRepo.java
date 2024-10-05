package com.spring.repo;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.spring.model.PhotoBean;
import com.spring.model.UserBean;

public class PhotoRepo {
	
	public int insertUser(byte[] test) {
		int i = 0;
		
		Connection con = Image.getConnection();
		
	try {
		PreparedStatement ps = con.prepareStatement("insert into test(photo) values(?)");
		ps.setBytes(1, test);
		i = ps.executeUpdate();
		
		
	} catch (SQLException e) {
		System.out.println("Insert error: "+ e.getMessage());
		
	}
	
		return i;
	}
	
	public PhotoBean viewPhoto(PhotoBean photo) throws SQLException,IOException {
		 PhotoBean bean = null;
		 Connection con = Image.getConnection();
		 String query = "Select * from test";
		 
		 PreparedStatement ps = con.prepareStatement(query);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) {
			 bean = new PhotoBean();
			 bean.setId(rs.getInt("id"));
			 Blob blob = rs.getBlob("photo");
			 byte[] photoByte= blob.getBytes(1, (int) blob.length());
			 bean.setPhotoByte(photoByte);
		 }
		 
		 return bean;
		
	}
	 

}
