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
import gt.edu.tienda.modelo.Rol;
import gt.edu.tienda.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolRestController {

	@Autowired
	private IRolService rolService;
	
	@GetMapping("/")
	public ResponseEntity<List<Rol>> getAll(){
		List<Rol> list = rolService.getAll(); 
		return new ResponseEntity<List<Rol>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> save(@RequestBody Rol rol) {
		if (StringUtils.isEmpty(rol.getDescripcion())) {
			return new ResponseEntity(new Mensaje("Descripción obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			
			return new ResponseEntity<Rol>(rolService.save(rol), HttpStatus.OK);			
		}
	}
	
	@PutMapping
	public ResponseEntity<Rol> update(@RequestBody Rol rol) {
		if (StringUtils.isEmpty(rol.getDescripcion())) {
			return new ResponseEntity(new Mensaje("Descripción obligatoria"), HttpStatus.BAD_REQUEST);
		} else {
			
			return new ResponseEntity<Rol>(rolService.save(rol), HttpStatus.OK);			
		}
	}

	@DeleteMapping("/{rol_id}")
	public ResponseEntity delete(@PathVariable int rol_id) {
		
		// Busca el registro en la base de datos
		Rol rol = rolService.get(rol_id);
		
		// Si no existe entonces lanza mensaje
		if(rol == null) {
			return new ResponseEntity(new Mensaje("Rol no existe"), HttpStatus.NOT_FOUND);
			// De lo contrario lo elimina
		} else {
			rolService.delete(rol_id);
			return new ResponseEntity(new Mensaje("Rol eliminado"), HttpStatus.OK);
			
		}
	}
	
	@GetMapping("/{rol_id}")
	public ResponseEntity<Rol> getById(@PathVariable int rol_id) {
		// Busca el registro en la base de datos
		Rol rol = rolService.get(rol_id);
		
		// Si no existe entonces lanza mensaje
		if(rol == null) {
			return new ResponseEntity(new Mensaje("Rol no existe"), HttpStatus.NOT_FOUND);
			// De lo contrario lo elimina
		} else {
			return new ResponseEntity<Rol>(rol, HttpStatus.OK);
			
		}
	}
	
}
