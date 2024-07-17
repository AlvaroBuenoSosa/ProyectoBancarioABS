package es.eoi.mundobancario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.eoi.mundobancario.entity.Movimiento;
import es.eoi.mundobancario.service.MovimientoService;

@RestController
@RequestMapping("/cuentas")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/{id}/movimientos")
    public List<Movimiento> obtenerMovimientos(@PathVariable Integer id) {
        return movimientoService.obtenerMovimientosPorCuenta(id);
    }
}