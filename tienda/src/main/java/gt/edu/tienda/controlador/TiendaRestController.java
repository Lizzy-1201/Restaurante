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

import gt.edu.tienda.modelo.Tienda;
import gt.edu.tienda.service.ITiendaService;

@RestController
@RequestMapping("/tienda")
public class TiendaRestController {
	
	@Autowired
	private ITiendaService tiendaService;
	
	@GetMapping("/")
	public List<Tienda> getAll(){
		return tiendaService.getAll();
	}
	
	@PostMapping
	public void save(Tienda t) {
		if(t.getDireccion() != null) {
			tiendaService.save(t);
		}
	}
	
	@PutMapping
	public Tienda update (@RequestBody Tienda tienda) {
		tiendaService.save(tienda);
		return tienda;
	}
	
	@DeleteMapping("/{tienda_id}")
	public void delete(@PathVariable int tienda_id) {
		
		// Busca el registro en la base de datos
		Tienda tienda = tiendaService.get(tienda_id);
		
		if (tienda == null) {
			throw new RuntimeException("Rol no encontrado "+tienda_id);
		} else {
			tiendaService.delete(tienda_id);
		}
	}
	
	@GetMapping("/{tienda_id}")
	public Tienda get(@PathVariable int tienda_id) {
		
		// Busca el registro en la base de datos
		Tienda tienda = tiendaService.get(tienda_id);
		
		if (tienda == null) {
			throw new RuntimeException("Rol no encontrado "+tienda_id);
		} 
		
		return tienda;
	}

	
}
