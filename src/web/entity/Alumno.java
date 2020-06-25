package web.entity;

public class Alumno {

	private int idalumno;
	private int idescuela;
	private String correo;
	private String apellnombres;
	private int telefono;

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(int idalumno, int idescuela, String correo, String apellnombres, int telefono) {
		super();
		this.idalumno = idalumno;
		this.idescuela = idescuela;
		this.correo = correo;
		this.apellnombres = apellnombres;
		this.telefono = telefono;
	}



	public int getIdalumno() {
		return idalumno;
	}

	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}

	public int getIdescuela() {
		return idescuela;
	}

	public void setIdescuela(int idescuela) {
		this.idescuela = idescuela;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellnombres() {
		return apellnombres;
	}

	public void setApellnombres(String apellnombres) {
		this.apellnombres = apellnombres;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}