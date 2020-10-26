package gt.edu.tienda.controlador;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.modelo.TransaccionInventario;
import gt.edu.tienda.modelo.TransaccionInventarioDetalle;
import gt.edu.tienda.service.ITransaccionInventarioDetalleService;
import gt.edu.tienda.service.ITransaccionInventarioService;

@RestController
@RequestMapping("/transaccionInventario")
public class TransaccionInventarioRestController {

	@Autowired
	private ITransaccionInventarioService transaccionService;
	
	@Autowired
	private ITransaccionInventarioDetalleService transaccionDetalleService;
	
	@GetMapping("/")
	public ResponseEntity<List<TransaccionInventario>> getAll(){
		List<TransaccionInventario> list = transaccionService.getAll();
		return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TransaccionInventario> save(
			@RequestBody TransaccionInventario ti
			) {
		if(StringUtils.isEmpty(ti.getIdEmpleado())) {
			return new ResponseEntity(new Mensaje("Empleado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			if(StringUtils.isEmpty(ti.getIdTienda())) {
				return new ResponseEntity(new Mensaje("Tienda es obligatorio"), HttpStatus.BAD_REQUEST);
			} else {
				if(StringUtils.isEmpty(ti.getIdTipo())) {
					return new ResponseEntity(new Mensaje("Tipo de transacción es obligatorio"), HttpStatus.BAD_REQUEST);
				} else {
					if(StringUtils.isEmpty(ti.getAnio())) {
						return new ResponseEntity(new Mensaje("Año es obligatorio"), HttpStatus.BAD_REQUEST);
					} else {
						if(StringUtils.isEmpty(ti.getIdPeriodo())) {
							return new ResponseEntity(new Mensaje("Periodo contable es obligatorio"), HttpStatus.BAD_REQUEST);
						} else {
							if(StringUtils.isEmpty(ti.getFecha())) {
								return new ResponseEntity(new Mensaje("Fecha es obligatorio"), HttpStatus.BAD_REQUEST);
							} else {
								TransaccionInventario maestro = new TransaccionInventario();
								
								for(TransaccionInventarioDetalle tid : ti.getDetalles()) {
									
								}
								return new ResponseEntity<TransaccionInventario>(transaccionService.save(ti), HttpStatus.OK);
								//return new  ResponseEntity<TransaccionInventario>(maestro, HttpStatus.OK);
							}
							
						}
						
					}
					
				}
				
			}
			
		}
	}
	
	@PutMapping
	public ResponseEntity<TransaccionInventario> update(
			@RequestBody TransaccionInventario ti
			) {
		if(StringUtils.isEmpty(ti.getIdEmpleado())) {
			return new ResponseEntity(new Mensaje("Empleado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			if(StringUtils.isEmpty(ti.getIdTienda())) {
				return new ResponseEntity(new Mensaje("Tienda es obligatorio"), HttpStatus.BAD_REQUEST);
			} else {
				if(StringUtils.isEmpty(ti.getIdTipo())) {
					return new ResponseEntity(new Mensaje("Tipo de transacción es obligatorio"), HttpStatus.BAD_REQUEST);
				} else {
					if(StringUtils.isEmpty(ti.getAnio())) {
						return new ResponseEntity(new Mensaje("Año es obligatorio"), HttpStatus.BAD_REQUEST);
					} else {
						if(StringUtils.isEmpty(ti.getIdPeriodo())) {
							return new ResponseEntity(new Mensaje("Periodo contable es obligatorio"), HttpStatus.BAD_REQUEST);
						} else {
							if(StringUtils.isEmpty(ti.getFecha())) {
								return new ResponseEntity(new Mensaje("Fecha es obligatorio"), HttpStatus.BAD_REQUEST);
							} else {
								// Crea el maestro de la transacción
								TransaccionInventario master = transaccionService.save(ti);
								// Verifica si lleva detalle
								if (master.getDetalles().isEmpty()) {
									
								}
								return new ResponseEntity<TransaccionInventario>(transaccionService.save(ti), HttpStatus.OK);
							}
							
						}
						
					}
					
				}
				
			}
			
		}
	}
	
	@DeleteMapping("/{transaccion_id}")
	public ResponseEntity delete(@PathVariable int transaccion_id) {
		
		TransaccionInventario ti = transaccionService.get(transaccion_id);
		
		if(ti == null) {
			return new ResponseEntity(new Mensaje("Transacción no existe"), HttpStatus.NOT_FOUND);
		} else {
			transaccionService.delete(transaccion_id);
			return new ResponseEntity(new Mensaje("Transacción eliminada"), HttpStatus.OK);			
		}
	}
	
	@GetMapping("/{transaccion_id}")
	public ResponseEntity<TransaccionInventario> getById(@PathVariable int transaccion_id) {
		
		TransaccionInventario ti = transaccionService.get(transaccion_id);
		
		if(ti == null) {
			return new ResponseEntity(new Mensaje("Transacción no existe"), HttpStatus.NOT_FOUND);
		} else {
			transaccionService.delete(transaccion_id);
			return new ResponseEntity<TransaccionInventario>(ti, HttpStatus.OK);			
		}
	}
	
	
	@GetMapping("/porFecha/{fecha}")
	public ResponseEntity<List<TransaccionInventario>> getByFecha(
			@PathVariable("fecha")
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			Date fecha
			){
		
		List<TransaccionInventario> list = transaccionService.getByFecha(fecha);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(path = "/porFecha/Entre", params = {"fecha1","fecha2"})
	public ResponseEntity<List<TransaccionInventario>> getByFechaEntre(
			@Param("fecha1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha1,
			@Param("fecha2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha2
			){
		
		List<TransaccionInventario> list = transaccionService.getByFechaEntre(fecha1, fecha2);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porFecha/condicion/MenorIgualA/{fecha}")
	public ResponseEntity<List<TransaccionInventario>> getByFechaMenorIgualA(
			@PathVariable 
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			Date fecha){
		
		List<TransaccionInventario> list = transaccionService.getByFechaMenorIgualA(fecha);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porFecha/condicion2/MenorIgualA/{fecha}")
	public ResponseEntity<List<TransaccionInventario>> getByFechaMayorIgualA(
			@PathVariable("fecha")
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			Date fecha
			){
		
		List<TransaccionInventario> list = transaccionService.getByFechaMayorIgualA(fecha);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porDoctoReferencia/{referencia}")
	public ResponseEntity<TransaccionInventario> getByReferencia(
			@PathVariable("referencia") String referencia){
		
		TransaccionInventario ti;
		try {
			ti = transaccionService.getByReferencia(referencia).get();
		} catch (NoSuchElementException e) {
			ti = null;
		}
		
		if(ti == null) {
			return new ResponseEntity(new Mensaje("No existen registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<TransaccionInventario>(ti, HttpStatus.OK);			
		}
	}
	
	@GetMapping("/porEmpleado/{id_empleado}")
	public ResponseEntity<List<TransaccionInventario>> getByIdEmpleado(
			@PathVariable("id_empleado")
			int idEmpleado){
		
		List<TransaccionInventario> list = transaccionService.getByIdEmpleado(idEmpleado);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"),HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porAnio/{anio}")
	public ResponseEntity<List<TransaccionInventario>> getByAnio(
			@PathVariable("anio")
			int anio){
		
		List<TransaccionInventario> list = transaccionService.getByAnio(anio);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"),HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}

	@GetMapping(path = "/porAnio/porPeriodo/", params = {"anio","periodo"})
	public ResponseEntity<List<TransaccionInventario>> getByAnioPeriodo(
			@Param("anio")
			int anio,
			@Param("periodo")
			int periodo){
		
		List<TransaccionInventario> list = transaccionService.getByAnioPeriodo(anio, periodo);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"),HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porProveedor/{id_proveedor}")
	public ResponseEntity<List<TransaccionInventario>> getByProveedor(
			@PathVariable("id_proveedor") int proveedor){
		
		List<TransaccionInventario> list = transaccionService.getByIdProveedor(proveedor);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen registros"),HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TransaccionInventario>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/porTransaccionOrigen/{transaccion_id}")
	public ResponseEntity<TransaccionInventario> getByTransaccionOrigen(
			@PathVariable("transaccion_id") int origen){
		
		TransaccionInventario ti;
		try {
			ti = transaccionService.getByTransaccionOrigen(origen).get();
		} catch (NoSuchElementException e) {
			ti = null;
		}
		
		if(ti == null) {
			return new ResponseEntity(new Mensaje("No existen registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<TransaccionInventario>(ti, HttpStatus.OK);
		}
	}
	
}
