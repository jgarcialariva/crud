package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entidades.Clientes;
import Negocio.BDNegocio;

@WebServlet("/grabar")
public class grabar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public grabar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BDNegocio ObjN = new BDNegocio();
		Clientes ObjC = new Clientes();
		String Id = "";
		int op = Integer.parseInt(request.getParameter("op"));
		if(op == 1 || op == 3) {
			ObjC.setIdCliente(request.getParameter("txtid"));
			ObjC.setApellidos(request.getParameter("txtape"));
			ObjC.setNombres(request.getParameter("txtnom"));
			ObjC.setEdad(Integer.parseInt(request.getParameter("txtedad")));
			ObjC.setSexo(request.getParameter("txtsex").charAt(0));			
		}else {
			Id = request.getParameter("txtid");
		}
		switch(op) {
			case 1: ObjN.ModificaCliente(ObjC); break;
			case 2: ObjN.SuprimirCliente(Id); break;
			case 3: ObjN.InsertaCliente(ObjC); break;
		}
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
