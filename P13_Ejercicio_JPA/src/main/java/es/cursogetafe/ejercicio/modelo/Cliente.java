package es.cursogetafe.ejercicio.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@SuppressWarnings("serial")
public class Cliente extends Rol implements Serializable{

	private int nroCliente;
	private String categoria;
	
	@ManyToMany
	@JoinTable(name = "clientes_productos",
				joinColumns = @JoinColumn(name = "idrol"),
				inverseJoinColumns = @JoinColumn(name = "idProducto"))
	private List<Producto> productos;
	
	public Cliente(){
		setRol("CLIENTE");
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
