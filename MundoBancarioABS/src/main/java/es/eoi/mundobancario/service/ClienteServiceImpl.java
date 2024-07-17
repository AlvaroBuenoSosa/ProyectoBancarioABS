package es.eoi.mundobancario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundobancario.dto.ClienteDto;
import es.eoi.mundobancario.entity.Cliente;
import es.eoi.mundobancario.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired	
	ClienteRepository clientesRepository;
	
	@Override
	public ClienteDto findClientesDto(Integer id) {
		
		Cliente entity = clientesRepository.findById(id).get();	
		ClienteDto dto=new ClienteDto();
		dto.setNombre(entity.getNombre());
		dto.setUsuario(entity.getUsuario());
		dto.setEmail(entity.getEmail());
		
		return dto;
	}
	
	@Override
	public Cliente findClientes(Integer id) {
		return clientesRepository.findById(id).get();
	}
	
	
	@Override
    public List<ClienteDto> findAll() {
		List<Cliente> entity = clientesRepository.findAll();
		List<ClienteDto> entity1 = new ArrayList<>();
		int i = 0;
		for (i=0; i<entity.size(); i++) {
			
			ClienteDto dto=new ClienteDto();
			dto.setNombre(entity.get(i).getNombre());
			dto.setUsuario(entity.get(i).getUsuario());
			dto.setEmail(entity.get(i).getEmail());
			
			entity1.add(dto);
		}
		
		return entity1;
	
    }
	
	@Override
	public Cliente updateEmail(Integer id, String nuevoEmail) {
        Cliente cliente = clientesRepository.findById(id).get();
        cliente.setEmail(nuevoEmail);
        return clientesRepository.save(cliente);
    }
	
	@Override
	public Cliente addCliente(Cliente nuevoCliente) {
		return clientesRepository.save(nuevoCliente);
		
	}
	
	

	@Override
	public void deleteAll() {
		clientesRepository.deleteAll();
		
	}
	
	@Override
	public Cliente updateCliente(Cliente cliente) {
        return clientesRepository.save(cliente);
    }



	@Override
	public void delete(Integer id) {
		clientesRepository.deleteById(id);
		
	}


	



}




