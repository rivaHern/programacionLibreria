package programaLibreria.model;

import java.util.Arrays;

public class Vendedor extends Empleado {

	// ------------- Son los atributos de Vendedor-------------//

	private int numeroVentas;
	private Compra[] listaCompras;
	
	// ------------- CONSTRUCTOR ---------- //
	/**
	 * @param nombre
	 * @param direccion
	 * @param cedula
	 * @param correo
	 * @param salario
	 * @param anioExperiencia
	 * @param numeroVentas
	 * @param listaCompras
	 */
	public Vendedor(String nombre, String direccion, String cedula, String correo, double salario, int anioExperiencia,
			int numeroVentas, Compra[] listaCompras, int tamanioVendedor) {
		super(nombre, direccion, cedula, correo, salario, anioExperiencia);
		this.numeroVentas = numeroVentas;
		this.listaCompras = new Compra[tamanioVendedor];
	}
	// ------------- Get y Set ---------- //
	/**
	 * @return el numeroVentas
	 */
	public int getNumeroVentas() {
		return numeroVentas;
	}
	/**
	 * @param numeroVentas el numeroVentas a establecer
	 */
	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
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
	
	/**
	 * un método toString que se llama automáticamente cuando el objeto se
	 * representa como un valor de texto o cuando un objeto se referencia de tal
	 * manera que se espera una cadena.
	 */
	@Override
	public String toString() {
		return "Vendedor [numeroVentas=" + numeroVentas + ", listaCompras=" + Arrays.toString(listaCompras) + "]";
	}

	

	// ----------------------------------------------------------------------------------------------//
}