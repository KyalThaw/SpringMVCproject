package com.spring.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.spring.model.BookBean;

public class BookRepository {
	public List<BookBean> showAllBook(){
		List<BookBean> bookList = new ArrayList<BookBean>();
		
		BookBean Book = null;
		  Connection con = UserConnection.getConnection();
		  String sql ="SELECT * FROM book where status <>0;";
		   try {
		   PreparedStatement ps=con.prepareStatement(sql);
		   		   
		   ResultSet rs = ps.executeQuery();
		   
		   while(rs.next()) {
			   Book= new BookBean();
			   Book.setId(rs.getInt(1));
			   Book.setTitle(rs.getString(2));
			   Book.setAuthor(rs.getString(3));
			   Book.setPrice(rs.getDouble(4));
			   
			   bookList.add(Book);
		   }
		   
		  } catch (SQLException e) {
		   System.out.println("Book List "+e.getMessage());
		   
		  }

		
		return bookList;
		
	}
	
	public BookBean showBookById(int bookId) {
	      BookBean book= null;
	      
	      String sql = "SELECT * FROM book WHERE id=?";
	      try {
	        Connection con = UserConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql);
	      ps.setInt(1,bookId);
	      ResultSet rs = ps .executeQuery();
	      while(rs.next()) {
	        book = new BookBean();
	        book.setId(rs.getInt(1));
	        book.setTitle(rs.getString(2));
	        book.setAuthor(rs.getString(3));
	        book.setPrice(rs.getInt(4));
	        
	        
	      }
	      } catch (SQLException e) {
	        book = null;
	      System.out.println("book edit error:"+e);
	      }
	      return book;
	    
	    }
		
	public int updateBook(BookBean bean) {
		  int i=0;
		   Connection con= UserConnection.getConnection();
		   String sql = "update book set title=?,author=?,price=? where id=?";
		   try {
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setString(1, bean.getTitle());
		   ps.setString(2, bean.getAuthor());
		   ps.setDouble(3, bean.getPrice());
		   ps.setInt(4,bean.getId());
		   
		    i = ps.executeUpdate();
		  } catch (SQLException e) {
		   System.out.println("update book error:"+e.getMessage());
		  }
		   
		  
		  return i;
		  
		 }
	
	public int deleteBook(int id) {
	      
	      int i = 0;
	      Connection con = UserConnection.getConnection();
	      try {
	      PreparedStatement ps = con.prepareStatement("update book set status = 0 where id = ?");
	      ps.setInt(1, id);

	      i = ps.executeUpdate();
	      
	    } catch (SQLException e) {
	      System.out.println("update book :" + e.getMessage());
	    }
	    return i;
}
}
