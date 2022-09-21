package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.repository.IInventarioRepo;





@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InventarioServiceImpl implements IInventarioService{

	@Autowired
	private IInventarioRepo inventarioRepo;
	@Autowired
	private IBodegaService bodegaService;
	@Autowired
	private IProductoService productoService;
	

	@Override
	public void crearInventario(Inventario inventario) {
		// TODO Auto-generated method stub
		this.inventarioRepo.crearInventario(inventario);
	}

	@Override
	public void actualizaInventario(Inventario inventario) {
		// TODO Auto-generated method stub
		this.inventarioRepo.actualizaInventario(inventario);
	}

	@Override
	public void borrarInventario(Integer id) {
		// TODO Auto-generated method stub
		this.inventarioRepo.borrarInventario(id);
	}

	@Override
	public Inventario buscarInventario(Integer id) {
		// TODO Auto-generated method stub
		return this.inventarioRepo.buscarInventario(id);
	}

	@Override
	public Inventario buscarCodigoBarras(String codigoBarrasIndividual) {
		// TODO Auto-generated method stub
		return this.inventarioRepo.buscarCodigoBarras(codigoBarrasIndividual);
	}

	@Override
	@Async
	public void ingresarProductoInventario(String numeroBodega, String codigoBarrasMaestro,
			String codigoBarrasIndividual, Producto producto) {
		// TODO Auto-generated method stub
		Bodega bodega = this.bodegaService.buscarBodegaNumero(numeroBodega);
		System.out.println("prodyucto inventario : "+ producto.getCodigoBarras());
		Inventario inventario = new Inventario();
		this.productoService.actualizarProducto(producto);
		List<Producto> listaprod = new ArrayList<>(); 
		listaprod.add(producto);
		inventario.setBodega(bodega);
		inventario.setCodigoBarrasIndividual(codigoBarrasIndividual);
		inventario.setNombreHilo(Thread.currentThread().getName());
		inventario.setProductos(listaprod);
		listaprod.forEach(System.out::println);
		producto.setInventario(inventario);
		System.out.println("inventario : "+inventario.getProductos());
		
		this.crearInventario(inventario);
	}
	
	
}
