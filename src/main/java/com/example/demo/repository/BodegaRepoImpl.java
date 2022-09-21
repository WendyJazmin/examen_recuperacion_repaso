package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bodega;

@Repository
@Transactional
public class BodegaRepoImpl implements IBodegaRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bodega);
	}

	@Override
	public void actualizarBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bodega);
	}

	@Override
	public Bodega buscarBodega(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Bodega.class, id);
	}

	@Override
	public void borrarBodega(Integer id) {
		// TODO Auto-generated method stub
		Bodega b = this.buscarBodega(id);
		this.entityManager.remove(b);
	}

	@Override
	public Bodega buscarBodegaNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Bodega> miTypedQuery = this.entityManager.createQuery("select b from Bodega b where b.numeroBodega=:numeroBodega",Bodega.class);
		miTypedQuery.setParameter("numeroBodega", numero);
		return miTypedQuery.getSingleResult();
	}

	@Override
	public List<Bodega> listaBodegas() {
		// TODO Auto-generated method stub
		TypedQuery<Bodega> miTypedQuery = this.entityManager.createQuery("select b from Bodega b", Bodega.class);
		return miTypedQuery.getResultList();
	}
	
	
	
}
