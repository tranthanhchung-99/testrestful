package com.ttjv.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ttjv.dao.ProductDao;
import com.ttjv.connection.JDBCConnection;
import com.ttjv.model.Category;
import com.ttjv.model.Product;

public class ProductDaoImpl  implements ProductDao{

	@Override
	public void insert(Product product) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "insert into product(name, price, image, description, id_category) value (?,?,?,?,?);";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, product.getName());
			pre.setInt(2, product.getPrice());
			pre.setString(3, product.getImage());
			pre.setString(4, product.getDescription());
			pre.setInt(5, product.getCategory().getId());
			pre.executeUpdate();
		} catch (Exception e) {
			System.out.println("them loi!!"+e.getMessage());
		}
		
	}

	@Override
	public void update(Product product) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "update product set name=?, price=?, image=?, description=?, id_category=? where id=?;";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, product.getName());
			pre.setInt(2, product.getPrice());
			pre.setString(3, product.getImage());
			pre.setString(4, product.getDescription());
			pre.setInt(5, product.getCategory().getId());
			pre.setInt(6, product.getId());
			pre.executeUpdate();
		} catch (Exception e) {
			System.out.println("update loi!!");
		}
	}

	@Override
	public void delete(int id) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql = "delete from product where id=?;";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			pre.executeUpdate();
		} catch (Exception e) {
			System.out.println("xoa loi!!");
		}
		
	}

	@Override
	public List<Product> search(String findName) {
		List<Product> listProduct= new ArrayList<Product>();
		Connection con = JDBCConnection.getConn();
		try {
			String sql="select p.id, p.name, p.price, p.image,p.description,p.id_category ,c.name as 'categoryname' " + 
					"from product p " + 
					"inner join category c " + 
					"on c.id=p.id_category  where p.name like ? order by p.id";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, "%"+findName+"%");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Product product= new Product();
				product.setId(rs.getInt("p.id"));
				product.setName(rs.getString("p.name"));
				product.setPrice(rs.getInt("price"));
				product.setImage(rs.getString("p.image"));
				product.setDescription(rs.getString("p.description"));
				Category category= new Category();
				category.setId(rs.getInt("p.id_category"));
				category.setName(rs.getString("categoryname"));
				product.setCategory(category);
				listProduct.add(product);
			}

		} catch (Exception e) {
			System.out.println("search loi");
		}
		return listProduct;
	}

	@Override
	public Product get(int id) {
		Connection con = JDBCConnection.getConn();
		try {
			String sql="select p.id, p.name, p.price, p.image,p.description,p.id_category ,c.name as 'categoryname' " + 
					"from product p " + 
					"inner join category c " + 
					"on c.id=p.id_category where p.id =?";
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Product product= new Product();
				product.setId(rs.getInt("p.id"));
				product.setName(rs.getString("p.name"));
				product.setPrice(rs.getInt("p.price"));
				product.setImage(rs.getString("p.image"));
				product.setDescription(rs.getString("p.description"));
				Category category= new Category();
				category.setId(rs.getInt("p.id_category"));
				category.setName(rs.getString("categoryname"));
				product.setCategory(category);
				return product;
			}
		} catch (Exception e) {
			System.out.println("get loi!!");
		}
		return null;
	}
	}


