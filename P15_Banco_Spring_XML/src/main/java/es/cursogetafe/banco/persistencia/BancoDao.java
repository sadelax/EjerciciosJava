package es.cursogetafe.banco.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class BancoDao implements BancoDaoInterface {
	private DataSource dataSource;

	public BancoDao() {
		this.dataSource = MyDataSource.getDataSource();
	}

	public void cambiarSaldo(long dni, double incrementoSaldo) {
		String sql = "update clientes set saldo = saldo + " + incrementoSaldo
				+ " where dni = " + dni;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			int n = con.createStatement().executeUpdate(sql);
			if (n == 1) {
				System.out.println("Se ha incrementado el saldo de " + dni
						+ " en " + incrementoSaldo + " euros");
			} else {
				System.out.println("No existe el cliente con el " + dni);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
			}
		}

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}