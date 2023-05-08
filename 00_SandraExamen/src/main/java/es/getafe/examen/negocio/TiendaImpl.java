package es.getafe.examen.negocio;

import java.util.Set;
import java.util.TreeSet;

import es.getafe.examen.modelo.Fabricante;
import es.getafe.examen.modelo.Producto;
import es.getafe.examen.persistencia.FabricanteDao;
import es.getafe.examen.persistencia.FabricanteDaoImpl;
import es.getafe.examen.persistencia.ProductoDao;
import es.getafe.examen.persistencia.ProductoDaoImpl;

public class TiendaImpl implements Tienda {
	
	ProductoDao pd = new ProductoDaoImpl();
	FabricanteDao fd = new FabricanteDaoImpl();
	
	@Override
	public Set<Producto> getProductos() {
		Set<Producto> productos = new TreeSet<>(pd.findAll());
//		Set<Producto> ordena = new TreeSet<>(new Comparator<Producto>() {
//
//			@Override
//			public int compare(Producto o1, Producto o2) {
//				return (o1.getProducto() + o1.getIdProducto()).compareToIgnoreCase(o2.getProducto() + o2.getIdProducto());
//			}
//		});
		return productos;
	}

	@Override
	public Set<Producto> getProductos(String descripcion) {
		return new TreeSet<>(pd.findByDescripcion(descripcion));
	}

	@Override
	public double getMediaPrecioProductosByFabricante(int idFabricante) {
//		TODO
		return 0;
	}

	@Override
	public void addFabricante(Fabricante fabricante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Fabricante> getFabricantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Fabricante> getFabricantesActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fabricante getFabricante(int idFabricante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fabricante getFabricanteConProductos(int idFabricante) {
		// TODO Auto-generated method stub
		return null;
	}

}
