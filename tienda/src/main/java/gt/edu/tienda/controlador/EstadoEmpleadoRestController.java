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


import gt.edu.tienda.service.IEstadoEmpleadoService;
import gt.edu.tienda.implementacion.Mensaje;
import gt.edu.tienda.modelo.EstadoEmpleado;

@RestController
@RequestMapping("/estadoempleado")
public class EstadoEmpleadoRestController {

	@Autowired
	private IEstadoEmpleadoService estadoempleadoService;
	
	@GetMapping("/")
	public ResponseEntity<List<EstadoEmpleado>> getAll(){
		List<EstadoEmpleado> list = estadoempleadoService.getAll();
		return new ResponseEntity<List<EstadoEmpleado>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EstadoEmpleado> save(@RequestBody EstadoEmpleado estadoempleado) {
		if(StringUtils.isEmpty(estadoempleado.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<EstadoEmpleado>(estadoempleadoService.save(estadoempleado), HttpStatus.OK);
		}
	}
	
	@PutMapping
	public ResponseEntity<EstadoEmpleado> update(@RequestBody EstadoEmpleado estadoempleado) {
		if(StringUtils.isEmpty(estadoempleado.getDescripcion())) {
			return new ResponseEntity(new Mensaje("La descripcion del Estado es obligatorio"), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<EstadoEmpleado>(estadoempleadoService.save(estadoempleado), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{estadoempleado_id}")
	public ResponseEntity delete(@PathVariable int estadoempleado_id) {
		
		EstadoEmpleado estadoempleado = estadoempleadoService.get(estadoempleado_id);
		
		if(estadoempleado == null) {
			return new ResponseEntity(new Mensaje("El Estado no existe"), HttpStatus.NOT_FOUND);
		} else {
			estadoempleadoService.delete(estadoempleado_id);
			return new ResponseEntity(new Mensaje("Estado eliminado"), HttpStatus.OK);
		}
	}
	
	@GetMapping("/{estadoempleado_id}")
	public ResponseEntity<EstadoEmpleado> getById(@PathVariable int estadoempleado_id) {
		
		EstadoEmpleado estadoempleado = estadoempleadoService.get(estadoempleado_id);
		
		if(estadoempleado == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<EstadoEmpleado>(estadoempleado, HttpStatus.OK);
	}
	
	@GetMapping("/descripcion/{estadoempleado_descripcion}")
	public ResponseEntity<EstadoEmpleado> getByDescripcion(@PathVariable String estadoempleado_descripcion) {
		
		EstadoEmpleado estadoempleado = estadoempleadoService.findByDescripcion(estadoempleado_descripcion).get();
		
		if(estadoempleado == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<EstadoEmpleado>(estadoempleado, HttpStatus.OK);
	}

	@GetMapping("/descripcion/like/{estadoempleado_descripcion}")
	public ResponseEntity<List<EstadoEmpleado>> getByLikeDescripcion(@PathVariable String estadoempleado_descripcion) {
		
		List<EstadoEmpleado> listestadoempleado = estadoempleadoService.findByLikeDescripcion(estadoempleado_descripcion);
		
		if(listestadoempleado == null) {
			return new ResponseEntity(new Mensaje("Estado no existe"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<EstadoEmpleado>>(listestadoempleado, HttpStatus.OK);
	}
	
	
	
}
