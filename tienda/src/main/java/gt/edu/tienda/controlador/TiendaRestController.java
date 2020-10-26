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
import gt.edu.tienda.modelo.Tienda;
import gt.edu.tienda.service.ITiendaService;

@RestController
@RequestMapping("/tienda")
public class TiendaRestController {
	
	@Autowired
	private ITiendaService tiendaService;
	
	@GetMapping("/")
	public ResponseEntity<List<Tienda>> getAll(){
		List<Tienda> list = tiendaService.getAll();
		return new ResponseEntity<List<Tienda>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Tienda> save(@RequestBody Tienda t) {
		if(StringUtils.isEmpty(t.getDireccion())) {
			return new ResponseEntity(new Mensaje("Dirección es obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Tienda>(tiendaService.save(t), HttpStatus.OK);
		}
	}
	
	@PutMapping
	public ResponseEntity<Tienda> update(@RequestBody Tienda t) {
		if(StringUtils.isEmpty(t.getDireccion())) {
			return new ResponseEntity(new Mensaje("Dirección es obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Tienda>(tiendaService.save(t), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{tienda_id}")
	public ResponseEntity delete(@PathVariable int tienda_id) {
		
		// Busca el registro en la base de datos
		Tienda tienda = tiendaService.get(tienda_id);
		
		if (tienda == null) {
			return new ResponseEntity(new Mensaje("Tienda no existe"), HttpStatus.NOT_FOUND);
		} else {
			tiendaService.delete(tienda_id);
			return new ResponseEntity(new Mensaje("Tienda eliminada"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{tienda_id}")
	public ResponseEntity<Tienda> getById(@PathVariable int tienda_id) {
		
		// Busca el registro en la base de datos
		Tienda tienda = tiendaService.get(tienda_id);
		
		if (tienda == null) {
			return new ResponseEntity(new Mensaje("Tienda no existe"), HttpStatus.NOT_FOUND);
		} else {
			tiendaService.delete(tienda_id);
			return new ResponseEntity(tienda, HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/direccion/like/{tienda_direccion}")
	public ResponseEntity<List<Tienda>> getTiendaByLikeDireccion(@PathVariable String tienda_direccion){
		
		List<Tienda> list = tiendaService.findByLikeDireccion(tienda_direccion);
		
		if(list.isEmpty()) {
			return new ResponseEntity(new Mensaje("Tienda no existe"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<Tienda>>(list, HttpStatus.OK);
		}
	}

	
}
