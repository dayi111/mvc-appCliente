package com.trabajo.demo.models.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="factura_item")
public class ItemFactura  implements Serializable{

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	@NotNull
	@NotEmpty(message ="La cantidad no puede estar vacia" )
	@Column(nullable = true)
	private Integer cantidad;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="producto_id")
	private Producto producto;
	
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Integer getCantidad() {
		return cantidad;
	}




	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	private static final long serialVersionUID = 1L;
	
	

}
