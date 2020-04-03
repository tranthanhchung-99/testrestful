package com.ttjv.dao;

import java.util.List;

import com.ttjv.model.BillProduct;

public interface BillProductDao {
	void insert(BillProduct billProduct);
	void update (BillProduct billProduct);
	void delete(int id );
	BillProduct get(int id );
	List<BillProduct> search(String findName);
}
