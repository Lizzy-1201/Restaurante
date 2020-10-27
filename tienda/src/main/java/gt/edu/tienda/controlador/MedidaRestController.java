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


import gt.edu.tienda.service.IMedidaService;
import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.modelo.Medida;

@RestController
@RequestMapping("/medida")
public class MedidaRestController {

	@Autowired
	private IMedidaService medidaService;
	
	@GetMapping("/")
	public ResponseEntity<List<Medida>> getAll(){
		List<Medida> list = medidaService.getAll();
		return new ResponseEntity<List<Medida>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Medida> save(@RequestBody Medida medida) {
		if(StringUtils.isEmpty(medida.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Medida>(medidaService.save(medida), HttpStatus.OK);
		}
	}
	
	@PutMapping
	public ResponseEntity<Medida> update(@RequestBody Medida medida) {
		if(StringUtils.isEmpty(medida.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Medida>(medidaService.save(medida), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{medida_id}")
	public ResponseEntity delete(@PathVariable int medida_id) {
		
		Medida medida = medidaService.get(medida_id);
		
		if(medida == null) {
			return new ResponseEntity(new Mensaje("El medida no existe"), HttpStatus.NOT_FOUND);
		} else {
			medidaService.delete(medida_id);
			return new ResponseEntity(new Mensaje("Medida eliminado"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{medida_id}")
	public ResponseEntity<Medida> get(@PathVariable int medida_id) {
		
		Medida medida = medidaService.get(medida_id);
		
		if(medida == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Medida>(medida, HttpStatus.OK);
	}
	
	@GetMapping("/descripcion/{medida_descripcion}")
	public ResponseEntity<Medida> getByDescripcion(@PathVariable String medida_descripcion) {
		
		Medida medida = medidaService.findByDescripcion(medida_descripcion).get();
		
		if(medida == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Medida>(medida, HttpStatus.OK);
	}

	@GetMapping("/descripcion/like/{medida_descripcion}")
	public ResponseEntity<List<Medida>> getByLikeDescripcion(@PathVariable String medida_descripcion) {
		
		List<Medida> listmedida = medidaService.findByLikeDescripcion(medida_descripcion);
		
		if(listmedida == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Medida>>(listmedida, HttpStatus.OK);
	}
	
	
	
}
