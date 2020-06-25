package web.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import web.dao.AlumnoDao;
import web.entity.Alumno;
import web.util.Conexion;

public class AlumnoDaoImp implements AlumnoDao{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx = null;

	public int create(Alumno u) {
		int x = 0;
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement("INSERT INTO alumno(idalumno, idescuela, apellnombres , correo , telefono ) values(null ,?,?,?,?)");
			ps.setInt(1, u.getIdescuela());
			ps.setString(2, u.getApellnombres());
			ps.setString(3, u.getCorreo());
			ps.setInt(4, u.getTelefono());
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return x;
	}

	public int update(Alumno u) {
		int x = 0;
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement("UPDATE alumno SET idescuela = ?, apellnombres = ?, correo = ?, telefono = ? WHERE idalumno = ?");
			ps.setInt(1, u.getIdescuela());
			ps.setString(2, u.getApellnombres());
			ps.setString(3, u.getCorreo());
			ps.setInt(4, u.getTelefono());
			ps.setInt(5, u.getIdalumno());
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
			ps = cx.prepareStatement("DELETE FROM alumno WHERE idalumno=?");
			ps.setInt(1, id);
			x = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return x;
	}

	public List<Map<String,Object>> read(int id) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select c.idescuela, c.nombrecat, "+
		             "p.idalumno, p.apellnombres, "+ 
				     "p.correo, p.telefono from alumno as p,"+
		             " escuela as c where c.idescuela= p.idescuela and p.idalumno=?";
		try {
			cx = Conexion.getConex();
			ps = cx.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("correo", rs.getString("correo"));
                map.put("telefono", rs.getInt("telefono"));
                map.put("nombrecat", rs.getString("nombrecat"));
                map.put("idalumno", rs.getInt("idalumno"));
                map.put("apellnombres", rs.getString("apellnombres"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Map<String,Object>> readAll() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		String sql = "select c.idescuela, c.nombrecat,"+ 
				"p.idalumno, p.apellnombres,"+ 
				"p.correo, p.telefono from alumno as p," + 
			     " escuela as c where c.idescuela= p.idescuela";
		try {
			
			cx = Conexion.getConex();
			ps = cx.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>();
                map.put("idescuela", rs.getInt("idescuela"));
                map.put("correo", rs.getString("correo"));
                map.put("telefono", rs.getInt("telefono"));
                map.put("nombrecat", rs.getString("nombrecat"));
                map.put("idalumno", rs.getInt("idalumno"));
                map.put("apellnombres", rs.getString("apellnombres"));
			    list.add(map);
			    
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}