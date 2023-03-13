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
		Contacto encontrado = new Contacto();
		
		return encontrado;
	}

	@Override
	public void actualizar(Contacto contacto) {
		String sqlCon = "UPDATE contactos "
				+ "SET "
				+ "nombre = ?,"
				+ "apellido = ?,"
				+ "apodo = ?,"
				+ "tipo_via = ?,"
				+ "via = ?,"
				+ "numero = ?,"
				+ "piso = ?,"
				+ "puerta = ?,"
				+ "codigo_postal = ?,"
				+ "ciudad = ?,"
				+ "provincia = ?,"
				+ "WHERE (`id_contacto` = ?)";
		String sqlTel = "DELETE FROM telefonos WHERE fk_contacto = ?";
		String sqlCorr = "DELETE FROM correos WHERE fk_contacto = ?";
		
		try(Connection con = ds.getConnection()) {
			
			con.setAutoCommit(false);
			PreparedStatement psCon = con.prepareStatement(sqlCon);
			
			psCon.setString(1, contacto.getNombre());
			psCon.setString(2, contacto.getApellidos());
			psCon.setString(3, contacto.getApodo());
			psCon.setString(4, contacto.getDom().getTipoVia());
			psCon.setString(5, contacto.getDom().getVia());
			psCon.setInt(6, contacto.getDom().getNumero());
			psCon.setInt(7, contacto.getDom().getPiso());
			psCon.setString(8, contacto.getDom().getPuerta());
			psCon.setString(9, contacto.getDom().getCodigoPostal());
			psCon.setString(10, contacto.getDom().getCiudad());
			psCon.setString(11, contacto.getDom().getProvincia());
			psCon.setInt(12, contacto.getIdContacto());
			
			int filas =  psCon.executeUpdate();

			if(filas == 1) {
				
				sqlTel = "INSERT INTO telefonos VALUES(null,?,?)";
				PreparedStatement psTel = con.prepareStatement(sqlTel);
				
				for(String telefono : contacto.getTelefonos()) {
					psTel.setInt(1, contacto.getIdContacto());
					psTel.setString(2, telefono);
				}
				
				sqlCorr = "INSERT INTO correos VALUES(null,?,?)";
				PreparedStatement psCorr = con.prepareStatement(sqlCorr);
				
				for(String correo : contacto.getCorreos()) {
					psCorr.setInt(1, contacto.getIdContacto());
					psCorr.setString(2, correo);
				}

				con.commit();
				
			} else {
				con.rollback();
			}
			
			System.out.println("actualizado correctamente");
		
		} catch (SQLException e) {
			System.err.println("error");
			e.printStackTrace();
			throw new PersistenciaExcepcion();
		}	
	}

	@Override
	public Set<Contacto> buscar(String nom) {
		Set<Contacto> contactos = new TreeSet<>();
		String sqlCon = "SELECT * FROM contactos WHERE nombre like ? OR apellido like ? OR apodo LIKE ?";
		String sqlTel = "SELECT * FROM telefonos WHERE fk_contacto = ?";
		String sqlCorr = "SELECT * FROM correos WHERE fk_contacto = ?";
		 
		try(Connection con = ds.getConnection()){
			
			PreparedStatement ps = con.prepareStatement(sqlCon);
			String param = "%" + nom + "%";
			ps.setString(1, param);
			ps.setString(2, param);
			ps.setString(3, param);
			ResultSet rs = ps.executeQuery();
			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaExcepcion();
		}
		
		return contactos;
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
