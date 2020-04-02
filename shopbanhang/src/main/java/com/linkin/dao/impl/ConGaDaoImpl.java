package com.linkin.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.linkin.dao.ConGaDao;
import com.linkin.entity.ConGa;
@Transactional
@Repository
public class ConGaDaoImpl implements ConGaDao {
	@PersistenceContext
	EntityManager entityManager ;
	
	
	@Override
	public void add(ConGa conGa) {
		entityManager.persist(conGa);
		
	}

	@Override
	public void update(ConGa conGa) {
		entityManager.merge(conGa);
		
	}

	@Override
	public void delete(ConGa conGa) {
		entityManager.remove(conGa);
		
	}

	@Override
	public ConGa get(Long id) {
		return entityManager.find(ConGa.class, id);
	}

	@Override
	public List<ConGa> search(String name) {
		String jql ="select c from ConGa c where c.name like :cname";
		return entityManager.createQuery(jql, ConGa.class).setParameter("cname","%"+name+"%" ).getResultList();
	}

}
