package programaLibreria.model;

public class DetalleCompra {

	// ------------- Son los atributos de DetalleCompra-------------//

	private int cantidad;
	private double subTotal;
	private String codigo;

	private TextoLiterario textoLiterario;

	// ------------- CONSTRUCTOR ---------- //

	/**
	 * @param cantidad
	 * @param subTotal
	 * @param codigo
	 * @param textosLiterarios
	 * @param textosLiterario
	 */
	public DetalleCompra(int cantidad, double subTotal, String codigo, TextoLiterario textoLiterario) {
		
		this.cantidad = cantidad;
		this.subTotal = subTotal;
		this.codigo = codigo;
		this.textoLiterario = textoLiterario;
	}
	// ------------- get y set ---------- //
	
	/**
	 * @return el cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad el cantidad a establecer
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return el subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}


	/**
	 * @param subTotal el subTotal a establecer
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	/**
	 * @return el codigo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo el codigo a establecer
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return el textoLiterario
	 */
	public TextoLiterario getTextoLiterario() {
		return textoLiterario;
	}


	/**
	 * @param textoLiterario el textoLiterario a establecer
	 */
	public void setTextoLiterario(TextoLiterario textoLiterario) {
		this.textoLiterario = textoLiterario;
	}

	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */
	@Override
	public String toString() {
		return "DetalleCompra [cantidad=" + cantidad + ", subTotal=" + subTotal + ", codigo=" + codigo
				+ ", textoLiterario=" + textoLiterario + "]";
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
		DetalleCompra other = (DetalleCompra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}