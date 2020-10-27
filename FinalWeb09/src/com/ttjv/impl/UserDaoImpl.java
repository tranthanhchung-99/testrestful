package com.ttjv.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ttjv.connection.JDBCConnection;
import com.ttjv.dao.UserDao;
import com.ttjv.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "insert into user( name, age, role, imageUrl, username,matkhau,gender,address) value(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(sql);

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAge());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.setString(4, user.getImageUrl());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getMatKhau());
			preparedStatement.setString(7, user.getGender());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("them loi" + e.getMessage());
		}

	}

	@Override
	public void update(User user) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "update user set name=?, age=?, role=?,imageUrl=?,username=?,matkhau=?,gender=?,address=? where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(9, Integer.parseInt(user.getId()));
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getAge());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.setString(4, user.getImageUrl());
			preparedStatement.setString(5, user.getUserName());
			preparedStatement.setString(6, user.getMatKhau());
			preparedStatement.setString(7, user.getGender());
			preparedStatement.setString(8, user.getAddress());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("update loi" + e.getMessage());
		}

	}

	@Override
	public void delete(String id) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "delete from user where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("xoa loi " + e.getMessage());
		}

	}

	@Override
	public List<User> search(String findName) {
		List<User> list = new ArrayList<>();
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "select* from user where name like?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, "%" + findName + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setRole(rs.getString("role"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setImageUrl(rs.getString("imageUrl"));
				user.setUserName(rs.getString("username"));
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
				list.add(user);
			}
		} catch (Exception e) {
			System.out.println("tim theo ten loi " + e.getMessage());
		}
		return list;
	}

	@Override
	public User get(String id) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "select* from user where id =?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(String.valueOf(rs.getInt("id")));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setRole(rs.getString("role"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setImageUrl(rs.getString("imageUrl"));
				user.setUserName(rs.getString("username"));
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
				return user;
			}
		} catch (Exception e) {
			System.out.println("tim theo ten loi " + e.getMessage());
		}
		return null;
	}

	@Override
	public User getByUserName(String userName) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "select* from user where username =?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(String.valueOf(rs.getInt("id")));
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setRole(rs.getString("role"));
				user.setMatKhau(rs.getString("matkhau"));
				user.setImageUrl(rs.getString("imageUrl"));
				user.setUserName(rs.getString("username"));
				user.setGender(rs.getString("gender"));
				user.setAddress(rs.getString("address"));
				return user;
			}
		} catch (Exception e) {
			System.out.println("tim theo nick loi " + e.getMessage());
		}
		return null;
	}

	@Override
	public void updatePass(User user) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "update user set matkhau=? where id=?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(2, Integer.parseInt(user.getId()));

			preparedStatement.setString(1, user.getMatKhau());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("update pass loi" + e.getMessage());
		}

	}

}
