package es.eoi.mundobancario.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.eoi.mundobancario.entity.Cuenta;
import es.eoi.mundobancario.entity.Movimiento;
import es.eoi.mundobancario.entity.Prestamo;
import es.eoi.mundobancario.enums.MovimientosEnum;
import es.eoi.mundobancario.repository.CuentasRepository;
import es.eoi.mundobancario.repository.MovimientoRepository;
import es.eoi.mundobancario.repository.PrestamoRepository;

@Service
public class CuentasServiceImpl implements CuentasService{
	
	@Autowired	
	CuentasRepository cuentaRepository;
	
	@Autowired
    MovimientoRepository movimientoRepository;
	
	@Autowired
	
	PrestamoRepository prestamoRepository;

	@Override
	public List<Cuenta> encontrarCuentas() {				
		return cuentaRepository.findAll();
				
	}
	
	@Override
	public List<Cuenta> obtenerCuentasDeudoras() {
		return cuentaRepository.findAllBySaldoLessThan(0.0);
	}
	
	@Override
	 public Cuenta obtenerCuentaPorId(Integer id) {
	        return cuentaRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
	        

}
	@Override
	public Cuenta agregarCuenta(Cuenta nuevaCuenta) {
        return cuentaRepository.save(nuevaCuenta);
    }
	
	@Override
	public Cuenta updateAlias(Integer id, String nuevoAlias) {
        Cuenta cuenta = cuentaRepository.findById(id).get();
        cuenta.setAlias(nuevoAlias);
        return cuentaRepository.save(cuenta);
    }

	public MovimientoRepository getMovimientoRepository() {
		return movimientoRepository;
	}

	public void setMovimientoRepository(MovimientoRepository movimientoRepository) {
		this.movimientoRepository = movimientoRepository;
	}

	@Transactional public Cuenta realizarMovimiento(Integer id,
	 MovimientosEnum tipo, double importe) throws Exception { Cuenta cuenta =
	 cuentaRepository.findById(id).orElseThrow(() -> new
	 Exception("Cuenta no encontrada")); if (tipo == MovimientosEnum.PAGO &&
	 cuenta.getSaldo() <= 0) { throw new
	 Exception("No se puede realizar el pago, saldo insuficiente"); } Movimiento
	 movimiento = new Movimiento(); movimiento.setTipo(tipo);
	 movimiento.setImporte(importe); movimiento.setCuenta(cuenta);
	 movimientoRepository.save(movimiento); return actualizarSaldo(cuenta, tipo,
	 importe); }
	  
	 @Override public Cuenta actualizarSaldo(Cuenta cuenta, MovimientosEnum tipo,
	 double importe) { switch (tipo) { case INGRESO: case PRESTAMO:
	 cuenta.setSaldo(cuenta.getSaldo() + importe); break; case PAGO: case
	 AMORTIZACIÓN: case INTERES: cuenta.setSaldo(cuenta.getSaldo() - importe);
	 break; } return cuentaRepository.save(cuenta); }
	 
	   public List<Movimiento> getMovimientosByCuentaId(Integer num_cuenta) {

	        return movimientoRepository.findByCuenta(num_cuenta);
	 
	   }	
	   
	
}