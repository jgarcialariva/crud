package Entidades;

public class Clientes {
	// Campos o atributos
	private String IdCliente;
    private String Apellidos;
    private String Nombres;
    private int Edad;
    private char Sexo;
    
    // Métodos Constructores
	public Clientes() {
	}

	public Clientes(String idCliente, String apellidos, String nombres, int edad, char sexo) {
		IdCliente = idCliente;
		Apellidos = apellidos;
		Nombres = nombres;
		Edad = edad;
		Sexo = sexo;
	}

	// Propiedades de Lectura y Escritura
	public String getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(String idCliente) {
		IdCliente = idCliente;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}
}
