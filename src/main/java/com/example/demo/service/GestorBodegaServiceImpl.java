package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;



@Service
public class GestorBodegaServiceImpl implements IGestorBodegaService{

	@Autowired
	private IInventarioService inventarioService;
	@Autowired
	private IBodegaService bodegaService;
	@Autowired
	private IProductoService productoService;
	
	@Override
	public void insertarInventario(String numeroBodega, String CodigoBarrasMaestro, Integer cantidad) {

		
		Producto prod =this.productoService.buscarProductoCodigoBarras(CodigoBarrasMaestro);
		prod.setStock(prod.getStock()+cantidad);
		System.out.println("prod"+prod.getNombre());
		
		this.productoService.actualizarProducto(prod);
		for(int i=0;i<cantidad;i++) {
		this.inventarioService.ingresarProductoInventario(numeroBodega, CodigoBarrasMaestro, CodigoBarrasMaestro.concat(String.valueOf(i)), prod);
			
		}
		
		
	}

	
	
	
	
}
