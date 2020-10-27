package com.ttjv.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ttjv.connection.JDBCConnection;
import com.ttjv.dao.BillDao;
import com.ttjv.model.Bill;
import com.ttjv.model.User;

public class BillDaoImpl implements BillDao {

	@Override
	public void insert(Bill bill) {
		Connection connection = JDBCConnection.getConn();
		try {
			String sql = "insert into bill(id_user,buydate,pricetotal) value(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, bill.getUser().getId());
			preparedStatement.setString(2, bill.getBuyDate());
			preparedStatement.setLong(3, bill.getPriceTotal());
			preparedStatement.executeUpdate();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();// lay id dc tao tu dong trong DB ra de luu
																			// vao billproduct
			if (generatedKeys.next()) {
				bill.setId(generatedKeys.getInt(1));// id cua bill
			}
		} catch (Exception e) {
			System.out.println("them loi>>" + e.getMessage());
		}

	}

	@Override
	public void update(Bill bill) {
		Connection connection = JDBCConnection.getConn();
		try {
			String sql = "update bill set id_user=?,buydate=?,pricetotal=? where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, bill.getUser().getId());
			preparedStatement.setString(2, bill.getBuyDate());
			preparedStatement.setLong(3, bill.getPriceTotal());
			preparedStatement.setInt(4, bill.getId());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("update loi>>" + e.getMessage());
		}

	}

	@Override
	public void delete(int id) {
		Connection connection = JDBCConnection.getConn();
		try {
			String sql = "delete from bill where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete loi>>" + e.getMessage());
		}

	}

	@Override
	public Bill get(int id) {
		Connection connection = JDBCConnection.getConn();
		try {
			String sql = "SELECT b.id as 'id', u.name as 'name', u.age as 'age',u.address as 'address' ,u.id as 'iduser',b.buydate as 'buydate', b.pricetotal as 'pricetotal'"
					+ " FROM javacore14.bill b " + "inner join user u " + "on b.id_user=u.id where u.id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("id"));
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setAddress(rs.getString("address"));
				user.setId(rs.getString("iduser"));
				bill.setUser(user);
				bill.setBuyDate(rs.getString("buydate"));
				bill.setPriceTotal(Long.parseLong(rs.getString("pricetotal")));
				return bill;
			}

		} catch (Exception e) {
			System.out.println("get loi" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Bill> search(String findName) {
		List<Bill> list = new ArrayList<>();
		Connection connection = JDBCConnection.getConn();
		try {
			String sql = "SELECT b.id as 'id', u.name as 'name', u.age as 'age',u.address as 'address' ,b.buydate as 'buydate', b.pricetotal as 'pricetotal'"
					+ " FROM javacore14.bill b " + "inner join user u " + "on b.id_user=u.id where u.name like?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + findName + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill();
				bill.setId(rs.getInt("id"));
				User user = new User();
				user.setName(rs.getString("name"));
				user.setAge(rs.getString("age"));
				user.setAddress(rs.getString("address"));
				bill.setUser(user);
				bill.setBuyDate(rs.getString("buydate"));
				bill.setPriceTotal(Long.parseLong(rs.getString("pricetotal")));
				list.add(bill);
			}

		} catch (Exception e) {
			System.out.println("search loi" + e.getMessage());
		}
		return list;
	}

}
