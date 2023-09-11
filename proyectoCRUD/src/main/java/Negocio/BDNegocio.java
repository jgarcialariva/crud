package Negocio;
import Entidades.Clientes;
import java.util.ArrayList;
import Datos.BDClientes;

public class BDNegocio {
	private BDClientes ObjBD;
	
	public BDNegocio() {
		ObjBD = new BDClientes();
	}
	
	public ArrayList<Clientes> ListarClientes(){
		return ObjBD.ListarClientes();
	}
	
	public Clientes BuscarCliente(String Id) {
		return ObjBD.BuscarCliente(Id);
	}
	
	public void InsertaCliente(Clientes ObjC) {
		ObjBD.InsertaCliente(ObjC);
	}
	
	public void ModificaCliente(Clientes ObjC) {
		ObjBD.ModificaCliente(ObjC);
	}
	
	public void SuprimirCliente(String Id) {
		ObjBD.SuprimirCliente(Id);
	}
}
