package com.trungtamjava.HelloSpringBoot.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtamjava.HelloSpringBoot.dao.SinhVienDao;
import com.trungtamjava.HelloSpringBoot.entity.SinhVien;
@Transactional
@Repository
public class SinhVienDaoImpl implements SinhVienDao{
	@PersistenceContext EntityManager entityManager;
	@Override
	public void add(SinhVien sinhVien) {
		entityManager.persist(sinhVien);
		
	}

	@Override
	public void update(SinhVien sinhVien) {
		entityManager.merge(sinhVien);
		
	}

	@Override
	public void delete(SinhVien sinhVien) {
		entityManager.remove(sinhVien);
		
	}

	@Override
	public SinhVien get(Long id) {
		return entityManager.find(SinhVien.class, id);
	}

	@Override
	public List<SinhVien> search(String name) {
		String jql="select sv from SinhVien sv where sv.name like :svname";
		return entityManager.createQuery(jql,SinhVien.class).setParameter("svname", "%"+name+"%").getResultList();
	}
}
