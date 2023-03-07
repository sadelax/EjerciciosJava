package bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class PruebaConexion {

	public static void main(String[] args) throws SQLException {
		DataSource ds;
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");	// este es el driver de mysql
		bds.setUrl("jdbc:mysql://localhost/50_examen_banco");
		bds.setUsername("root");
		bds.setPassword("root");
		ds = bds;						// me interesa trabajar con datasource en verdad, bds solo para poder acceder a sus métodos
		
		Connection con = ds.getConnection();
		String sql = "SELECT * FROM tarjetas WHERE fk_cuenta = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 10);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("id_tarjeta"));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString("marca"));
		}
		con.close();
	}
}
