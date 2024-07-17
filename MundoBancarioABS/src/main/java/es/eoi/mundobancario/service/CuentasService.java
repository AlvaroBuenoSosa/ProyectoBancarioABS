package es.eoi.mundobancario.service;

import java.util.List;

import es.eoi.mundobancario.entity.Cuenta;
import es.eoi.mundobancario.entity.Prestamo;
import es.eoi.mundobancario.enums.MovimientosEnum;

public interface CuentasService  {
	
	public List<Cuenta> encontrarCuentas();
	public List<Cuenta> obtenerCuentasDeudoras();
	Cuenta obtenerCuentaPorId(Integer id);
	Cuenta agregarCuenta(Cuenta nuevaCuenta);
	Cuenta updateAlias(Integer id, String nuevoAlias);
	public Cuenta realizarMovimiento(Integer num_cuenta, MovimientosEnum tipo, double importe) throws Exception;
	Cuenta actualizarSaldo(Cuenta cuenta, MovimientosEnum tipo, double importe);

}
