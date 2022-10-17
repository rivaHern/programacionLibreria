package programaLibreria.model;

public class Revista extends TextoLiterario {

	// ------------- Son los atributos de Revista-------------//
	private String isbn;
	private String categoria;

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
	 * @param isbn
	 * @param categoria
	 */
	public Revista(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			double precio, String idioma, int numeroPaginas, String fechaPublicacion, int anio, TipoFormato tipoFormato,
			String isbn, String categoria) {
		super(titulo, editorial, codigo, estado, unidadesDisponibles, precio, idioma, numeroPaginas, fechaPublicacion,
				anio, tipoFormato);
		this.isbn = isbn;
		this.categoria = categoria;
	}


	// ------------- get y set ---------- //
	public String getIsbn() {
		return isbn;
	}

	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */

	@Override
	public String toString() {
		return "Revista [isbn=" + isbn + ", categoria=" + categoria + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revista other = (Revista) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	
}
