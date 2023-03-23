package es.cursogetafe.springcore.tests;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("serial")
public class Test05 implements Serializable {

	DataSource ds;
	
	public Test05() {}
	
	public void consulta() {
		try(Connection con = ds.getConnection()){
			String sql = "SELECT apodo FROM contactos";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("A05appCtx.xml");
	}
}
