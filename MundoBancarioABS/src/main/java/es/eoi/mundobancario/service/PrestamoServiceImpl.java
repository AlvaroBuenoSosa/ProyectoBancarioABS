package es.eoi.mundobancario.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.eoi.mundobancario.entity.Amortizacion;
import es.eoi.mundobancario.entity.Cuenta;
import es.eoi.mundobancario.entity.Movimiento;
import es.eoi.mundobancario.entity.Prestamo;
import es.eoi.mundobancario.enums.MovimientosEnum;
import es.eoi.mundobancario.repository.AmortizacionRepository;
import es.eoi.mundobancario.repository.CuentasRepository;
import es.eoi.mundobancario.repository.MovimientoRepository;
import es.eoi.mundobancario.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
    private CuentasRepository cuentaRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private AmortizacionRepository amortizacionRepository;

	/*
	 * @Override
	 * 
	 * @Transactional public void solicitarPrestamo(Integer num_cuenta, Double
	 * importe, Double plazos) { // Miramos si hay un prestamo actual if
	 * (prestamoRepository.existsByCuentaIdAndAmortizaciones_PagadaFalse(num_cuenta)
	 * ) { throw new
	 * IllegalStateException("No se puede solicitar un nuevo préstamo hasta que el actual sea amortizado."
	 * ); }
	 * 
	 * // Buscamos la cuenta Cuenta cuenta =
	 * cuentaRepository.findById(num_cuenta).orElseThrow(() -> new
	 * IllegalArgumentException("Cuenta no encontrada"));
	 * 
	 * // Creamos y guardamos el prestamos Prestamo prestamo = new Prestamo();
	 * prestamo.setCuenta(cuenta); prestamo.setImporte(importe);
	 * prestamo.setPlazos(plazos); prestamo.setFecha(LocalDateTime.now());
	 * prestamoRepository.save(prestamo);
	 * 
	 * // Actualizamos el saldo de la cuenta cuenta.setSaldo(cuenta.getSaldo() +
	 * importe); cuentaRepository.save(cuenta);
	 * 
	 * // Creamos y guardamos el movimiento Movimiento movimiento = new
	 * Movimiento(); movimiento.setCuenta(cuenta);
	 * movimiento.setFecha(LocalDateTime.now()); movimiento.setImporte(importe);
	 * movimiento.setTipo(MovimientosEnum.PRESTAMO);
	 * movimientoRepository.save(movimiento);
	 * 
	 * // Creamos las amortizaciones double importePorPlazo = importe / plazos;
	 * List<Amortizacion> amortizaciones = new ArrayList<>(); for (int i = 1; i <=
	 * plazos; i++) { Amortizacion amortizacion = new Amortizacion();
	 * amortizacion.setPrestamo(prestamo);
	 * amortizacion.setFecha(LocalDateTime.now().plusMonths(i));
	 * amortizacion.setImporte(importePorPlazo); amortizacion.setPagada(false);
	 * amortizaciones.add(amortizacion); }
	 * amortizacionRepository.saveAll(amortizaciones); }
	 * 
	 * @Override
	 * 
	 * @Transactional public void revisarAmortizaciones() { List<Amortizacion>
	 * amortizaciones =
	 * amortizacionRepository.findByFechaAndPagadaFalse(LocalDateTime.now().withHour
	 * (0).withMinute(0).withSecond(0).withNano(0)); for (Amortizacion amortizacion
	 * : amortizaciones) { Cuenta cuenta = amortizacion.getPrestamo().getCuenta();
	 * 
	 * // Creamos el movimientos de la amortizacion Movimiento
	 * amortizacionMovimiento = new Movimiento();
	 * amortizacionMovimiento.setCuenta(cuenta);
	 * amortizacionMovimiento.setFecha(LocalDateTime.now());
	 * amortizacionMovimiento.setImporte(amortizacion.getImporte());
	 * amortizacionMovimiento.setTipo(MovimientosEnum.AMORTIZACIÓN);
	 * movimientoRepository.save(amortizacionMovimiento);
	 * 
	 * // Actualizar el saldo actual cuenta.setSaldo(cuenta.getSaldo() -
	 * amortizacion.getImporte());
	 * 
	 * // Crear el interes del movimiento double interes = amortizacion.getImporte()
	 * 0.02; Movimiento interesMovimiento = new Movimiento();
	 * interesMovimiento.setCuenta(cuenta);
	 * interesMovimiento.setFecha(LocalDateTime.now());
	 * interesMovimiento.setImporte(interes);
	 * interesMovimiento.setTipo(MovimientosEnum.INTERES);
	 * movimientoRepository.save(interesMovimiento);
	 * 
	 * 
	 * } }
	 */


}
