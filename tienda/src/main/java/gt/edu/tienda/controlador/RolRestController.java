package gt.edu.tienda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.tienda.modelo.Rol;
import gt.edu.tienda.service.IRolService;

@RestController
@RequestMapping("/rol")
public class RolRestController {

	@Autowired
	private IRolService rolService;
	
	@GetMapping("/")
	public List<Rol> getAll(){
		return rolService.getAll();
	}
	
	@PostMapping
	public void save(Rol rol) {
		if (rol.getDescripcion() != null) {
			rolService.save(rol);
		}
	}
	
	@PutMapping
	public Rol update(@RequestBody Rol rol) {
		rolService.save(rol);
		return rol;
	}

	@DeleteMapping("/{rol_id}")
	public void delete(@PathVariable int rol_id) {
		
		// Busca el registro en la base de datos
		Rol rol = rolService.get(rol_id);
		
		// Si no existe entonces lanza mensaje
		if(rol == null) {
			throw new RuntimeException("Rol no encontrado "+rol_id); 
			// De lo contrario lo elimina
		} else {
			rolService.delete(rol_id);
		}
	}
	
	@GetMapping("/{rol_id}")
	public Rol get(@PathVariable int rol_id) {
		// Busca el registro en la base de datos
		Rol rol = rolService.get(rol_id);
		
		// Si no existe entonces lanza mensaje
		if(rol == null) {
			throw new RuntimeException("Rol no encontrado "+rol_id); 
			
		} 
		return rol;
	}
	
}
