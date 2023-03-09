package agenda.persistencia;

import java.io.IOException;
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
		int eliminado = 0;
		String sql = "DELETE FROM contactos WHERE id_contacto = ?";
		try(Connection con = ds.getConnection()) {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idContacto);
			eliminado = ps.executeUpdate();
			
			if(eliminado == 1) {
				con.commit();				
			} else {
				con.rollback();
			}
			
			System.out.println("eliminado correctamente");
			
		} catch (SQLException e) {
			System.err.println("error al eliminar");
			throw new PersistenciaExcepcion();
		}
		return eliminado == 1;
	}

	@Override
	public Contacto buscar(int idContacto) {
		String sql = "SELECT id_contacto FROM contactos where id_contacto = ?";
		try(Connection con = ds.getConnection()){
			
		} catch (SQLException e) {
			System.err.println("error al buscar");
			throw new PersistenciaExcepcion();
		}
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
		Set<Contacto> contactos = new TreeSet<>();
		String sqlCon = "SELECT * FROM contactos";
		String sqlTel = "SELECT * FROM telefonos WHERE fk_contacto = ?";
		String sqlCorr = "SELECT * FROM correos WHERE fk_contacto = ?";
		
		try(Connection con = ds.getConnection()) {
			
			PreparedStatement psCon = con.prepareStatement(sqlCon);
			ResultSet rs = psCon.executeQuery();
			
			while(rs.next()) {
				Contacto c = new Contacto();
				
				c.setIdContacto(rs.getInt("id_contacto"));
				c.setNombre(rs.getString("nombre"));
				c.setApellidos(rs.getString("apellido"));
				c.setApodo(rs.getString("apodo"));
				c.getDom().setTipoVia(rs.getString("tipo_via"));				
				c.getDom().setVia(rs.getString("via"));				
				c.getDom().setNumero(rs.getInt("numero"));				
				c.getDom().setPiso(rs.getInt("piso"));				
				c.getDom().setPuerta(rs.getString("puerta"));				
				c.getDom().setCodigoPostal(rs.getString("codigo_postal"));				
				c.getDom().setCiudad(rs.getString("ciudad"));				
				c.getDom().setProvincia(rs.getString("provincia"));
				
				PreparedStatement psTel = con.prepareStatement(sqlTel);
				psTel.setInt(1, c.getIdContacto());
				ResultSet rsTel = psTel.executeQuery();

				while(rsTel.next()) {
					c.addTelefono(rsTel.getString("telefono"));
				}
				
				PreparedStatement psCorr = con.prepareStatement(sqlCorr);
				psCorr.setInt(1, c.getIdContacto());
				ResultSet rsCorr = psCorr.executeQuery();
				
				while(rsCorr.next()) {
					c.addCorreo(rsCorr.getString("correo"));
				}

				contactos.add(c);
			}
			
		} catch(SQLException e) {
			System.err.println("error en la consulta");
			throw new PersistenciaExcepcion();
		}
		
		return contactos;
	}

	
}
