package com.tienda.online.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="detalle_compra")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer cantidad;
	
	private BigDecimal subtotal;
	
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name="compra_id")
	@JsonIgnore
	private Compra compraId;
	
	@ManyToOne
	@JoinColumn(name="ariculo_id")
	private Articulo articuloId;
	
	/**
	 * 
	 * @param id
	 * @param cantidad
	 * @param subtotal
	 * @param total
	 * @param compraId
	 * @param articuloId
	 */
	public DetalleCompra(Integer id, Integer cantidad, BigDecimal subtotal, BigDecimal total, Compra compraId,
			Articulo articuloId) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.total = total;
		this.compraId = compraId;
		this.articuloId = articuloId;
	}



	public DetalleCompra() {
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the subtotal
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the compraId
	 */
	public Compra getCompraId() {
		return compraId;
	}

	/**
	 * @param compraId the compraId to set
	 */
	public void setCompraId(Compra compraId) {
		this.compraId = compraId;
	}

	/**
	 * @return the articuloId
	 */
	public Articulo getArticuloId() {
		return articuloId;
	}

	/**
	 * @param articuloId the articuloId to set
	 */
	public void setArticuloId(Articulo articuloId) {
		this.articuloId = articuloId;
	}
	
	
}
