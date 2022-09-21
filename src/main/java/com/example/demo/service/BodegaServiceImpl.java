package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.repository.IBodegaRepo;




@Service
public class BodegaServiceImpl implements IBodegaService{

	@Autowired
	private IBodegaRepo bodegaRepo;
	
	@Override
	public void insertarBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaRepo.insertarBodega(bodega);
	}

	@Override
	public void actualizarBodega(Bodega bodega) {
		// TODO Auto-generated method stub
		this.bodegaRepo.actualizarBodega(bodega);
	}

	@Override
	public Bodega buscarBodega(Integer id) {
		// TODO Auto-generated method stub
		return this.bodegaRepo.buscarBodega(id);
	}

	@Override
	public void borrarBodega(Integer id) {
		// TODO Auto-generated method stub
		this.bodegaRepo.borrarBodega(id);
	}

	@Override
	public void registrarBodegaVariosTelefonos(Bodega bodega) {
		// TODO Auto-generated method stub
		List<String> telefonos = new ArrayList<>();
		
		String[] split = bodega.getTelefono().split(";");
		
		System.out.println("AQUI TELEFONOS----"+split);
		
		for(int i = 0; i<split.length;i++) {
			System.out.println("Ingreso for: "+split[i]);
			telefonos.add(split[i]);
		
		}
		System.out.println("Salio for "+telefonos);
		
		bodega.setTelefonos(telefonos);
		this.bodegaRepo.insertarBodega(bodega);
		
		
	}

	@Override
	public Bodega buscarBodegaNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bodegaRepo.buscarBodegaNumero(numero);
	}

	@Override
	public List<Bodega> listaBodegas() {
		// TODO Auto-generated method stub
		return this.bodegaRepo.listaBodegas();
	}

	
}
