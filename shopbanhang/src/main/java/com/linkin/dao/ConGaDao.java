package com.linkin.dao;

import java.util.List;

import com.linkin.entity.ConGa;
public interface ConGaDao {
	void add (ConGa  conGa);
	void update(ConGa conGa);
	void delete(ConGa conGa);
	ConGa get(Long id );
	List<ConGa> search(String name);
}
