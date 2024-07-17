package es.eoi.mundobancario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundobancario.entity.Movimiento;
import es.eoi.mundobancario.repository.MovimientoRepository;

@Service
public class MovimientoServiceImpl implements MovimientoService{
	
	@Autowired
    private MovimientoRepository movimientoRepository;

	
    public List<Movimiento> obtenerMovimientosPorCuenta(Integer id) {
        return movimientoRepository.findByCuenta(id);
    }
    

}
