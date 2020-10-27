package com.ttjv.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;

import com.ttjv.dao.CategoryDao;
import com.ttjv.connection.JDBCConnection;
import com.ttjv.connection.*;
import com.ttjv.model.Category;

public class CategoryDaoImpl implements CategoryDao {
	private Category rowMap(ResultSet rs) throws Exception{
		Category c = new Category();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));

		return c;
	}

	@Override
	public void insert(Category category) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "insert into category (name) value (?);";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, category.getName());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("them loi");
		}

	}

	@Override
	public void update(Category category) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "update category set name=? where id=?;";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, category.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("update loi");
		}

	}

	@Override
	public void delete(int id) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "delete from category  where id=?;";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("xoa loi");
		}

	}

	@Override
	public Category get(int id) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "select * from category where id=?;";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
//				Category category = new Category();
//				category.setId(rs.getInt("id"));
//				category.setName(rs.getString("name"));
				return rowMap(rs);
			}
		} catch (Exception e) {
			System.out.println("tim theo id loi");
		}
		return null;
	}

	@Override
	public List<Category> search(String findName) {
		Connection con = JDBCConnection.getConn();
		List<Category> list = new ArrayList<Category>();
		try {
			String sql = "select id, name from category where name like ?;";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "%" + findName + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
//				Category category = new Category();
//				category.setId(rs.getInt("id"));
//				category.setName(rs.getString("name"));
				list.add(rowMap(rs));
			}
		} catch (Exception e) {
			System.out.println("tim theo ten loi");
		}
		return list;
	}

	@Override
	public List<Category> search(String findName, int offset, int maxPerPage) {
		List<Category> list= new ArrayList<Category>();
		Connection con = JDBCConnection.getConn();
		try {
			String sql="select * from category where name like ? limit ? offset ? ";
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, "%"+findName+"%");
			preparedStatement.setInt(2, offset);
			preparedStatement.setInt(3, maxPerPage);
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()) {
				list.add(rowMap(rs));//gom vao 1 ham??
			}
		}catch(Exception e) {System.out.println("loi search 3 tham so"+e.getMessage());}
		return list;
	}

	@Override
	public int count(String findName) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql="select count(*) as 'total' from category where name like ?";
			PreparedStatement preparedStatement= con.prepareStatement(sql);
			preparedStatement.setString(1, "%"+findName+"%");
			ResultSet rs =preparedStatement.executeQuery();
			while(rs.next()) {
				return rs.getInt("total");
			}
		}catch(Exception e) {System.out.println("loi dem so hang"+e.getMessage());}
		return 0;
	}

	

}
