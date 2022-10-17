package programaLibreria.model;

public class Periodico extends TextoLiterario {

	// ------------- Son los atributos de Periodico-------------//
	private String ciudad;

	// ------------- CONSTRUCTOR ---------- //

	/**
	 * @param titulo
	 * @param editorial
	 * @param codigo
	 * @param estado
	 * @param unidadesDisponibles
	 * @param precio
	 * @param idioma
	 * @param numeroPaginas
	 * @param fechaPublicacion
	 * @param anio
	 * @param tipoFormato
	 * @param ciudad
	 */
	public Periodico(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			double precio, String idioma, int numeroPaginas, String fechaPublicacion, int anio, TipoFormato tipoFormato,
			String ciudad) {
		super(titulo, editorial, codigo, estado, unidadesDisponibles, precio, idioma, numeroPaginas, fechaPublicacion,
				anio, tipoFormato);
		this.ciudad = ciudad;
	}

	// ------------- get y set ---------- //

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */
	@Override
	public String toString() {
		return "Periodico [ciudad=" + ciudad + "]";
	}
}
