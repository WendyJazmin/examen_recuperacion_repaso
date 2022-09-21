package com.example.demo.modelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Bodega;
import com.example.demo.service.IBodegaService;
import com.example.demo.service.IGestorBodegaService;



@Controller
@RequestMapping("/bodegas/")
public class BodegaController {

	@Autowired
	private IBodegaService bodegaService;
	@Autowired
	private IGestorBodegaService gestorBodegaService;
	
	
	@GetMapping("bodegaNueva")
	public String vistaObtenerDatos(Bodega bodega) {
		return "obtenerDatos";
	}
	
	@PostMapping("insertarBodega")
	public String insertarBodega(Bodega bodega, BindingResult result, Model model) {
		this.bodegaService.insertarBodega(bodega);
		return "redirect:/bodegas/bodegaNueva?exito";
	}
	
//	@GetMapping("inventarioNuevo")
//	public String vistaObtenerDatosInventario(Inventario inventario) {
//		return "obtenerDatos";
//	}
//	
//	@PostMapping("insertarBodega")
//	public String insertarInventario(Inventario inventario, BindingResult result, Model model) {
//
//		return "inventarioRegistradaNotify";
//	}
	
}
