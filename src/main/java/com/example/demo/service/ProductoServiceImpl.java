package com.example.demo.service;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepo productoRepo;
	
	@Override
	public void insertarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertarProducto(producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.actualizarProducto(producto);
	}

	@Override
	public Producto buscarProducto(Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProducto(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void borrarProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto p = this.buscarProducto(id);
		Integer stock = p.getStock();
		Integer in = stock.intValue();
		if(in <= 100) {
			this.productoRepo.borrarProducto(id);
		} else {
			throw new RuntimeException("Stock mayor a 100");
		}
		
	}

	@Override
	public Producto buscarProductoCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarProductoCodigoBarras(codigoBarras);
	}

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		return this.productoRepo.listaProductos();
	}

	
	
}
