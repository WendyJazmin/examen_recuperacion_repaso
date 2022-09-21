package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Producto;


public interface IProductoRepo {

	void insertarProducto(Producto producto); 
	void actualizarProducto(Producto producto);
	Producto buscarProducto(Integer id);
	void borrarProducto(Integer id);
	Producto buscarProductoCodigoBarras(String codigoBarras);
	List<Producto> listaProductos();
	
}
