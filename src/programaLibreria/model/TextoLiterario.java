package programaLibreria.model;

public abstract class TextoLiterario {

	// ------------- Son los atributos de TextoLiterario-------------//
	private String titulo;
	private String editorial;
	private String codigo;
	private String estado;
	private int unidadesDisponibles;
	private double precio;
	private String idioma;
	private int numeroPaginas;
	private String fechaPublicacion;
	private int anio;
	
	private TipoFormato tipoFormato;
	
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
	 */
	public TextoLiterario(String titulo, String editorial, String codigo, String estado, int unidadesDisponibles,
			double precio, String idioma, int numeroPaginas, String fechaPublicacion, int anio,
			TipoFormato tipoFormato) {
		this.titulo = titulo;
		this.editorial = editorial;
		this.codigo = codigo;
		this.estado = estado;
		this.unidadesDisponibles = unidadesDisponibles;
		this.precio = precio;
		this.idioma = idioma;
		this.numeroPaginas = numeroPaginas;
		this.fechaPublicacion = fechaPublicacion;
		this.anio = anio;
		this.tipoFormato = tipoFormato;
	}
	
	// ------------- get y set ---------- //
	public String getTitulo() {
		return titulo;
	}

	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(int unidadesDisponibles) {
		this.unidadesDisponibles = unidadesDisponibles;
	}

	public TipoFormato getTipoFormato() {
		return tipoFormato;
	}

	public void setTipoFormato(TipoFormato tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */
	@Override
	public String toString() {
		return "TextoLiterario [titulo=" + titulo + ", editorial=" + editorial + ", estado=" + estado
				+ ", unidadesDisponibles=" + unidadesDisponibles + ", tipoFormato=" + tipoFormato + ", precio=" + precio
				+ ", idioma=" + idioma + ", numeroPaginas=" + numeroPaginas + ", fechaPublicacion=" + fechaPublicacion
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		TextoLiterario other = (TextoLiterario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
