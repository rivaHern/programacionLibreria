package programaLibreria.model;

import java.util.Arrays;

public class Compra {

	// ------------- Son los atributos de Compra-------------//
	private String codigo;
	private String fechaCompra;
	private double total;
	private double iva;
	private double medioPago;
	private double descuentos;

	private DetalleCompra [] listaDetalleCompras;
	
	// ------------- CONSTRUCTOR ---------- //
	/**
	 * @param codigo
	 * @param fechaCompra
	 * @param total
	 * @param iva
	 * @param medioPago
	 * @param descuentos
	 * @param listaDetalleCompras
	 */
	public Compra(String codigo, String fechaCompra, double total, double iva, double medioPago, double descuentos) {
		
		this.codigo = codigo;
		this.fechaCompra = fechaCompra;
		this.total = total;
		this.iva = iva;
		this.medioPago = medioPago;
		this.descuentos = descuentos;
		this.listaDetalleCompras = new DetalleCompra[10];
	}	
	
	//----------------get y set---------------//
	
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
	 * @return el fechaCompra
	 */
	public String getFechaCompra() {
		return fechaCompra;
	}
	/**
	 * @param fechaCompra el fechaCompra a establecer
	 */
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	/**
	 * @return el total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total el total a establecer
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	/**
	 * @return el iva
	 */
	public double getIva() {
		return iva;
	}
	/**
	 * @param iva el iva a establecer
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}
	/**
	 * @return el medioPago
	 */
	public double getMedioPago() {
		return medioPago;
	}
	/**
	 * @param medioPago el medioPago a establecer
	 */
	public void setMedioPago(double medioPago) {
		this.medioPago = medioPago;
	}
	/**
	 * @return el descuentos
	 */
	public double getDescuentos() {
		return descuentos;
	}
	/**
	 * @param descuentos el descuentos a establecer
	 */
	public void setDescuentos(double descuentos) {
		this.descuentos = descuentos;
	}
	/**
	 * @return el listaDetalleCompras
	 */
	public DetalleCompra[] getListaDetalleCompras() {
		return listaDetalleCompras;
	}
	/**
	 * @param listaDetalleCompras el listaDetalleCompras a establecer
	 */
	public void setListaDetalleCompras(DetalleCompra[] listaDetalleCompras) {
		this.listaDetalleCompras = listaDetalleCompras;
	}

	//----------------------------------------------------------------------------------//
	
	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", fechaCompra=" + fechaCompra + ", total=" + total + ", iva=" + iva
				+ ", medioPago=" + medioPago + ", descuentos=" + descuentos + ", listaDetalleCompras="
				+ Arrays.toString(listaDetalleCompras) + "]";
	}

	//----------------------------------------------------------------------------------//
	
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
		Compra other = (Compra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	//----------------------------------------------------------------------------------//
	
	
}