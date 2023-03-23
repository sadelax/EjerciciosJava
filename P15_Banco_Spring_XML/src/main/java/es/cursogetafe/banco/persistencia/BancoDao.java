package es.cursogetafe.banco.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class BancoDao implements BancoDaoInterface {
	private DataSource dataSource;

	public BancoDao() {
		this.dataSource = MyDataSource.getDataSource();
	}

	public void cambiarSaldo(long dni, double incrementoSaldo) {
		String sql = "update clientes set saldo = saldo + ? where dni = ?";
		try (Connection con = dataSource.getConnection()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, incrementoSaldo);
			ps.setLong(2, dni);
			int n = ps.executeUpdate();
			if (n == 1) {
				System.out.println("Se ha incrementado el saldo de " + dni
						+ " en " + incrementoSaldo + " euros");
			} else {
				System.out.println("No existe el cliente con el " + dni);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}