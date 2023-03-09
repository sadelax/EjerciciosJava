package agenda.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import javax.sql.DataSource;

import agenda.config.Config;
import agenda.excepciones.PersistenciaExcepcion;
import agenda.modelo.Contacto;

public class ContactoDaoSQL implements ContactoDao {
	
	private DataSource ds;
	
	public ContactoDaoSQL() {
		ds = Config.getDataSource();
	}

	@Override
	public void insertar(Contacto c) {
		String sql = "INSERT INTO contactos VALUES (null,?,?,?,?,?,?,?,?,?,?,?)";	// DataSouce ya apunta a agenda, por eso no pongo 20_agenda.contactos
		try(Connection con = ds.getConnection()) {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getApellidos());
			ps.setString(3, c.getApodo());
			ps.setString(4, c.getDom().getTipoVia());
			ps.setString(5, c.getDom().getVia());
			ps.setInt(6, c.getDom().getNumero());
			ps.setInt(7, c.getDom().getPiso());
			ps.setString(8, c.getDom().getPuerta());
			ps.setString(9, c.getDom().getCodigoPostal());
			ps.setString(10, c.getDom().getCiudad());
			ps.setString(11, c.getDom().getProvincia());
			
			int filas = ps.executeUpdate();
			
			if (filas == 1) {
				PreparedStatement psId = con.prepareStatement("select LAST_INSERT_ID()");
				ResultSet rs = psId.executeQuery();
				rs.next(); // me posiciono en el primero
				int idGenerado = rs.getInt(1);
				
				sql = "INSERT INTO telefonos VALUES(null,?,?)";
				PreparedStatement psTel = con.prepareStatement(sql);
				
				int cantTel = 0;
				// iterar en toda la set de teléfonos
				for(String telefono : c.getTelefonos()) {
					psTel.setInt(1, idGenerado);
					psTel.setString(2, telefono);
					cantTel += psTel.executeUpdate();
				}
				
				sql = "INSERT INTO correos VALUES(null,?,?)";
				PreparedStatement psCorr = con.prepareStatement(sql);
				
				int cantCorr = 0;
				// iterar en toda la set de teléfonos
				for(String correo : c.getCorreos()) {
					psCorr.setInt(1, idGenerado);
					psCorr.setString(2, correo);
					cantCorr += psCorr.executeUpdate();
				}
				
				if(cantTel == c.getTelefonos().size() && cantCorr == c.getCorreos().size()) {
					con.commit();
				} else {
					con.rollback();
					throw new PersistenciaExcepcion();
				}
				
			} else {
				con.rollback();
				throw new PersistenciaExcepcion();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaExcepcion();
		}
	}

	@Override
	public boolean eliminar(int idContacto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacto buscar(int idContacto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Contacto contacto) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Set<Contacto> buscar(String nom) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Set<Contacto> buscarTodos() {
		Set<Contacto> todos = new TreeSet<>();
		String contactos = "SELECT * FROM contactos";
		try(Connection con = ds.getConnection()) {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(contactos);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			while(rs.next()) {
				rs.getString(1);
				rs.getString(2);
				rs.getString(3);
				rs.getString(4);
				rs.getString(5);
				rs.getString(6);
			}
			con.close();
			
		} catch(SQLException e) {
			
		}
		
		return null;
	}

	
}
