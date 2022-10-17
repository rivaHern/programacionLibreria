//principal

package programaLibreria.model;

import java.util.Arrays;
import java.util.Iterator;

import programaLibreria.Exception.RevistaException;
import programaLibreria.Exception.VendedorException;
import programaLibreria.Exception.AdministradorException;
import programaLibreria.Exception.ClienteException;
import programaLibreria.Exception.CompraException;
import programaLibreria.Exception.LibroException;
import programaLibreria.Exception.PeriodicoException;

/**
 * UNIVERSIDAD DE QUINDIO INGENEIRA SISTEMA COMPUTACION PROGRAMACION 2
 * 
 * @author JOSE LUIS RIVADENEIRA HERNANDEZ
 */
public class Libreria {

	// ------------- Son los atributos de Libreria-------------//

	private String nombre;

	private TextoLiterario[] listaTextoLiterarios;
	private Cliente[] listaClientes;
	private Compra[] listaCompras;
	private Empleado[] listaEmpleados;

	// ------------- CONSTRUCTOR----------------- //

	/**
	 * @param nombre
	 * @param listaTextoLiterarios
	 * @param listaClientes
	 * @param listaCompras
	 * @param listaEmpleados
	 */
	public Libreria(String nombre, int cantidadEmpleado, int cantidadCliente, int cantidadCompra,
			int cantidadTextoLiterario) {

		super();
		this.nombre = nombre;
		this.listaTextoLiterarios = new TextoLiterario[cantidadTextoLiterario];
		this.listaClientes = new Cliente[cantidadCliente];
		this.listaCompras = new Compra[cantidadCompra];
		this.listaEmpleados = new Empleado[cantidadEmpleado];
	}

	// ------------- get y set ---------- //
	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el listaTextoLiterarios
	 */
	public TextoLiterario[] getListaTextoLiterarios() {
		return listaTextoLiterarios;
	}

	/**
	 * @param listaTextoLiterarios
	 *            el listaTextoLiterarios a establecer
	 */
	public void setListaTextoLiterarios(TextoLiterario[] listaTextoLiterarios) {
		this.listaTextoLiterarios = listaTextoLiterarios;
	}

	/**
	 * @return el listaClientes
	 */
	public Cliente[] getListaClientes() {
		return listaClientes;
	}

	/**
	 * @param listaClientes
	 *            el listaClientes a establecer
	 */
	public void setListaClientes(Cliente[] listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * @return el listaCompras
	 */
	public Compra[] getListaCompras() {
		return listaCompras;
	}

	/**
	 * @param listaCompras
	 *            el listaCompras a establecer
	 */
	public void setListaCompras(Compra[] listaCompras) {
		this.listaCompras = listaCompras;
	}

	/**
	 * @return el listaEmpleados
	 */
	public Empleado[] getListaEmpleados() {
		return listaEmpleados;
	}

	/**
	 * @param listaEmpleados
	 *            el listaEmpleados a establecer
	 */
	public void setListaEmpleados(Empleado[] listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	// ----------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Libreria [nombre=" + nombre + ", listaTextoLiterarios=" + Arrays.toString(listaTextoLiterarios)
				+ ", listaClientes=" + Arrays.toString(listaClientes) + ", listaCompras="
				+ Arrays.toString(listaCompras) + ", listaEmpleados=" + Arrays.toString(listaEmpleados) + "]";
	}

	// ----------------------------------------------------------------------------------------------//
	// --------------operacion CRUD---------------//
	// --------- C: crear libro-----------//

	/**
	 * crear libro
	 * 
	 * @param nuevoLibro
	 * @return
	 */
	public String crearLibro(Libro nuevoLibro) {
		// 1. verificar si existe
		// 2. verificar cupo
		// 3.agregarlo a la lista
		// 4.retorna el resultado
		String mensaje = "";
		int posicionDisponible = 0;
		Libro libroEncontrado = null;
		try {
			libroEncontrado = verificarLibro(nuevoLibro.getCodigo());
			/**
			 * Validar si el libro buscado ya exixte
			 */
			if (libroEncontrado == null) {
				posicionDisponible = obtenerPosicionDisponibleLibro();
				/**
				 * Obtenemos una posicion diponible en la lista
				 */
				if (posicionDisponible != -1) {
					listaTextoLiterarios[posicionDisponible] = nuevoLibro;
					mensaje = "Libro se creado";
				} else {
					mensaje = "No se pueden crear mas libros";
				}

			} else {
				mensaje = "El libro ya fue creado";
			}

		} catch (LibroException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * cada obtener Posiciones Disponible de los Libros
	 * 
	 * @return
	 * @throws LibroException
	 */
	private int obtenerPosicionDisponibleLibro() throws LibroException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaTextoLiterarios.length && posicionDisponible == -1; i++) {
			if (listaTextoLiterarios[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new LibroException("no hay cupo para mas libro");
		}
		return posicionDisponible;
	}

	// --------- R: leer libro------------//
	/**
	 * verificar los Libros que existen o no.
	 * 
	 * @param codigo
	 * @return
	 * @throws LibroException
	 */
	private Libro verificarLibro(String codigo) throws LibroException {
		Libro libroEncontrado = null;
		for (TextoLiterario textoLiterario : listaTextoLiterarios) {
			if (textoLiterario instanceof Libro) {
				if (textoLiterario.getCodigo().equals(codigo)) {
					libroEncontrado = (Libro) textoLiterario;
					throw new LibroException("Libro ya existe");
				}
			}
		}
		return libroEncontrado;
	}

	// --------- U: Actualizar libro------//
	/**
	 * actualizar en el libro
	 * 
	 * @param codigoAnterio
	 * @param tituloNuevo
	 * @param editorialNuevo
	 * @param estadoNuevo
	 * @param unidadesDisponiblesNuevo
	 * @param precioNuevo
	 * @param idiomaNuevo
	 * @param numeroPaginasNuevo
	 * @param fechaPublicacionNuevo
	 * @param anioNuevo
	 * @param tipoFormatoNuevo
	 * @param isbnNuevo
	 * @param autorNuevo
	 * @return
	 */
	public String actualizarLibro(String codigoAnterio, String tituloNuevo, String editorialNuevo, String estadoNuevo,
			int unidadesDisponiblesNuevo, double precioNuevo, String idiomaNuevo, int numeroPaginasNuevo,
			String fechaPublicacionNuevo, int anioNuevo, TipoFormato tipoFormatoNuevo, String isbnNuevo,
			Autor autorNuevo) {

		String mensaje = "";

		try {
			Libro libro = verificarLibro(codigoAnterio);
			if (libro != null) {
				libro.setAnio(anioNuevo);
				libro.setAutor(autorNuevo);
				libro.setEditorial(editorialNuevo);
				libro.setEstado(estadoNuevo);
				libro.setFechaPublicacion(fechaPublicacionNuevo);
				libro.setIdioma(idiomaNuevo);
				libro.setIsbn(isbnNuevo);
				libro.setNumeroPaginas(numeroPaginasNuevo);
				libro.setPrecio(precioNuevo);
				libro.setTipoFormato(tipoFormatoNuevo);
				libro.setTitulo(tituloNuevo);
				libro.setUnidadesDisponibles(unidadesDisponiblesNuevo);
				mensaje = "libro actualizado exitosamente";
			} else {
				mensaje = "libro no encontrado";
			}
		} catch (LibroException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// --------- D: Borrar libro----------//

	/**
	 * cada posicion en el libro se elimina
	 * 
	 * @param codigo
	 * @return
	 */
	public String eliminarLibro(String codigo) {
		String mensaje = "";
		int posLibro = obtenerPosicionLibro(codigo);
		if (posLibro == -1) {
			mensaje = "libro no existe";
		} else {
			listaTextoLiterarios[posLibro] = null;
			mensaje = "libro se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionLibro(String codigo) {
		int pos = -1;
		int i = 0;
		for (TextoLiterario textoLiterario : listaTextoLiterarios) {
			if (textoLiterario instanceof Libro) {
				if (textoLiterario.getCodigo().equals(codigo)) {
					return i;
				}
			}
			i++;
		}
		return pos;
	}

	// --------------operacion CRUD---------------//
	// --------- C: crear Revista-----------//
	/**
	 * crear revista
	 * 
	 * @param nuevoRevista
	 * @return
	 */
	public String crearRevista(Revista nuevoRevista) {
		String mensaje = " ";
		int posicionDisponible = -1;
		Revista revistaEncontrado = null;
		try {
			revistaEncontrado = verificarRevista(nuevoRevista.getCodigo());
			posicionDisponible = obtenerPosicionDisponibleRevista();
			listaTextoLiterarios[posicionDisponible] = nuevoRevista;
			mensaje = "Revista se creado";
		} catch (RevistaException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * cada obtener Posiciones Disponible de la revista
	 * 
	 * @return
	 * @throws RevistaException
	 */
	private int obtenerPosicionDisponibleRevista() throws RevistaException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaTextoLiterarios.length && posicionDisponible == -1; i++) {
			if (listaTextoLiterarios[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new RevistaException("no hay cupo para mas revistas");
		}
		return posicionDisponible;
	}

	// ----------R:leer Revista-----------
	/**
	 * verificar la revista que existen o no.
	 * 
	 * @param codigo
	 * @return
	 * @throws RevistaException
	 */
	private Revista verificarRevista(String codigo) throws RevistaException {

		Revista revistaEncontrado = null;

		for (TextoLiterario textoLiterario : listaTextoLiterarios) {
			if (textoLiterario instanceof Revista) {
				if (textoLiterario.getCodigo().equals(codigo)) {
					revistaEncontrado = (Revista) textoLiterario;
					throw new RevistaException("Revista ya existe");
				}
			}
		}
		return revistaEncontrado;
	}

	// -----------U:actualizar Revista-----------
	/**
	 * actualizar en la revista
	 * 
	 * @param tituloNuevo
	 * @param editorialNuevo
	 * @param codigoAnterior
	 * @param estadoNuevo
	 * @param unidadesDisponiblesNuevo
	 * @param precioNuevo
	 * @param idiomaNuevo
	 * @param numeroPaginasNuevo
	 * @param fechaPublicacionNuevo
	 * @param anioNuevo
	 * @param tipoFormatoNuevo
	 * @param isbnNuevo
	 * @param categoriaNuevo
	 * @return
	 */
	public String actualizarRevista(String tituloNuevo, String editorialNuevo, String codigoAnterior,
			String estadoNuevo, int unidadesDisponiblesNuevo, double precioNuevo, String idiomaNuevo,
			int numeroPaginasNuevo, String fechaPublicacionNuevo, int anioNuevo, TipoFormato tipoFormatoNuevo,
			String isbnNuevo, String categoriaNuevo) {
		String mensaje = "";
		try {
			Revista revista = verificarRevista(codigoAnterior);
			if (revista != null) {
				revista.setAnio(anioNuevo);
				revista.setCategoria(categoriaNuevo);
				revista.setEditorial(editorialNuevo);
				revista.setEstado(estadoNuevo);
				revista.setFechaPublicacion(fechaPublicacionNuevo);
				revista.setIdioma(idiomaNuevo);
				revista.setIsbn(isbnNuevo);
				revista.setNumeroPaginas(numeroPaginasNuevo);
				revista.setPrecio(precioNuevo);
				revista.setTipoFormato(tipoFormatoNuevo);
				revista.setUnidadesDisponibles(unidadesDisponiblesNuevo);
				mensaje = "Revista actualizado exitosamente";
			} else {
				mensaje = "Revista no encontrado";
			}
		} catch (RevistaException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	// ----------D:eliminar Revista-----------

	/**
	 * cada posicion en la revista se elimina
	 * 
	 * @param codigo
	 * @return
	 */
	public String eliminarRevista(String codigo) {
		String mensaje = "";
		int posRevista = obtenerPosicionRevista(codigo);
		if (posRevista == -1) {
			mensaje = "Revista no existe";
		} else {
			listaTextoLiterarios[posRevista] = null;
			mensaje = "Revista se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionRevista(String codigo) {
		int pos = -1;
		int i = 0;
		for (TextoLiterario textoLiterario : listaTextoLiterarios) {
			if (textoLiterario instanceof Revista) {
				if (textoLiterario.getCodigo().equals(codigo)) {
					return i;
				}
			}
			i++;
		}
		return pos;
	}

	// --------------operacion CRUD---------------
	// ---------C:crear Periodico-----------
	/**
	 * crear periodico
	 * 
	 * @param nuevoPeriodico
	 * @return
	 */
	public String crearPeriodico(Periodico nuevoPeriodico) {
		String mensaje = " ";
		int posicionDisponible = -1;
		Periodico periodicoEncontrado = null;
		try {
			periodicoEncontrado = verificarPeriodico(nuevoPeriodico.getCodigo());
			posicionDisponible = obtenerPosicionDisponiblePeriodico();
			listaTextoLiterarios[posicionDisponible] = nuevoPeriodico;
			mensaje = "Periodico se creado";
		} catch (PeriodicoException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * cada obtener Posiciones Disponible del periodico
	 * 
	 * @return
	 * @throws PeriodicoException
	 */
	private int obtenerPosicionDisponiblePeriodico() throws PeriodicoException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaTextoLiterarios.length && posicionDisponible == -1; i++) {
			if (listaTextoLiterarios[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new PeriodicoException("no hay cupo para mas periodicos");
		}
		return posicionDisponible;
	}

	// ----------R:leer Periodico-----------
	/**
	 * verificar el periodico que existen o no.
	 * 
	 * @param codigo
	 * @return
	 * @throws PeriodicoException
	 */
	private Periodico verificarPeriodico(String codigo) throws PeriodicoException {

		Periodico periodicoEncontrado = null;

		for (TextoLiterario textoLiterario : listaTextoLiterarios) {
			if (textoLiterario instanceof Periodico) {
				if (textoLiterario.getCodigo().equals(codigo)) {
					periodicoEncontrado = (Periodico) textoLiterario;
					throw new PeriodicoException("Periodico ya existe");
				}
			}
		}
		return periodicoEncontrado;
	}

	// -----------U:actualizar Periodico-----------

	/**
	 * actualizar en el periodico
	 * 
	 * @param tituloNuevo
	 * @param editorialNuevo
	 * @param codigoAnterior
	 * @param estadoNuevo
	 * @param unidadesDisponiblesNuevo
	 * @param precioNuevo
	 * @param idiomaNuevo
	 * @param numeroPaginasNuevo
	 * @param fechaPublicacionNuevo
	 * @param anioNuevo
	 * @param tipoFormatoNuevo
	 * @param ciudadNuevo
	 * @return
	 */
	public String actualizarPeriodico(String tituloNuevo, String editorialNuevo, String codigoAnterior,
			String estadoNuevo, int unidadesDisponiblesNuevo, double precioNuevo, String idiomaNuevo,
			int numeroPaginasNuevo, String fechaPublicacionNuevo, int anioNuevo, TipoFormato tipoFormatoNuevo,
			String ciudadNuevo) {
		String mensaje = "";
		try {
			Periodico periodico = verificarPeriodico(codigoAnterior);
			if (periodico != null) {
				periodico.setAnio(anioNuevo);
				periodico.setCiudad(ciudadNuevo);
				periodico.setEditorial(editorialNuevo);
				periodico.setEstado(estadoNuevo);
				periodico.setFechaPublicacion(fechaPublicacionNuevo);
				periodico.setIdioma(idiomaNuevo);
				periodico.setNumeroPaginas(numeroPaginasNuevo);
				periodico.setPrecio(precioNuevo);
				periodico.setTipoFormato(tipoFormatoNuevo);
				periodico.setTitulo(tituloNuevo);
				periodico.setUnidadesDisponibles(unidadesDisponiblesNuevo);
				mensaje = "Periodico actualizado exitosamente";
			} else {
				mensaje = "Periodico no encontrado";
			}
		} catch (PeriodicoException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	// ----------D:eliminar Periodico-----------

	/**
	 * cada posicion en el periodico se elimina
	 * 
	 * @param codigo
	 * @return
	 */
	public String eliminarPeriodico(String codigo) {
		String mensaje = "";
		int posPeriodico = obtenerPosicionPeriodico(codigo);
		if (posPeriodico == -1) {
			mensaje = "Periodico no existe";
		} else {
			listaTextoLiterarios[posPeriodico] = null;
			mensaje = "Periodico se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionPeriodico(String codigo) {
		int pos = -1;
		int i = 0;
		for (TextoLiterario textoLiterario : listaTextoLiterarios) {
			if (textoLiterario instanceof Periodico) {
				if (textoLiterario.getCodigo().equals(codigo)) {
					return i;
				}
			}
			i++;
		}
		return pos;
	}

	// --------------operacion CRUD---------------
	// ---------C:crear Cliente-----------

	/**
	 * crear cliente
	 * 
	 * @param nuevoCliente
	 * @return
	 */
	public String crearCliente(Cliente nuevoCliente) {
		String mensaje = " ";
		int posicionDisponible = 0;
		Cliente clienteEncontrado = null;
		try {
			clienteEncontrado = verificarCliente(nuevoCliente.getCedula());
			if (clienteEncontrado == null) {
				posicionDisponible = obtenerPosicionDisponibleCliente();
				if (posicionDisponible != 1) {
					listaClientes[posicionDisponible] = nuevoCliente;
					mensaje = "Cliente se creado";
				} else {
					mensaje = "No se puede crear mas clientes";
				}

			} else {
				mensaje = "Cliente ya existe";
			}

		} catch (ClienteException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	/**
	 * cada obtener Posiciones Disponible del cliente.
	 * @return
	 * @throws ClienteException
	 */
	private int obtenerPosicionDisponibleCliente() throws ClienteException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaClientes.length && posicionDisponible == -1; i++) {
			if (listaClientes[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new ClienteException("no hay cupo para mas cliente");
		}
		return posicionDisponible;
	}

	// ----------R:leer Cliente-----------
	/**
	 * verificar el cliente que existen o no.
	 * 
	 * @param cedula
	 * @return
	 * @throws ClienteException
	 */
	private Cliente verificarCliente(String cedula) throws ClienteException {
		Cliente clienteEncontrado = null;
		for (int i = 0; i < listaClientes.length && clienteEncontrado == null; i++) {
			Cliente clienteAux = listaClientes[i];
			if (clienteAux != null && clienteAux.getCedula().equals(cedula)) {
				clienteEncontrado = clienteAux;
				throw new ClienteException("Cliente ya existe");
			}
		}
		return clienteEncontrado;
	}

	// -----------U:actualizar Cliente-----------
	/**
	 * actualizar en el cliente
	 * 
	 * @param nombreNuevo
	 * @param telefonoNuevo
	 * @param cedulaAnterior
	 * @param correoNuevo
	 * @param listaComprasNuevo
	 * @return
	 */
	public String actualizarCliente(String nombreNuevo, String telefonoNuevo, String cedulaAnterior, String correoNuevo,
			Compra[] listaComprasNuevo) {
		String mensaje = "";
		try {
			Cliente clienteEncontrado = verificarCliente(cedulaAnterior);
			if (clienteEncontrado != null) {
				clienteEncontrado.setCorreo(correoNuevo);
				clienteEncontrado.setNombre(nombreNuevo);
				clienteEncontrado.setTelefono(telefonoNuevo);
				clienteEncontrado.setListaCompras(listaComprasNuevo);
				mensaje = "Cliente actualizado exitosamente";
			} else {
				mensaje = "Cliente no encontrado";
			}
		} catch (ClienteException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	// ----------D:eliminar Cliente-----------
	/**
	 * cada posicion en el cliente se elimina
	 * 
	 * @param cedula
	 * @return
	 */
	public String eliminarCliente(String cedula) {
		String mensaje = "";
		int posCliente = obtenerPosicionCliente(cedula);
		if (posCliente == -1) {
			mensaje = "Cliente no existe";
		} else {
			listaClientes[posCliente] = null;
			mensaje = "Cliente se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionCliente(String cedula) {
		int pos = -1;
		for (int i = 0; i < listaClientes.length; i++) {
			if (listaClientes[i] != null && listaClientes[i].getCedula().equals(cedula)) {
				return i;
			}
		}
		return pos;
	}

	// --------------operacion CRUD---------------
	// -----------C:crear Compra-----------
	/**
	 * 
	 * @param cedulaCliente
	 * @param nuevaCompra
	 * @return
	 * @throws Exception
	 */
	public String crearCompra(String cedulaCliente, Compra nuevaCompra) throws Exception {
		String mensaje = "Error";
		int posicionDisponible = 0;
		Compra compraEncontrado = null;
		Cliente clienteEncontrado = null;

		if (cedulaCliente != null && nuevaCompra != null) {
			try {
				clienteEncontrado = verificarCliente(cedulaCliente);
				if (clienteEncontrado != null) {
					listaCompras = clienteEncontrado.getListaCompras();
					compraEncontrado = verificarCompras(listaCompras, nuevaCompra.getCodigo());
					if (compraEncontrado == null) {
						posicionDisponible = obtenerPosicionDisponibleCompra();
						if (posicionDisponible != -1) {
							listaCompras[posicionDisponible] = nuevaCompra;
							mensaje = "Compra se creado";
						} else {
							mensaje = "No se puede crear mas compras ";
						}

					} else {
						mensaje = "la compra ya existe ";
					}
				} else {
					mensaje = "Cliente no encontrado";
				}
			} catch (CompraException e) {
				mensaje = e.getMessage();
			}
		}
		return mensaje;
	}

	/**
	 * 
	 * @return
	 * @throws CompraException
	 */
	private int obtenerPosicionDisponibleCompra() throws CompraException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaCompras.length && posicionDisponible == -1; i++) {
			if (listaCompras[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new CompraException("no hay cupo para mas Compras");
		}
		return posicionDisponible;
	}

	// ----------R:leer Compra-----------
	/**
	 * 
	 * 
	 * @param codigo
	 * @return
	 * @throws CompraException
	 */
	private Compra verificarCompra(String codigo) throws CompraException {
		Compra compraEncontrado = null;
		for (int i = 0; i < listaCompras.length && compraEncontrado == null; i++) {
			Compra compraAux = listaCompras[i];
			if (compraAux != null && compraAux.getCodigo().equals(codigo)) {
				compraEncontrado = compraAux;
				throw new CompraException("Compra ya existe");

			}
		}
		return compraEncontrado;
	}
	/**
	 * 
	 * @param listaCompras
	 * @param codigoBuscar
	 * @return
	 */
	private Compra verificarCompras(Compra[] listaCompras, String codigoBuscar) {
		for (int i = 0; i < listaCompras.length; i++) {
			if (listaCompras[i] != null && listaCompras[i].getCodigo().equalsIgnoreCase(codigoBuscar)) {
				return listaCompras[i];
			}
		}
		return null;
	}
	
	// -----------U:actualizar Compra-----------
	/**
	 * 
	 * @param codigoAnterior
	 * @param fechaCompraNuevo
	 * @param totalNuevo
	 * @param ivaNuevo
	 * @param medioPagoNuevo
	 * @param descuentosNuevo
	 * @param listaDetalleComprasNuevo
	 * @return
	 */
	public String actualizarCompra(String codigoAnterior, String fechaCompraNuevo, double totalNuevo, double ivaNuevo,
			double medioPagoNuevo, double descuentosNuevo, DetalleCompra[] listaDetalleComprasNuevo) {
		String mensaje = "";
		try {
			Compra compraEncontrado = verificarCompra(codigoAnterior);
			if (compraEncontrado != null) {
				compraEncontrado.setDescuentos(descuentosNuevo);
				compraEncontrado.setFechaCompra(fechaCompraNuevo);
				compraEncontrado.setIva(ivaNuevo);
				compraEncontrado.setListaDetalleCompras(listaDetalleComprasNuevo);
				compraEncontrado.setMedioPago(medioPagoNuevo);
				compraEncontrado.setTotal(totalNuevo);
				
				mensaje = "Compra actualizado exitosamente";
			} else {
				mensaje = "Compra no encontrado";
			}
		} catch (CompraException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	// ----------D:eliminar Compra-----------
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public String eliminarCompra(String codigo) {
		String mensaje = "";
		int posCompra = obtenerPosicionCompra(codigo);
		if (posCompra == -1) {
			mensaje = "Compra no existe";
		} else {
			listaCompras[posCompra] = null;
			mensaje = "Compra se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionCompra(String codigo) {
		int pos = -1;
		for (int i = 0; i < listaCompras.length; i++) {
			if (listaCompras[i] != null && listaCompras[i].getCodigo().equals(codigo)) {
				return i;
			}
		}
		return pos;
	}

	// --------------operación CRUD---------------
	// ----------C:crear Vendedor-----------

	public String crearVendedor(Vendedor nuevoVendedor) {
		String mensaje = " ";
		int posicionDisponible = -1;
		Vendedor vendedorEncontrado = null;
		try {
			vendedorEncontrado = verificarVendedor(nuevoVendedor.getCedula());
			posicionDisponible = obtenerPosicionDisponibleVendedor();
			listaEmpleados[posicionDisponible] = nuevoVendedor;
			mensaje = "Vendedor se creado";
		} catch (VendedorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	private int obtenerPosicionDisponibleVendedor() throws VendedorException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaEmpleados.length && posicionDisponible == -1; i++) {
			if (listaEmpleados[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new VendedorException("no hay cupo para mas vendedores");
		}
		return posicionDisponible;
	}

	// ----------R:leer Vendedor-----------

	private Vendedor verificarVendedor(String cedula) throws VendedorException {

		Vendedor vendedorEncontrado = null;
		for (Empleado empleado : listaEmpleados) {
			if (empleado instanceof Vendedor) {
				if (empleado.getCedula().equals(cedula)) {
					vendedorEncontrado = (Vendedor) empleado;
					throw new VendedorException("Vendedor ya existe");
				}
			}
		}
		return vendedorEncontrado;
	}

	// -----------U: actualizar Vendedor-----------
	public String actualizarVendedor(String nombreNuevo, String direccionNuevo, String cedulaAnterior,
			String correoNuevo, double salarioNuevo, int anioExperienciaNuevo, int numeroVentasNuevo,
			Compra[] listaComprasNuevo) {
		String mensaje = "";
		try {
			Vendedor vendedor = verificarVendedor(cedulaAnterior);
			if (vendedor != null) {
				vendedor.setAnioExperiencia(anioExperienciaNuevo);
				vendedor.setCorreo(correoNuevo);
				vendedor.setDireccion(direccionNuevo);
				vendedor.setNombre(nombreNuevo);
				vendedor.setNumeroVentas(numeroVentasNuevo);
				vendedor.setSalario(salarioNuevo);
				vendedor.setListaCompras(listaComprasNuevo);

				mensaje = "Vendedor actualizado exitosamente";
			} else {
				mensaje = "Vendedor no encontrado";
			}
		} catch (VendedorException e) {
			mensaje = e.getMessage();
		}

		return mensaje;
	}

	// ---------- D: eliminar Vendedor-----------
	public String eliminarVendedor(String cedula) {
		String mensaje = "";
		int posVendedor = obtenerPosicionVendedor(cedula);
		if (posVendedor == -1) {
			mensaje = "Vendedor no existe";
		} else {
			listaEmpleados[posVendedor] = null;
			mensaje = "Vendedor se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionVendedor(String cedula) {
		int pos = -1;
		int i = 0;
		for (Empleado empleado : listaEmpleados) {
			if (empleado instanceof Vendedor) {
				if (empleado.getCedula().equals(cedula)) {
					return i;
				}
			}
			i++;
		}
		return pos;
	}

	// --------------operación CRUD---------------//
	// ---------- C: crear Administrador-----------//
	public String crearAdministrador(Administrador nuevoAdministrador) {
		String mensaje = " ";
		int posicionDisponible = -1;
		Administrador administradorEncontrado = null;
		try {
			administradorEncontrado = verificarAdministrador(nuevoAdministrador.getCedula());
			posicionDisponible = obtenerPosicionDisponibleAdministrador();
			listaEmpleados[posicionDisponible] = nuevoAdministrador;
			mensaje = "Administrador se creado";
		} catch (AdministradorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	private int obtenerPosicionDisponibleAdministrador() throws AdministradorException {
		int posicionDisponible = -1;
		for (int i = 0; i < listaEmpleados.length && posicionDisponible == -1; i++) {
			if (listaEmpleados[i] == null) {
				posicionDisponible = i;
			}
		}
		if (posicionDisponible == -1) {
			throw new AdministradorException("no hay cupo para mas Administradores");
		}
		return posicionDisponible;
	}

	// ---------- R: leer Administrador-----------//
	private Administrador verificarAdministrador(String cedula) throws AdministradorException {

		Administrador administradorEncontrado = null;
		for (Empleado empleado : listaEmpleados) {
			if (empleado instanceof Administrador) {
				if (empleado.getCedula().equals(cedula)) {
					administradorEncontrado = (Administrador) empleado;
					throw new AdministradorException("Administrador ya existe");
				}
			}
		}
		return administradorEncontrado;
	}

	// -----------U: actualizar Administrador-----------//
	public String actualizarAdministrador(String nombreNuevo, String direccionNuevo, String cedulaAnterior,
			String correoNuevo, double salarioNuevo, String profesionNuevo, int anioExperienciaNuevo) {

		String mensaje = "";

		try {
			Administrador administrador = verificarAdministrador(cedulaAnterior);
			if (administrador != null) {
				administrador.setAnioExperiencia(anioExperienciaNuevo);
				administrador.setCorreo(correoNuevo);
				administrador.setDireccion(direccionNuevo);
				administrador.setNombre(nombreNuevo);
				administrador.setProfesion(profesionNuevo);
				administrador.setSalario(salarioNuevo);
				mensaje = "Administrador actualizado exitosamente";
			} else {
				mensaje = "Administrador no encontrado";
			}
		} catch (AdministradorException e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	// ---------- D: eliminar Administrador-----------//
	public String eliminarAdministrador(String cedula) {
		String mensaje = "";
		int posAdministrador = obtenerPosicionAdministrador(cedula);
		if (posAdministrador == -1) {
			mensaje = "Administrador no existe";
		} else {
			listaEmpleados[posAdministrador] = null;
			mensaje = "Administrador se elimino";
		}
		return mensaje;
	}

	private int obtenerPosicionAdministrador(String cedula) {
		int pos = -1;
		int i = 0;
		for (Empleado empleado : listaEmpleados) {
			if (empleado instanceof Administrador) {
				if (empleado.getCedula().equals(cedula)) {
					return i;
				}
			}
			i++;
		}
		return pos;
	}

	// --------------operacion CRUD---------------//
	// ----------C:crear Destalle compra-----------//
	public String crearDestalleCompra(String codigoCompra, String codigoDetalleCompra, int cantidad, double subTotal,
			TextoLiterario textoLiterario) throws CompraException {
		String mensaje = "";
		Compra compra = null;
		compra = verificarCompra(codigoCompra);
		if (compra != null) {
			DetalleCompra detalleCompra = verificarDetalleCompra(compra, codigoDetalleCompra);
			if (detalleCompra == null) {
				detalleCompra = new DetalleCompra(cantidad, subTotal, codigoDetalleCompra, textoLiterario);
				int posicion = obtenerPosicionDisponibleDetalleCompra(compra);
				if (posicion != -1) {
					DetalleCompra[] listaDetalleCompra = compra.getListaDetalleCompras();
					listaDetalleCompra[posicion] = detalleCompra;
					compra.setListaDetalleCompras(listaDetalleCompra);
					mensaje = "Sea a creado con exito el nuevo detalle factura";
				} else {
					mensaje = "No se puede crear mas Detalles Compras";
				}
			} else {
				mensaje = "Ya exixte detalle compra";
			}
		} else {
			mensaje = "La compra no se encontrado";
		}
		return mensaje;
	}

	private int obtenerPosicionDisponibleDetalleCompra(Compra compra) {
		int posDisponible = -1;
		DetalleCompra[] listaDetalleCompra = compra.getListaDetalleCompras();
		for (int i = 0; i < listaDetalleCompra.length; i++) {
			if (listaDetalleCompra[i] == null) {
				return i;
			}
		}
		return posDisponible;
	}

	// ---------- R: leer Destalle compra-----------//
	private DetalleCompra verificarDetalleCompra(Compra compra, String codigoDetalleCompra) {
		if (compra != null) {
			DetalleCompra[] listaDetalleCompras = compra.getListaDetalleCompras();
			if (listaDetalleCompras != null) {
				for (int i = 0; i < listaDetalleCompras.length; i++) {
					if (listaDetalleCompras[i] != null) {
						if (listaDetalleCompras[i].getCodigo().equals(codigoDetalleCompra)) {
							return listaDetalleCompras[i];
						}
					}
				}
			}
		}
		return null;
	}

	// -----------U: actualizar Destalla compra------//
	public String actualizarDestallaCompra(String codigoCompraAnterior, String codigoDetalleCompraAnterior,
			int cantidadNuevo, double subTotalNuevo,TextoLiterario textoLiterarioNuevo) {
		
		
		return nombre;
	}
	// ---------- D: eliminar Destalla compra--------//

}