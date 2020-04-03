package com.trungtamjava.HelloSpringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.HelloSpringBoot.entity.SinhVien;

public interface SinhVienDao {
	void add(SinhVien sinhVien);
	void update(SinhVien sinhVien);
	void delete(SinhVien sinhVien);
	SinhVien get (Long id);
	List<SinhVien> search(String name);
}
