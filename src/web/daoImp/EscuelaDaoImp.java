package web.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.dao.EscuelaDao;
import web.entity.Escuela;
import web.util.Conexion;

public class EscuelaDaoImp implements EscuelaDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;

	public int create(Escuela u) {
		int x = 0;
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement("INSERT INTO escuela(nombrecat) values(?)");
			ps.setString(1, u.getNombrecat());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public int update(Escuela u) {
		int x = 0;

		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement("UPDATE escuela SET nombrecat=? WHERE idescuela=?");
			ps.setString(1, u.getNombrecat());
			ps.setInt(2, u.getIdescuela());
			x = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public int delete(int id) {
		int x = 0;
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement("DELETE FROM escuela WHERE idescuela=?");
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return x;
	}

	public Escuela read(int id) {
		Escuela ca = new Escuela();
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement("Select * from escuela where idescuela=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ca.setIdescuela(rs.getInt("idescuela"));
				ca.setNombrecat(rs.getString("nombrecat"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return ca;
	}

	public List<Escuela> readAll() {
		// TODO Auto-generated method stub
		List<Escuela> list = new ArrayList<>();
		String sql = "select * from escuela";
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Escuela a = new Escuela();
				a.setIdescuela(rs.getInt("idescuela"));
				a.setNombrecat(rs.getString("nombrecat"));
				list.add(a);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}