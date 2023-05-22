package es.getafe.examen.negocio;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
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
		Set<Producto> ordenados = new TreeSet<>(new Comparator<Producto>() {

			@Override
			public int compare(Producto p1, Producto p2) {
				Collator col = Collator.getInstance(new Locale("es"));
				String s1 = p1.getProducto() + p1.getIdProducto();
				String s2 = p2.getProducto() + p2.getIdProducto();
				return  col.compare(s1, s2);
				}
		});
		ordenados.addAll(pd.findAll());
		return ordenados;
	}

	@Override
	public Set<Producto> getProductos(String descripcion) {
//		Set<Producto> res = new TreeSet<Producto>(pd.findByDescripcion(descripcion));
//		return res.isEmpty() ? res : null;
		Set<Producto> res = new TreeSet<Producto>(pd.findByDescripcion(descripcion));
		if(res.isEmpty()) {
			return null;
		} else {
			return res;
		}
	}

	@Override
	public double getMediaPrecioProductosByFabricante(int idFabricante) {
		Fabricante f = fd.findById(idFabricante);
		double media = 0;
		if (f != null) {
			for (Producto p : f.getProductos()) {
				media += p.getPrecio();
			}
			if (f.getProductos().size() > 0) {
				media /= f.getProductos().size();
			}
		}
		return media;
	}

	@Override
	public void addFabricante(Fabricante fabricante) {
		fd.save(fabricante);

	}

	@Override
	public void addProducto(Producto producto) {
		pd.save(producto);

	}

	@Override
	public Set<Fabricante> getFabricantes() {
		Set<Fabricante> res = new TreeSet<>(compFabNombre());
		res.addAll(fd.findAll());
		return res;
	}

	@Override
	public Set<Fabricante> getFabricantesActivos() {
		Set<Fabricante> res = new TreeSet<>(compFabNombre());
		res.addAll(fd.findOnlyActive());
		return res;
	}

	@Override
	public Fabricante getFabricante(int idFabricante) {
		return fd.findByIdLazy(idFabricante);
	}

	@Override
	public Fabricante getFabricanteConProductos(int idFabricante) {
		return fd.findById(idFabricante);
	}

	public Comparator<Fabricante> compFabNombre() {
		return new Comparator<Fabricante>() {

			@Override
			public int compare(Fabricante f1, Fabricante f2) {
				Collator col = Collator.getInstance(new Locale("es"));
				String s1 = f1.getFabricante() + f1.getIdFabricante();
				String s2 = f2.getFabricante() + f2.getIdFabricante();
				return col.compare(s1, s2);
			}

		};
	}
}
