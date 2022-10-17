package programaLibreria.model;

public abstract class Empleado {

	// ------------- Son los atributos de Empleado-------------//

	private String nombre;
	private String direccion;
	private String cedula;
	private String correo;
	private double salario;
	private int anioExperiencia;

	// ------------- CONSTRUCTOR ---------- //

	public Empleado(String nombre, String direccion, String cedula, String correo, double salario,
			int anioExperiencia) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.cedula = cedula;
		this.correo = correo;
		this.salario = salario;
		this.anioExperiencia = anioExperiencia;
	}

	// ------------- get y set ---------- //

	public String getNombre() {
		return nombre;
	}

	public int getAnioExperiencia() {
		return anioExperiencia;
	}

	public void setAnioExperiencia(int anioExperiencia) {
		this.anioExperiencia = anioExperiencia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", direccion=" + direccion + ", cedula=" + cedula + ", correo=" + correo
				+ ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}


}
