package sim.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import sim.persistence.relatorio.jdbc.Pedido;
import sim.persistence.relatorio.jdbc.PedidoDao;

@Path("/consulta")
public class ServicePedido {

	
	@GET	
	@Path("/pedido/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public String listar(@PathParam("id") Integer cod) {
		PedidoDao dao = new PedidoDao();
		try {
			return new Gson().toJson(dao.findByCode(cod));
		} catch (Exception ex) {
			return null;
		}
	}
	
	
	@GET	
	@Path("/pedido/status/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public String status(@PathParam("id") Integer cod) {
		PedidoDao dao = new PedidoDao();
		try {
			Pedido pedido = dao.findByCode(cod);
			String codigo = pedido.getCodigo().toString();
			String status = pedido.getStatus();
			return new Gson().toJson("Pedido: "+codigo+ " Status: "+status);
		} catch (Exception ex) {
			return null;
		}
	}
	
	
}
