package programaLibreria.model;

public class Administrador extends Empleado {

	private String profesion;

	// ------------- CONSTRUCTOR ---------- //

	public Administrador(String nombre, String direccion, String cedula, String correo, double salario,
			String profesion,int anioExperiencia) {
		super(nombre, correo, cedula, direccion, salario,anioExperiencia);
		this.profesion = profesion;
	}

	// ------------- get y set ---------- //
	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */
	@Override
	public String toString() {
		return "Administrador [profesion=" + profesion + "]";
	}

}
