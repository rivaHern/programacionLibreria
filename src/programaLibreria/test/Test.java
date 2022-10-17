package programaLibreria.test;

import programaLibreria.Exception.CompraException;
import programaLibreria.model.Autor;
import programaLibreria.model.Cliente;
import programaLibreria.model.Compra;
import programaLibreria.model.DetalleCompra;
import programaLibreria.model.Libreria;
import programaLibreria.model.Libro;
import programaLibreria.model.TextoLiterario;
import programaLibreria.model.TipoFormato;

public class Test {

	public static void main(String[] args) {

		Libreria libreria = new Libreria("XXX", 1, 10, 10, 2);

		TipoFormato tipoFormato = TipoFormato.IMPRESO;

		Autor autor1 = new Autor("nombre1", "apellido1", "identificacion1");
		Libro libro1 = new Libro("titulo1", "editorial1", "codigo1", "estado1", 1, 2000000, "idioma1", 5,
				"fechaPublicacion1", 5, tipoFormato, "isbn1", autor1);

		Autor autor2 = new Autor("nombre2", "apellido2", "identificacion2");
		Libro libro2 = new Libro("titulo2", "editorial2", "codigo2", "estado2", 10, 4000000, "idioma2", 55,
				"fechaPublicacion2", 15, tipoFormato, "isbn2", autor2);
		Compra compra1 = new Compra("codigo1", "fechaCompra1", 45200, 16, 9500, 53);
		Compra compra2 = new Compra("codigo2", "fechaCompra2", 5458485, 185, 500, 5);

		Compra[] listaCompras = new Compra[5];
		listaCompras[0] = compra1;
		listaCompras[1] = compra2;
		listaCompras[2] = null;
		Cliente cliente1 = new Cliente("cliente1", "telefono", "cedula2", "correo", 10);
		Cliente cliente2 = new Cliente("cliente2", "telefono", "cedula2", "correo", 5);
		
		Cliente[] listaClientes = new Cliente[5];
		listaClientes[0] = cliente1;
		listaClientes[1] = cliente2;
		listaClientes[2] = null;
		
		TextoLiterario[] listaTextoLiterarios = new TextoLiterario[10];
		listaTextoLiterarios[0] = libro1;
		listaTextoLiterarios[1] = libro2;
		
//		System.out.println(listaTextoLiterarios[0]);
//		System.out.println(listaTextoLiterarios[1]);
//		System.out.println(listaTextoLiterarios[2]);
		System.out.println(listaCompras[0]);
		System.out.println(listaCompras[1]);
		System.out.println(listaClientes[0]);
		System.out.println(listaClientes[1]);
		System.out.println(listaClientes[2]);
		//String mensaje = libreria.crearLibro(libro1);
		//String mensaje1 = libreria.crearLibro(libro2);
		String mjs = libreria.crearCliente(cliente1);
		String mjs1 = libreria.crearCliente(cliente2);
		//String mjs2 = libreria.crearCliente(cliente3);
		//System.out.println(mensaje);
		//System.out.println(mensaje1);
		System.out.println(mjs);
		System.out.println(mjs1);
		//System.out.println(mjs2);
		// Autor autor2 = new Autor("nombre2", "apellido2", "identificacion2");
		// Libro libro2 = new Libro("titulo2", "editorial2", "codigo2",
		// "estado2", 1, 2000000, "idioma2", 5, "fechaPublicacion2",5,
		// tipoFormato,"isbn2" , autor2);
		// TextoLiterario[] listaTextoLiterarios = new TextoLiterario[10];
		// listaTextoLiterarios[0] = libro2;
		// libreria.setListaTextoLiterarios(listaTextoLiterarios);

		// System.out.println(listaTextoLiterarios[0]);
		// String mensaje2 = libreria.crearLibro(libro1);
		// String mensaje3 = libreria.actualizarLibro(libro1);
		// System.out.println(mensaje2);
		// System.out.println(mensaje2 + "\n" +libro2.toString());

		// int posicion = libreria.obtenerPosicionLibro("codigo");
		// TextoLiterario[] lista = libreria.getListaTextoLiterarios();
		//
		// System.out.println(lista[posicion]);
		// String mensaje2 = libreria.eliminarLibro("codigo23");
		// System.out.println(mensaje2);
		// System.out.println(libreria.actualizarLibro("codigo5", "titulo1",
		// "edito1rial",
		// "estado", 5,200.20 , "id5ioma", 90, "fechaPublic2acion", 6,
		// tipoFormato, "isbn", autor1));
		// System.out.println(listaTextoLiterarios[1]);

		// Compra[] listaCompras = new Compra[10];
		// Compra compra = new Compra("codigo", "fechaCompra", 200000, 1.5,
		// 100000, 200);
		// listaCompras[0] = compra;

		// libreria.setListaCompras(listaCompras);
		// System.out.println(listaCompras[0]);
		//
		// Cliente[] listaClientes = new Cliente[10];
		// Cliente cliente = new Cliente("nombre", "telefono", "cedula",
		// "correo", listaCompras);
		// listaClientes[0] = cliente;

		// cliente.setListaCompras(listaCompras);

		// libreria.setListaClientes(listaClientes);

		// String mensaje;
		// try {
		// mensaje = libreria.crearCompra("cedula", compra);
		// System.out.println(mensaje);
		// } catch (Exception e) {
		// // TODO Bloque catch generado automáticamente
		// e.printStackTrace();
		// }
		//
		// String codigoCompra = "codigo";
		// String codigoDetalleCompra = "Compra";
		// int cantidad = 3;
		// TextoLiterario textoLiterario = libro1;
		// double subTotal = 0;
		// if (libro1 != null) {
		// subTotal = cantidad*libro1.getPrecio();
		// }
		//
		//
		// try {
		//
		// String mensaje =libreria.crearDestalleCompra(codigoCompra,
		// codigoDetalleCompra,
		// cantidad, subTotal, textoLiterario);
		// System.out.println(mensaje);
		//
		// System.out.println(cliente.toString());
		// } catch (CompraException e) {
		// // TODO Bloque catch generado automáticamente
		// e.printStackTrace();
		// }

	}

}
