package programaLibreria.model;

public class Autor {

	// ------------- Son los atributos de Autor-------------//
	private String nombre;
	private String apellido;
	private String identificacion;

	// ------------- CONSTRUCTOR ---------- //
	/**
	 * @param nombre
	 * @param apellido
	 * @param identificacion
	 */
	public Autor(String nombre, String apellido, String identificacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
	}

	// ------------- get y set ---------- //
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellido=" + apellido + ", identificacion=" + identificacion + "]";
	}

	/**
	 * 
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
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
		Autor other = (Autor) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}

}
