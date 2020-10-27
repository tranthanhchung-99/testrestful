package com.ttjv.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ttjv.connection.JDBCConnection;
import com.ttjv.dao.LuotTruyCapDao;
import com.ttjv.model.LuotTruyCap;

public class LuotTruyCapDaoImpl implements LuotTruyCapDao {

	@Override
	public void update(LuotTruyCap cap) {
		Connection connection = JDBCConnection.getConn();

		try {
			String sql = "update demluot set soluot=? where id=1;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cap.getSoLuot());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("loi up" + e.getMessage());
		}

	}

	@Override
	public LuotTruyCap search() {
		Connection connection = JDBCConnection.getConn();
		LuotTruyCap cap = new LuotTruyCap();
		try {
			String sql = "select soluot from demluot where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				cap.setSoLuot(rs.getString("soluot"));
			}

		} catch (Exception e) {
			System.out.println("loi" + e.getMessage());
		}
		return cap;
	}

}
