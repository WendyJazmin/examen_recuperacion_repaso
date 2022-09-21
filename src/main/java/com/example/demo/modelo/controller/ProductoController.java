package com.example.demo.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Producto;
import com.example.demo.service.IBodegaService;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos/")

public class ProductoController {

	@Autowired
	private IBodegaService bodegaService;
	@Autowired
	private IProductoService productoService;
	
	
	//busca todos los productos
	@GetMapping("listaProductos")
	public String buscarTodos(Producto producto, Model modelo) {
		List<Producto> productosDisponibles = this.productoService.listaProductos();
		modelo.addAttribute("productosDisponibles", productosDisponibles);
		return "vistaListaProductos";
	}
	
	
	//insertar productos
	@GetMapping("insertarDatosProducto")//VISTA PARA INSERTAR LOS DATOS DEL PRODUCTO, PONER EN GOOGLE
	public String insertarDatosProducto(Producto producto) {
		return "vistaInsertarDatosProducto";
	}
	
	@PostMapping("insertarProducto")//ESTA DIRECCION NO PONER EN GOOGLE
	public String insertarProducto(Producto producto, Model model) {
		producto.setStock(0);
		this.productoService.insertarProducto(producto);
		return "redirect:/productos/listaProductos";
	}

	//
	
	
	@DeleteMapping("Eliminar/{idProducto}")
	public String eliminarProducto(@PathVariable("idProducto") Integer idProducto, Model modelo) {
		
		System.out.println("id: "+idProducto);
		
		this.productoService.borrarProducto(idProducto);	
		return "redirect:/productos/resultado";
	}
	

	
	
	

}
