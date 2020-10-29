package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import gt.edu.tienda.modelo.TipoTransaccion;
import gt.edu.tienda.service.ITipoTransaccionService;

@RestController
@RequestMapping("/tipoTransaccion")
public class TipoTransaccionRestController {

	@Autowired
	private ITipoTransaccionService tipTransaService;
	
	@GetMapping("/")
	public ResponseEntity<List<TipoTransaccion>> getAll(){
		List<TipoTransaccion> list = tipTransaService.getAll();
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No existen datos"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TipoTransaccion>>(list, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<TipoTransaccion> save(@RequestBody TipoTransaccion ttr) {
		if (StringUtils.isEmpty(ttr.getDescripcion())) {
			return new ResponseEntity(new Mensaje("Descripción es obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			if (StringUtils.isEmpty(ttr.getFactor())) {
				return new ResponseEntity(new Mensaje("Factor es obligatorio"), HttpStatus.BAD_REQUEST);			
			} else {
				return new ResponseEntity<TipoTransaccion>(tipTransaService.save(ttr), HttpStatus.OK);
			}
		}
	}
	
	@PutMapping
	public ResponseEntity<TipoTransaccion> update(@RequestBody TipoTransaccion ttr) {
		if (StringUtils.isEmpty(ttr.getDescripcion())) {
			return new ResponseEntity(new Mensaje("Descripción es obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			if (StringUtils.isEmpty(ttr.getFactor())) {
				return new ResponseEntity(new Mensaje("Factor es obligatorio"), HttpStatus.BAD_REQUEST);			
			} else {
				return new ResponseEntity<TipoTransaccion>(tipTransaService.save(ttr), HttpStatus.OK);
			}
		}
	}
	
	@DeleteMapping("/{tipo_transa_id}")
	public ResponseEntity delete(@PathVariable int tipo_transa_id) {
		
		TipoTransaccion ttr = tipTransaService.get(tipo_transa_id);
		
		if(ttr == null) {
			return new ResponseEntity(new Mensaje("Tipo de transacción no encontrada"), HttpStatus.NOT_FOUND);
		} else {
			tipTransaService.delete(tipo_transa_id);
			return new ResponseEntity(new Mensaje("Tipo de transacción eliminada"), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/{tipo_transa_id}")
	public ResponseEntity<TipoTransaccion> getById(@PathVariable int tipo_transa_id) {
		
		TipoTransaccion ttr = tipTransaService.get(tipo_transa_id);
		
		if(ttr == null) {
			return new ResponseEntity(new Mensaje("Tipo de transacción no encontrada"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<TipoTransaccion>(ttr, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/factor/{factor}")
	public ResponseEntity<List<TipoTransaccion>> getByFactor(@PathVariable int factor){
		
		List<TipoTransaccion> list = tipTransaService.findByFactor(factor);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("No se encontraron registros"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<TipoTransaccion>>(list, HttpStatus.OK);
		}
		
		
	}

}
