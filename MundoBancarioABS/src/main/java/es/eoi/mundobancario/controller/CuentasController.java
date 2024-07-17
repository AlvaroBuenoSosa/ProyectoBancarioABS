package es.eoi.mundobancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import es.eoi.mundobancario.entity.Cuenta;
import es.eoi.mundobancario.entity.Movimiento;
import es.eoi.mundobancario.entity.Prestamo;
import es.eoi.mundobancario.enums.MovimientosEnum;
import es.eoi.mundobancario.service.CuentasService;
import es.eoi.mundobancario.service.MovimientoService;


@RestController
@RequestMapping("/Cuentas")
public class CuentasController {
	
	@Autowired
	CuentasService cuentasService;
	
	@Autowired
    MovimientoService movimientoService;
	
	@GetMapping
	public ResponseEntity<List<Cuenta>> obtenerCuentas(){
		
		List<Cuenta> cuentas = cuentasService.encontrarCuentas();
		return ResponseEntity.ok(cuentas);
		
	}
	
	@GetMapping("/deudoras")
    public List<Cuenta> obtenerCuentasDeudoras() {
        return cuentasService.obtenerCuentasDeudoras();
    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Cuenta> obtenerCuenta(@PathVariable Integer id) {
	        Cuenta cuenta = cuentasService.obtenerCuentaPorId(id);
	        return ResponseEntity.ok(cuenta);
	    }
	 
	 @PostMapping
	    public ResponseEntity<Cuenta> agregarCuenta(@RequestBody Cuenta nuevaCuenta) {
	        Cuenta cuentaAgregada = cuentasService.agregarCuenta(nuevaCuenta);
	        return ResponseEntity.ok(cuentaAgregada);
	    }
	 
	 @PutMapping("/{id}")
	    public ResponseEntity<String> actualizarAlias(@PathVariable Integer id, @RequestBody String nuevoAlias) {
		 cuentasService.updateAlias(id, nuevoAlias);
	        return ResponseEntity.ok("Alias actualizado correctamente");
	    }

	    @GetMapping("/{num_cuenta}/movimientos")
	    public Cuenta obtenerMovimientosPorCuenta(@PathVariable("num_cuenta") Integer numCuenta) {
	        // Llama al servicio para obtener los movimientos de la cuenta con numCuenta
	        return cuentasService.obtenerCuentaPorId(numCuenta); 
	    }
	 @PostMapping("/{id}/movimientos")
	    public ResponseEntity<String> realizarMovimiento(@PathVariable Integer id,
	                                                     @RequestParam MovimientosEnum tipo,
	                                                     @RequestParam double importe) {
	        try {
	            cuentasService.realizarMovimiento(id, tipo, importe);
	            return ResponseEntity.ok("Movimiento realizado con éxito");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	 
}