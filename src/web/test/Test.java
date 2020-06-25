package web.test;

import com.google.gson.Gson;

import web.dao.AlumnoDao;
import web.dao.EscuelaDao;
import web.daoImp.AlumnoDaoImp;
import web.daoImp.EscuelaDaoImp;
import web.entity.Escuela;
import web.util.Conexion;





public class Test {
private static AlumnoDao pd = new AlumnoDaoImp();
private static EscuelaDao escuelaDao = new EscuelaDaoImp();
private static Gson g = new Gson();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   listarP();
		//crearCat();
	//conectar();
	}
	static void conectar() {
		if (Conexion.getConex()!=null) {
			System.out.println("conectado");
		}
	}
  static void listarP() {
	  System.out.println(g.toJson(pd.readAll()));
  }
  static void crearCat() {
	  System.out.println(escuelaDao.create(new Escuela(0,"Pastas")));
  }
}
