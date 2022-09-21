package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Producto;





public interface IProductoService {

	void insertarProducto(Producto producto); 
	void actualizarProducto(Producto producto);
	Producto buscarProducto(Integer id);
	void borrarProducto(Integer id);
	Producto buscarProductoCodigoBarras(String codigoBarras);
	List<Producto> listaProductos();
}
