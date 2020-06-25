package web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.dao.AlumnoDao;
import web.dao.EscuelaDao;
import web.daoImp.AlumnoDaoImp;
import web.daoImp.EscuelaDaoImp;
import web.entity.Alumno;

/**
 * Servlet implementation class PruebaController
 */
@WebServlet("/PruebaController")
public class PruebaController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private AlumnoDao al_dao = new AlumnoDaoImp();
	private EscuelaDao ec_dao = new EscuelaDaoImp();
	private Gson g = new Gson();
	int idAl, idEs, telefono;
	String correo, apellnombres;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PruebaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1: // lista categoria//
			out.println(g.toJson(ec_dao.readAll()));
			break;
		case 2:// Listar productos
			out.println(g.toJson(al_dao.readAll()));
			break;
		
		case 3: // registrar producto
			al_dao.create(new Alumno(0, Integer.parseInt(request.getParameter("idescuela")), request.getParameter("correo"),
							request.getParameter("apellnombres"), Integer.parseInt(request.getParameter("telefono"))));
			out.println(g.toJson("Registro guardado correctamente"));
			break;
		case 4: // Buscar produto por ID
			out.println(g.toJson(al_dao.read(Integer.parseInt(request.getParameter("id")))));

			break;
		case 5:// Eliminar producto
			int x = al_dao.delete(Integer.parseInt(request.getParameter("id")));
			out.println(g.toJson(x));
			break;
		case 6: // Modificar producto
			idEs = Integer.parseInt(request.getParameter("idEs"));
			idAl = Integer.parseInt(request.getParameter("idAl"));
			correo = request.getParameter("correo");
			apellnombres = request.getParameter("apellnombres");
			telefono = Integer.parseInt(request.getParameter("telefono"));
			out.println(g.toJson(al_dao.update(new Alumno( idAl,idEs, correo, apellnombres, telefono))));
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
