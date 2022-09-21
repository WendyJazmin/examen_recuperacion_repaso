package com.example.demo.service;

import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;

public interface IInventarioService {
	void crearInventario(Inventario inventario);
	void actualizaInventario(Inventario inventario);
	void borrarInventario(Integer id);
	Inventario buscarInventario(Integer id);
	Inventario buscarCodigoBarras(String codigoBarrasIndividual);
	void ingresarProductoInventario(String numeroBodega, String codigoBarrasMaestro, String codigoBarrasIndividual, Producto producto);
}
