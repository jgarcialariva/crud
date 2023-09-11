package Datos;
import Entidades.Clientes;
import java.sql.*;
import java.util.ArrayList;

public class BDClientes {
	// Objetos para la conexion con MySQL
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/cibertec2023";
	private String Usuario = "root";
	private String Password = "root";
	
	// Objetos para realizar la conexion con MySQL
	private Connection Cn;				// Conexion
	private Statement Cmd;				// Comando SQL
	private CallableStatement Stmt;		// Store Procedure
	private ResultSet Rs;				// Recuperar información
	
	// Método Constructor
	public BDClientes() {
		try {
				Class.forName(Driver);
				Cn = DriverManager.getConnection(URL, Usuario, Password);
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
	
	// Método ListarClientes
	public ArrayList<Clientes> ListarClientes(){
		ArrayList<Clientes> ListaC = null;
		String SQL = "SELECT * FROM Clientes";
		try {
				Cmd = Cn.createStatement();
				Rs = Cmd.executeQuery(SQL);
				ListaC = new ArrayList<>();
				while(Rs.next()) {
					ListaC.add(new Clientes(Rs.getString("IdCliente"), Rs.getString("Apellidos"),
							Rs.getString("Nombres"), Rs.getInt("Edad"), Rs.getString("Sexo").charAt(0)));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}		
		return ListaC;
	}
	
	// Método BuscarCliente
	public Clientes BuscarCliente(String Id) {
		Clientes ObjC = null;
		String SQL = "SELECT * FROM Clientes WHERE IdCliente=?";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
				if(Rs.next()) {
					ObjC = new Clientes(Rs.getString("IdCliente"), Rs.getString("Apellidos"),
							Rs.getString("Nombres"), Rs.getInt("Edad"), Rs.getString("Sexo").charAt(0));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
		return ObjC;
	}
	
	// Método InsertaCliente
	public void InsertaCliente(Clientes ObjC) {
		String SQL = "INSERT INTO Clientes VALUES(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjC.getIdCliente());
				Stmt.setString(2, ObjC.getApellidos());
				Stmt.setString(3, ObjC.getNombres());
				Stmt.setInt(4, ObjC.getEdad());
				Stmt.setString(5, ObjC.getSexo()+"");
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
	
	// Método ModificaCliente
	public void ModificaCliente(Clientes ObjC) {
		String SQL = "UPDATE Clientes SET Apellidos=?,Nombres=?,Edad=?,Sexo=? WHERE IdCliente=?";
		try {
				Stmt = Cn.prepareCall(SQL);				
				Stmt.setString(1, ObjC.getApellidos());
				Stmt.setString(2, ObjC.getNombres());
				Stmt.setInt(3, ObjC.getEdad());
				Stmt.setString(4, ObjC.getSexo()+"");
				Stmt.setString(5, ObjC.getIdCliente());
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
	
	// Método SuprimirCliente
	public void SuprimirCliente(String Id) {
		String SQL = "DELETE FROM Clientes WHERE IdCliente=?";
		try {
				Stmt = Cn.prepareCall(SQL);				
				Stmt.setString(1, Id);
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("*** ERROR:" + e.getMessage());
		}
	}
}
