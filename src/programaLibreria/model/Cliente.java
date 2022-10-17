package programaLibreria.model;

import java.util.Arrays;

public class Cliente {

	// ------------- Son los atributos de Cliente-------------//

	private String nombre;
	private String telefono;
	private String cedula;
	private String correo;

	private Compra[] listaCompras;
	// ------------- CONSTRUCTOR ---------- //
	/**
	 * @param nombre
	 * @param telefono
	 * @param cedula
	 * @param correo
	 * @param listaCompras
	 */
	public Cliente(String nombre, String telefono, String cedula, String correo, int cantidadCompras) {
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.cedula = cedula;
		this.correo = correo;
		this.listaCompras = new Compra[cantidadCompras];
	}// ------------- get y set ---------- //
	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return el telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono el telefono a establecer
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return el cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * @param cedula el cedula a establecer
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return el correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo el correo a establecer
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return el listaCompras
	 */
	public Compra[] getListaCompras() {
		return listaCompras;
	}
	/**
	 * @param listaCompras el listaCompras a establecer
	 */
	public void setListaCompras(Compra[] listaCompras) {
		this.listaCompras = listaCompras;
	}
	// -----------------------------------------------------------------------------//
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", telefono=" + telefono + ", cedula=" + cedula + ", correo=" + correo
				+ ", listaCompras=" + Arrays.toString(listaCompras) + "]";
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
		Cliente other = (Cliente) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}

	// -----------------------------------------------------------------------------//
	
	
}