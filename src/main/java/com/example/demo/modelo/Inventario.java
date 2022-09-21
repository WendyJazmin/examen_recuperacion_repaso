package com.example.demo.modelo;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ("seq_inventario"))
	@SequenceGenerator(name = "seq_inventario", sequenceName = "seq_inventario", allocationSize = 1)
	@Column(name = "inve_id")
	private Integer id;
	@Column(name = "inve_codigo_barras")
	private String codigoBarrasIndividual;
	@Column(name = "inve_nombre_hilo")
	private String nombreHilo;

	@ManyToOne
	@JoinColumn(name = "bode_id")
	private Bodega bodega;

	@OneToMany(mappedBy = "inventario", cascade = CascadeType.MERGE)
	private List<Producto> productos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarrasIndividual() {
		return codigoBarrasIndividual;
	}

	public void setCodigoBarrasIndividual(String codigoBarrasIndividual) {
		this.codigoBarrasIndividual = codigoBarrasIndividual;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

}
