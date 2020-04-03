package com.ttjv.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ttjv.connection.JDBCConnection;
import com.ttjv.dao.BillProductDao;
import com.ttjv.model.Bill;
import com.ttjv.model.BillProduct;
import com.ttjv.model.Product;
import com.ttjv.model.User;

public class BillProductDaoImpl implements BillProductDao {

	@Override
	public void insert(BillProduct billProduct) {
		Connection connection= JDBCConnection.getConn();
		try {
			String sql="insert into billproduct(unitprice,quantity,id_bill, id_product) value(?,?,?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setLong(1, billProduct.getUnitPrice());
			preparedStatement.setInt(2, billProduct.getQuantity());
			preparedStatement.setInt(3, billProduct.getBill().getId());
			preparedStatement.setInt(4, billProduct.getProduct().getId());
			preparedStatement.executeUpdate();
		}catch(Exception e) {System.out.println("them loi>>"+e.getMessage());}
		
	}

	@Override
	public void update(BillProduct billProduct) {
		Connection connection= JDBCConnection.getConn();
		try {
			String sql="update billproduct set unitprice=?,quantity=?,id_bill=?, id_product=? where id=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setLong(1, billProduct.getUnitPrice());
			preparedStatement.setInt(2, billProduct.getQuantity());
			preparedStatement.setInt(3, billProduct.getBill().getId());
			preparedStatement.setInt(4, billProduct.getProduct().getId());
			preparedStatement.setInt(5, billProduct.getId());
			preparedStatement.executeUpdate();
		}catch(Exception e) {System.out.println("update loi>>"+e.getMessage());}
		
	}

	@Override
	public void delete(int id) {
		Connection connection= JDBCConnection.getConn();
		try {
			String sql="delete from billproduct where id=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();
		}catch(Exception e) {System.out.println("delete loi>>"+e.getMessage());}
		
	}

	@Override
	public BillProduct get(int id) {
		Connection connection= JDBCConnection.getConn();
		try {
			String sql= "SELECT bp.id as 'id', b.id as 'idbill' ,b.id_user as 'iduser' " + 
					", p.name as 'nameproduct' ,p.price as 'priceoneproduct' " + 
					",bp.quantity as 'quantitybuy', bp.unitprice as 'priceonebillproduct' , p.id as 'idproduct'" + 
					"FROM javacore14.billproduct bp " + 
					"inner join bill b " + 
					"on b.id= bp.id_bill " + 
					"inner join product p " + 
					"on bp.id_product= p.id where bp.id=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()) {
				BillProduct billProduct= new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setQuantity(rs.getInt("quantitybuy"));
				billProduct.setUnitPrice(rs.getLong("priceonebillproduct"));
				Bill bill= new Bill();
				bill.setId(rs.getInt("idbill"));
				User user= new User();
				user.setId(rs.getString("iduser"));
				bill.setUser(user);
				billProduct.setBill(bill);
				Product product= new Product();
				product.setId(rs.getInt("idproduct"));
				product.setName(rs.getString("nameproduct"));
				product.setPrice(rs.getInt("priceoneproduct"));
				billProduct.setProduct(product);
				return billProduct;
			}
		}catch(Exception exception) {System.out.println("get loi>>"+exception.getMessage());}
		return null;
	}

	@Override
	public List<BillProduct> search(String findName) {
		List<BillProduct> list=new ArrayList<>();
		Connection connection= JDBCConnection.getConn();
		try {
			String sql= "SELECT bp.id as 'id', b.id as 'idbill' ,b.id_user as 'iduser' " + 
					", p.name as 'nameproduct' ,p.price as 'priceoneproduct' " + 
					",bp.quantity as 'quantitybuy', bp.unitprice as 'priceonebillproduct' " + 
					"FROM javacore14.billproduct bp " + 
					"inner join bill b " + 
					"on b.id= bp.id_bill " + 
					"inner join product p " + 
					"on bp.id_product= p.id where p.name like ?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+ findName+"%");
			ResultSet rs= preparedStatement.executeQuery();
			while(rs.next()) {
				BillProduct billProduct= new BillProduct();
				billProduct.setId(rs.getInt("id"));
				billProduct.setQuantity(rs.getInt("quantitybuy"));
				billProduct.setUnitPrice(rs.getLong("priceonebillproduct"));
				Bill bill= new Bill();
				bill.setId(rs.getInt("idbill"));
				User user= new User();
				user.setId(rs.getString("iduser"));
				bill.setUser(user);
				billProduct.setBill(bill);
				Product product= new Product();
				product.setName(rs.getString("nameproduct"));
				product.setPrice(rs.getInt("priceoneproduct"));
				billProduct.setProduct(product);
				list.add(billProduct);
			}
		}catch(Exception exception) {System.out.println("get loi>>"+exception.getMessage());}
		return list;
	}
	
}
