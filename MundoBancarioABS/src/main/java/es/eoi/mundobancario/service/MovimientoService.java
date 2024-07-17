package es.eoi.mundobancario.service;

import java.util.List;

import es.eoi.mundobancario.entity.Movimiento;

public interface MovimientoService {

	List<Movimiento> obtenerMovimientosPorCuenta(Integer num_cuenta);


}
