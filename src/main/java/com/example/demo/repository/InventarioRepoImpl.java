package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Inventario;


@Repository
@Transactional
public class InventarioRepoImpl implements IInventarioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crearInventario(Inventario inventario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(inventario);
	}

	@Override
	public void actualizaInventario(Inventario inventario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(inventario);
	}

	@Override
	public void borrarInventario(Integer id) {
		// TODO Auto-generated method stub
		
		Inventario inv = this.entityManager.find(Inventario.class, id);
		
		this.entityManager.remove(inv);
	}

	@Override
	public Inventario buscarInventario(Integer id) {
		// TODO Auto-generated method stub
	
		return 	this.entityManager.find(Inventario.class, id);
	}

	@Override
	public Inventario buscarCodigoBarras(String codigoBarrasIndividual) {
		// TODO Auto-generated method stub
		TypedQuery<Inventario> miTypedQuery = this.entityManager.createQuery("select v from Inventario v where v.codigoBarrasIndividual=:codigoBarrasIndividual", Inventario.class);
		miTypedQuery.setParameter("codigoBarrasIndividual", codigoBarrasIndividual);
		return miTypedQuery.getSingleResult();
	}
	


}
