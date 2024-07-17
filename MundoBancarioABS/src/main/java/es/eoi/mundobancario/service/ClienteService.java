package es.eoi.mundobancario.service;

import java.util.List;
import es.eoi.mundobancario.dto.ClienteDto;
import es.eoi.mundobancario.entity.Cliente;

public interface ClienteService {
	
	public List<ClienteDto> findAll();
	
	public Cliente findClientes(Integer id);
	
	public ClienteDto findClientesDto(Integer id);
	
	public Cliente updateCliente(Cliente cliente);
	
	public Cliente updateEmail(Integer id, String nuevoEmail);
	
	public Cliente addCliente(Cliente nuevoCliente);
		
	public void deleteAll();

	public void delete(Integer id);

}
