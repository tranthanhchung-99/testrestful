package com.ttjv.dao;

import java.util.List;

import com.ttjv.model.Category;

public interface CategoryDao {
	void insert(Category category);

	void update(Category category);

	void delete(int id);

	Category get(int id);

	List<Category> search(String findName);
	
	List<Category> search(String findName, int offset, int maxPerPage);
	
	int count (String findName);
}
